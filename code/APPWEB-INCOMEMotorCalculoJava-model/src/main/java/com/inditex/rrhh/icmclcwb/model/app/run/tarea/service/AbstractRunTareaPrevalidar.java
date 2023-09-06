package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationNoReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
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
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.TareaPriorityEnum;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractRunTareaPrevalidar {

  @Value("${app.envars.tarea.prevalidacion.thread-size}")
  private Integer threadSize;

  @Value("${metadata.environment}")
  private String environment;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Autowired
  private RunPrevalidarFactory runPrevalidarFactory;

  @Autowired
  private AccionService accionService;

  @Autowired
  private SenderTarea senderTarea;

  @Autowired
  private MailService mailService;

  @Autowired
  private MailEntornoService mailEntornoService;

  @Autowired
  private LimpiezaService limpiezaService;

  @Autowired
  private Logger log;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  List<ValidacionDto> ejecucion(final RunTareaDto runTareaDto, final Map<Integer, List<TareaFaseAccionDto>> fases) {
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
    return validaciones;
  }

  void sincronizacion(final TareaDto tareaDto, final List<ValidacionDto> fallidas) {
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
  }

  void procesarFallidas(final RunTareaDto runTareaDto, final TareaDto tareaDto, final FaseDto faseDto,
      final List<ValidacionDto> fallidas) {
    final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
        runTareaDto.getTarea().getId(), faseDto.getId());
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
      this.sincronizacion(tareaDto, fallidas);

      final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
          .findById(fallidas.get(0).getIdTareaFaseAccion());
      final AccionDto accion = this.accionService
          .findAccionDtoById(tareaFaseAccion.getIdAccion());

      if (Boolean.TRUE.equals(accion.getEsReaccionReintento())
          && (this.tareaFaseAccionService
              .countReintentosByIdTareaAndIdAccionAndIdEstado(
                  tareaFaseAccion, tareaFase) < accion.getReintentoMax())) {
        if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
          this.senderTarea.sendWithDelayWithPriority(runTareaDto.getTarea(),
              accion.getReintentoDelay(), TareaPriorityEnum.REENCOLADA);
        } else {
          this.senderTarea.sendWithPriority(runTareaDto.getTarea(), TareaPriorityEnum.REENCOLADA);
        }

        throw new ValidationReintentoException(
            "Error validando - idTareaFaseAccion: "
                + String.join(",",
                    fallidas.stream().map(ValidacionDto::getIdTareaFaseAccion).map(x -> x.toString()).collect(Collectors.toList())));
      }
      this.insertarDato(fallidas);
      if (this.mailEntornoService.findEsActivoByEntorno(this.environment)) {
        this.mailService.sendMail(tareaFase, fallidas, runTareaDto);
        if (fallidas.stream().anyMatch(e -> e.getIdMotivosDesplazamiento() != null && e.getIdMotivosDesplazamiento().size() > 0)) {
          this.mailService.sendMailMotivos(runTareaDto, fallidas);
        }
      }
      this.limpiezaService.limpiezaAmbito(runTareaDto.getTarea());

      throw new ValidationNoReintentoException(
          "Error validando - idTareaFaseAccion: "
              + String.join(",",
                  fallidas.stream().map(ValidacionDto::getIdTareaFaseAccion).map(x -> x.toString()).collect(Collectors.toList())));
    }
  }

  void insertarDato(final List<ValidacionDto> fallidas) {
    for (final ValidacionDto fallida : fallidas) {
      final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
          .findById(fallida.getIdTareaFaseAccion());

      final AccionDto accion = this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion());

      // ID_ACCION = 1 -> Motivos
      // ID_ACCION IN (2,5,6,7,8) -> Personas
      // ID_ACCION = 3 -> Fechas => No insertamos
      // ID_ACCION = 4 -> Presencias => TODO: Pensar que informacion insertar
      if (accion.getId() == 1) {
        final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoList = new ArrayList<>();
        fallida.getIdMotivosDesplazamiento().forEach((motivo) -> {
          tareaFaseAccionDatoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
              .idTipoDato(TipoDatoEnum.MOTIVOS_DESPLAZAMIENTO.getId()).dato(motivo.toString()).build());
        });
        this.tareaFaseAccionFallidasService.save(tareaFaseAccionDatoList);
      } else if (Stream.of(2, 5, 6, 7, 8).collect(Collectors.toList()).contains(accion.getId())) {
        final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoList = new ArrayList<>();
        fallida.getIdPersonaLocal().forEach((persona) -> {
          tareaFaseAccionDatoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
              .idTipoDato(TipoDatoEnum.PERSONA.getId()).dato(persona).build());
        });
        this.tareaFaseAccionFallidasService.save(tareaFaseAccionDatoList);
      }
    }
  }

  void actualizaFechasAntes(final RunTareaDto runTareaDto, final FaseDto faseDto, final ValidacionDto e) {
    final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
        runTareaDto.getTarea().getId(), faseDto.getId());
    final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
        .findById(e.getIdTareaFaseAccion());
    this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.KO.getDto());
    this.tareaFaseService.updateFechaInicioAndFechaFinAndEstado(tareaFase,
        EstadoTareaFaseEnum.KO.getDto());
  }

  void actualizaFechas(final RunTareaDto runTareaDto, final FaseDto faseDto, final ValidacionDto e) {
    final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
        runTareaDto.getTarea().getId(), faseDto.getId());
    final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
        .findById(e.getIdTareaFaseAccion());
    this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.KO.getDto());
    this.tareaFaseService.updateFechaFinAndEstado(tareaFase,
        EstadoTareaFaseEnum.KO.getDto());
  }
}
