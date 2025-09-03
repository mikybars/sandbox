package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExternosMeta4Service;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ReglaEmpleadoExternoMeta4Service;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarExternosMeta4ServiceImpl implements RunTareaAmbitoValidarExternosMeta4Service {

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

  @Override
  public ValidacionDto execute(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {

    final List<IdPersonaLocalExternaDto> externos = new ArrayList<>();

    // Obtenemos las reglas activas para la tarea
    final Optional<List<ReglaEmpleadoExternoMeta4RequestDto>> reglas =
        Optional.ofNullable(
            this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(tareaAmbito.getCclIdOrigen(),
                runTarea.getTarea().getStdIdLegEnt()));

    reglas.ifPresent(reglaEmpleadoExternoMeta4RequestDtos -> this.processReglas(reglaEmpleadoExternoMeta4RequestDtos, runTarea, externos));

    this.saveExternos(externos, runTarea);

    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }

  private void processReglas(List<ReglaEmpleadoExternoMeta4RequestDto> reglas, RunTareaDto runTarea,
      List<IdPersonaLocalExternaDto> externos) {
    final List<EmpleadoExternoDTO> excluidosMeta4 = new ArrayList<>();

    // Peticion por cada valor diferente de STD_ID_HR_TYPE
    reglas.forEach(obj -> {
      final List<Integer> puestos = obj.getPuestos();
      final List<Long> mappedPuestos = puestos == null || puestos.isEmpty() ? List.of() : puestos.stream().map(Integer::longValue).toList();

      excluidosMeta4.addAll(this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(obj.getIdOrganization(),
          runTarea.getTarea().getFechaInicioPeriodo(), runTarea.getTarea().getFechaFinPeriodo(), mappedPuestos, obj.getStdIdHrType()));
    });

    this.processExcluidosMeta4(excluidosMeta4, externos);
  }

  private void processExcluidosMeta4(List<EmpleadoExternoDTO> excluidosMeta4, List<IdPersonaLocalExternaDto> externos) {
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
        while (iterativeDate.isBefore(intervalo.getFechaHasta())
            || iterativeDate.isEqual(
                Objects.requireNonNull(intervalo.getFechaHasta()))) {
          fechasTrabajadas.add(iterativeDate);
          iterativeDate = iterativeDate.plusDays(1);
        }
      });

      // Ordenamos las fechas de manera ascendente
      final List<LocalDate> fechasTrabajadasSortedList = new ArrayList<>(fechasTrabajadas);
      Collections.sort(fechasTrabajadasSortedList);

      this.calculateIntervals(idPersonaLocal, fechasTrabajadasSortedList, externos);
    }
  }

  private void calculateIntervals(String idPersonaLocal, List<LocalDate> fechasTrabajadasSortedList,
      List<IdPersonaLocalExternaDto> externos) {
    // Algoritmo para el cálculo de intervalos comprometidos por las fechas trabajadas
    LocalDate prevDate = null;
    LocalDate startDate = null;

    // Iteramos por cada fecha trabajada
    for (int i = 0; i <= fechasTrabajadasSortedList.size(); i++) {
      if (prevDate != null
          && (i == fechasTrabajadasSortedList.size()
              || ChronoUnit.DAYS.between(prevDate, fechasTrabajadasSortedList.get(i)) > 1)) {
        externos.add(IdPersonaLocalExternaDto.builder()
            .idPersonaLocal(idPersonaLocal)
            .fechaDesde(startDate)
            .fechaHasta(prevDate).build());
        startDate = null;
      }
      if (startDate == null && i < fechasTrabajadasSortedList.size()) {
        startDate = fechasTrabajadasSortedList.get(i);
      }
      if (i < fechasTrabajadasSortedList.size()) {
        prevDate = fechasTrabajadasSortedList.get(i);
      }
    }
  }

  private void saveExternos(List<IdPersonaLocalExternaDto> externos, RunTareaDto runTarea) {
    this.tareaPersonaExternaRepositoryCustom
        .save(this.tareaPersonaExternaMapper.idPersonaLocalExternaToTareaPersonaExterna(externos,
            runTarea.getTarea()));
  }
}
