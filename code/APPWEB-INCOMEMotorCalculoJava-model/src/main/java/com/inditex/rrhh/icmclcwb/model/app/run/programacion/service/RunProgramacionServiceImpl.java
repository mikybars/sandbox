package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.amigafwk.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.async.service.ProgramacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.RunProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.RunProgramacionPeriodoDTO;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.ms.app.programacion.SenderProgramacion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
@RequiredArgsConstructor
public class RunProgramacionServiceImpl implements RunProgramacionService {

  private static final Logger LOG = LoggerFactory.getLogger(RunProgramacionServiceImpl.class);

  private final ProgramacionService programacionService;

  private final ProgramacionAsyncService programacionAsyncService;

  private final PeriodoMapper periodoMapper;

  private final TrabajoService trabajoService;

  private final SenderProgramacion senderProgramacion;

  private final Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  private final Map<String, Meta4PropertiesDto> meta4Properties;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunProgramacionService.run.timer",
      metricGroupName = "RunProgramacionServiceGroup", metricDescription = "RunProgramacionService.run.timer")
  @CounterFunctionalMetric(metricName = "RunProgramacionService.run.counter",
      metricGroupName = "RunProgramacionServiceGroup", metricDescription = "RunProgramacionService.run.counter")
  @Override
  public RunProgramacionDTO run(@NotNull @Valid final Long id) {
    // Se usa el findById en lugar de findPendienteById id porque ya no están marcadas como pendientes
    final ProgramacionDTO programacion = this.programacionService.findActivoById(id);
    final RunProgramacionDTO runProgramacion = new RunProgramacionDTO();
    runProgramacion.setProgramacion(programacion);
    runProgramacion.setRunProgramacionPeriodo(new ArrayList<>());

    this.programacionService.updateEjecucion(programacion);
    programacion.getAmbito().parallelStream().forEach(programacionAmbito -> {
      final PeriodosRequestDto request = new PeriodosRequestDto();
      request.setData(new GenericFilterDto());
      request.getData().setItem(new ArrayList<GenericFilterParametersDto>());
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.PERIODOS).getPage());
      request.getData()
          .getItem()
          .add(GenericFilterParametersDto.builder()
              .idSociedadReg(programacionAmbito.getIdOrganization())
              .abierto(Meta4Constants.TRUE)
              .activo(Meta4Constants.TRUE)
              .vigente(Meta4Constants.TRUE)
              .build());
      final List<PeriodoDTO> periodos = this.periodoMapper
          .periodoResultItemDtoToPeriodoDto(this.meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
      if (CollectionUtils.isNotEmpty(periodos)) {
        periodos.parallelStream()
            .forEach(periodo -> {
              final RunProgramacionPeriodoDTO runProgramacionPeriodoDTO = new RunProgramacionPeriodoDTO();
              runProgramacionPeriodoDTO.setPeriodo(periodo);
              runProgramacionPeriodoDTO.setProgramacionAmbito(programacionAmbito);
              runProgramacionPeriodoDTO.setTrabajo(this.trabajoService
                  .create(this.trabajoService.merge(programacion, programacionAmbito, periodo)));
              runProgramacion.getRunProgramacionPeriodo()
                  .add(runProgramacionPeriodoDTO);
            });

      } else {
        RunProgramacionServiceImpl.LOG.warn("No existen periodos activos para la organización {}",
            programacionAmbito.getIdOrganization());
      }
    });
    return runProgramacion;

  }

  @Auditoria
  @Override
  public List<RunProgramacionDTO> create() {
    final List<ProgramacionDTO> pendientes = this.programacionService.findPendiente();
    // Obtencion del resultado final sin esperar al envio de las programaciones
    final List<RunProgramacionDTO> result = pendientes.stream()
        .map(programacion -> {
          final RunProgramacionDTO prog = new RunProgramacionDTO();
          prog.setProgramacion(programacion);
          prog.setRunProgramacionPeriodo(new ArrayList<>());
          return prog;
        })
        .collect(Collectors.toList());
    // Se establece la fecha de la siguiente ejecución inmediatamente
    if (CollectionUtils.isNotEmpty(pendientes)) {
      final List<CompletableFuture<?>> cf = new ArrayList<>();
      final CompletableFuture<Void> future = this.programacionAsyncService
          .updateFechaSiguienteEjecucion(pendientes);
      AsyncUtils.exceptionally(future, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
      // Y se envían a la cola
      Flux.fromIterable(pendientes)
          .parallel()
          .runOn(ItxSchedulers.single())
          .subscribe(programacion -> this.senderProgramacion
              .send(IdProgramacionDto.builder().id(programacion.getId()).build()));
    }
    return result;
  }

}
