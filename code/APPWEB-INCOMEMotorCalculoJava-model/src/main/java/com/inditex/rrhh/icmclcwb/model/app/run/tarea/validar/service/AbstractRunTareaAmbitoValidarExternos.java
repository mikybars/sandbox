package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ReglaEmpleadoExternoMeta4Service;
import com.inditex.rrhh.icmclcwb.model.app.mapper.IdPersonaLocalExternaMapper;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRunTareaAmbitoValidarExternos {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractRunTareaAmbitoValidarExternos.class);

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  private TareaPersonaExternaMapper tareaPersonaExternaMapper;

  @Autowired
  private TareaPersonaExternaRepositoryCustom tareaPersonaExternaRepositoryCustom;

  @Autowired
  private IncomeMetaService incomeMetaService;

  @Autowired
  private ReglaEmpleadoExternoMeta4Service reglaEmpleadoExternoMeta4Service;

  @Autowired
  private ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper;

  @Autowired
  private IdPersonaLocalExternaMapper idPersonaLocalExternaMapper;

  protected abstract CompletableFuture<List<IdPersonaLocalExternaDto>> findExternos(final RunTareaDto runTarea,
      TareaAmbitoDto tareaAmbito);

  public ValidacionDto execute(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalExternaDto>> cfExternos = this.findExternos(runTarea, tareaAmbito);
    AsyncUtils.exceptionally(cfExternos, cf);

    AsyncUtils.waitAllOfIsOk(cf, cf);

    final List<IdPersonaLocalExternaDto> externos = AsyncUtils.get(cfExternos);

    final Optional<ReglaEmpleadoExternoMeta4RequestDto> request =
        Optional.ofNullable(
            this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(tareaAmbito.getCclIdOrigen(),
                runTarea.getTarea().getStdIdLegEnt()));

    if (request.isPresent()) {
      final ExternosRequestDTO req =
          this.reglaEmpleadoExternoMeta4Mapper.reglaEmpleadoExternoMeta4RequestDtotoExternosRequestDto(request.get());
      req.setFechaDesde(runTarea.getTarea().getFechaInicioPeriodo());
      req.setFechaHasta(runTarea.getTarea().getFechaFinPeriodo());
      final List<EmpleadoExternoDTO> excluidosMeta4 = this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(req);

      // Agrupamos por empleado
      final Map<String, List<EmpleadoExternoDTO>> excluidosMap =
          excluidosMeta4.stream().collect(groupingBy(EmpleadoExternoDTO::getIdPersonaLocal));

      // Iteramos por cada empleado
      for (final String idPersonaLocal : excluidosMap.keySet()) {
        final Set<LocalDate> fechasTrabajadas = new HashSet<>();
        final List<EmpleadoExternoDTO> listaIntervalosEmpExterno = excluidosMap.get(idPersonaLocal);

        // Iteramos por cada intervalo perteneciente al empleado guardando las fechas en las que trabajo
        listaIntervalosEmpExterno.forEach(intervalo -> {
          LocalDate iterativeDate = intervalo.getFechaDesde();
          while (iterativeDate.isBefore(intervalo.getFechaHasta()) || iterativeDate.isEqual(intervalo.getFechaHasta())) {
            fechasTrabajadas.add(iterativeDate);
            iterativeDate = iterativeDate.plusDays(1);
          }
        });

        // Ordenamos las fechas de manera ascendente
        final List<LocalDate> fechasTrabajadasSortedList = new ArrayList<>(fechasTrabajadas);
        Collections.sort(fechasTrabajadasSortedList);

        // Algoritmo para el cálculo de intervalos comprometidos por las fechas trabajadas
        LocalDate prevDate = null;
        LocalDate startDate = null;

        for (int i = 0; i <= fechasTrabajadasSortedList.size(); i++) {
          if (prevDate != null) {
            if (i == fechasTrabajadasSortedList.size()
                || ChronoUnit.DAYS.between(prevDate, fechasTrabajadasSortedList.get(i)) > 1) {
              externos.add(IdPersonaLocalExternaDto.builder()
                  .idPersonaLocal(idPersonaLocal)
                  .fechaDesde(startDate)
                  .fechaHasta(prevDate).build());
              startDate = null;
            }
          }
          if (startDate == null && i < fechasTrabajadasSortedList.size()) {
            startDate = fechasTrabajadasSortedList.get(i);
          }
          if (i < fechasTrabajadasSortedList.size()) {
            prevDate = fechasTrabajadasSortedList.get(i);
          }
        }
      }
    }

    this.tareaPersonaExternaRepositoryCustom
        .save(this.tareaPersonaExternaMapper.idPersonaLocalExternaToTareaPersonaExterna(externos,
            runTarea.getTarea()));

    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }

}
