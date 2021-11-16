package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDuranteService;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaPrevalidarDuranteServiceImpl implements RunTareaPrevalidarDuranteService {

  @Value("${app.envars.tarea.prevalidacion.thread-size}")
  private Integer threadSize;

  @Autowired
  private LimpiezaService limpiezaService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private RunPrevalidarFactory runPrevalidarFactory;

  @Autowired
  private AccionService accionService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Autowired
  private SenderTarea senderTarea;

  @Autowired
  private MailService mailService;

  @Autowired
  private Logger log;

  @Override
  public void run(@NotNull @Valid final RunTareaDto runTareaDto,
      @NotNull @Valid final FaseDto faseDto,
      @NotNull @Valid final AccionDto accionDto) {
    final TareaDto tareaDto = runTareaDto.getTarea();

    final Map<Integer, List<TareaFaseAccionDto>> fases = this.tareaFaseAccionService
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
            accionDto.getId(),
            PuntoEjecucionEnum.DURANTE.getId())
        .stream()
        .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso)
            .reversed())
        .collect(Collectors.groupingBy(TareaFaseAccionDto::getPeso));

    final List<ValidacionDto> validaciones = new ArrayList<>();

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    for (final Integer pesos : fases.keySet()) {
      for (final TareaFaseAccionDto tareaFaseAccion : fases.get(pesos)) {
        AsyncUtils.checkAsyncAvaliable(cf, this.threadSize);
        final CompletableFuture<List<ValidacionDto>> cfRun = this.runPrevalidarFactory
            .getRunPrevalidar(
                this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre())
            .execute(runTareaDto, tareaFaseAccion);
        AsyncUtils.exceptionally(cfRun, cf);
        final List<ValidacionDto> data = AsyncUtils.get(cfRun);
        validaciones.addAll(data);
      }
    }

    final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
        runTareaDto.getTarea().getId(), faseDto.getId());

    final List<ValidacionDto> fallidas = validaciones.stream()
        .filter(e -> Boolean.FALSE.equals(e.getResult()))
        .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso)
            .reversed())
        .map(e -> {
          final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
              .findById(e.getIdTareaFaseAccion());

          this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
              EstadoTareaFaseAccionEnum.KO.getDto());
          this.tareaFaseService.updateFechaFinAndEstado(tareaFase,
              EstadoTareaFaseEnum.KO.getDto());

          return e;
        })
        .collect(Collectors.toList());

    if (!fallidas.isEmpty()) {
      this.tareaFaseAccionService
          .updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
              tareaFase,
              EstadoTareaFaseAccionEnum.PENDIENTE.getDto(),
              EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
      this.tareaFaseService
          .updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(
              runTareaDto.getTarea(),
              EstadoTareaFaseEnum.PENDIENTE.getDto(),
              EstadoTareaFaseEnum.NO_EJECUTADA.getDto());
      this.tareaFaseService.updateActivo(runTareaDto);
      this.limpiezaService.limpiezaAmbito(runTareaDto.getTarea());

      this.mailService.sendMail(tareaFase, fallidas, runTareaDto);

      fallidas.stream().forEach(e -> {
        if (Boolean.TRUE.equals(e.getSincronizacion())
            && (e.getIdPersonaLocal() != null)
            && !e.getIdPersonaLocal().isEmpty()) {
          final List<SincronizacionFilterParametersDto> filterParameters = e
              .getIdPersonaLocal()
              .stream()
              .map(
                  f -> SincronizacionFilterParametersDto.builder()
                      .idOrigen(e.getCclIdOrigen())
                      .idEmpresa(AppConstants.ID_ORIGEN_SPAIN.equals(e.getCclIdOrigen())
                          ? e.getStdIdLegEnt()
                          : null)
                      .idEmpleado(f)
                      .fechaInicio(tareaDto.getFechaInicioPeriodo())
                      .fechaFin(tareaDto.getFechaFinPeriodo())
                      .build())
              .collect(Collectors.toList());
          final SincronizacionFilterDto filter = SincronizacionFilterDto.builder()
              .items(filterParameters)
              .build();
          final SincronizacionRequestDto request = new SincronizacionRequestDto();
          request.setData(filter);
          this.log.info("Trabajo[{}]Tarea[{}] :: Inicio :: Sincronizacion :: Personas: {}",
              tareaDto.getIdTrabajo(),
              tareaDto.getId(),
              e
                  .getIdPersonaLocal()
                  .size());
          try {
            final SincronizacionResponseDto result = this.meta4IcmWsCalcIncomeService
                .sincronizacion(request);
            this.log.info(
                "Trabajo[{}]Tarea[{}] :: Sincronizacion :: Ok :: Personas: {}",
                tareaDto.getIdTrabajo(),
                tareaDto.getId(),
                result.getData()
                    .stream()
                    .filter(a -> a.getResultado().equals(Meta4Constants.RESULTADO_OK))
                    .map(SincronizacionResultItemDto::getIdEmpleado)
                    .collect(Collectors.toList()));
            this.log.info(
                "Trabajo[{}]Tarea[{}] :: Sincronizacion :: Ko :: Personas: {}",
                tareaDto.getIdTrabajo(),
                tareaDto.getId(),
                result.getData()
                    .stream()
                    .filter(a -> a.getResultado().equals(Meta4Constants.RESULTADO_ERROR))
                    .map(SincronizacionResultItemDto::getIdEmpleado)
                    .collect(Collectors.toList()));
          } catch (final Exception e1) {
            this.log.error(
                "Trabajo[{}]Tarea[{}] :: Sincronizacion :: Error :: Personas: {}",
                tareaDto.getIdTrabajo(),
                tareaDto.getId(),
                e
                    .getIdPersonaLocal());
          }
          this.log.info("Trabajo[{}]Tarea[{}] :: Fin :: Sincronizacion :: Personas: {}",
              tareaDto.getIdTrabajo(),
              tareaDto.getId(),
              e
                  .getIdPersonaLocal()
                  .size());
        }
      });

      final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
          .findById(fallidas.get(0).getIdTareaFaseAccion());
      final AccionDto accion = this.accionService
          .findAccionDtoById(tareaFaseAccion.getIdAccion());

      if (Boolean.TRUE.equals(accion.getEsReaccionReintento())
          && (this.tareaFaseAccionService
              .countReintentosByIdTareaAndIdAccionAndIdEstado(
                  tareaFaseAccion, tareaFase) < accion.getReintentoMax())) {
        if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
          this.senderTarea.sendWithDelay(runTareaDto.getTarea(),
              accion.getReintentoDelay());
        } else {
          this.senderTarea.send(runTareaDto.getTarea());
        }
      }
      throw new ValidationException("Error validando");
    }

  }

}
