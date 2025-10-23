package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunValidacionesAgrupadasService;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueanteFactory;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunValidacionesAgrupadasServiceImpl implements RunValidacionesAgrupadasService {

  private static final Logger LOG = LoggerFactory.getLogger(RunValidacionesAgrupadasServiceImpl.class);

  private static final List<Integer> ID_ACCIONES_NO_BLOQUEANTES = List.of(32, 33, 34);

  @Value("${metadata.environment}")
  private String environment;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private RunValidacionNoBloqueanteFactory runValidacionNoBloqueanteFactory;

  @Autowired
  private AccionService accionService;

  @Autowired
  private MailService mailService;

  @Autowired
  private MailEntornoService mailEntornoService;

  @Override
  public void ejecutarValidacionesNoBloqueantes(@NotNull @Valid final RunTareaDto runTareaDto,
      @NotNull @Valid final FaseDto faseDto) {

    final TareaDto tareaDto = runTareaDto.getTarea();

    LOG.info("Trabajo[{}]Tarea[{}] :: Ejecutando validaciones no bloqueantes",
        tareaDto.getIdTrabajo(), tareaDto.getId());

    final List<TareaFaseAccionDto> accionesNoBloquantes = this.tareaFaseAccionService
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
            PuntoEjecucionEnum.DESPUES.getId())
        .stream()
        .filter(tfa -> ID_ACCIONES_NO_BLOQUEANTES.contains(tfa.getIdAccion()))
        .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso).reversed())
        .toList();

    if (accionesNoBloquantes.isEmpty()) {
      return;
    }

    final List<CompletableFuture<List<ValidacionDto>>> futures = new ArrayList<>();

    for (final TareaFaseAccionDto tareaFaseAccion : accionesNoBloquantes) {
      try {
        final String nombreAccion = this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre();

        final CompletableFuture<List<ValidacionDto>> future = this.runValidacionNoBloqueanteFactory
            .getRunValidacionNoBloqueante(nombreAccion)
            .execute(runTareaDto, tareaFaseAccion);

        futures.add(future);
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error ejecutando validación idTareaFaseAccion[{}]: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), tareaFaseAccion.getId(), e.getMessage(), e);
      }
    }

    try {
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    } catch (final Exception e) {
      LOG.error("Trabajo[{}]Tarea[{}] :: Error esperando validaciones: {}",
          tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
    }

    final List<ValidacionDto> todasLasValidaciones = futures.stream()
        .map(future -> {
          try {
            return future.join();
          } catch (final Exception e) {
            LOG.error("Trabajo[{}]Tarea[{}] :: Error obteniendo resultado: {}",
                tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
            return new ArrayList<ValidacionDto>();
          }
        })
        .flatMap(List::stream)
        .toList();

    final List<ValidacionDto> validacionesParaNotificar = todasLasValidaciones.stream()
        .filter(v -> Boolean.FALSE.equals(v.getResult()))
        .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso).reversed())
        .toList();

    if (validacionesParaNotificar.isEmpty()) {
      return;
    }

    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      try {
        this.mailService.sendMail(validacionesParaNotificar, runTareaDto);
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error enviando correo: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
      }
    }
  }

}
