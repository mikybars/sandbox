package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.ms.app.programacion.SenderProgramacion;

@Service
@Validated
public class RunProgramacionServiceImpl implements RunProgramacionService {

    @Autowired
    private Logger log;

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private PeriodoMapper periodoMapper;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private SenderProgramacion senderProgramacion;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunProgramacionService.run.timer", metricGroupName = "RunProgramacionServiceGroup", metricDescription = "RunProgramacionService.run.timer")
    @CounterFunctionalMetric(metricName = "RunProgramacionService.run.counter", metricGroupName = "RunProgramacionServiceGroup", metricDescription = "RunProgramacionService.run.counter")
    @Override
    public RunProgramacionDto run(@NotNull @Valid final Long id) {
        ProgramacionDto programacion = programacionService.findPendienteById(id);
        RunProgramacionDto runProgramacion = RunProgramacionDto.builder().programacion(programacion)
                .runProgramacionPeriodo(new ArrayList<>()).build();
        programacionService.updateEjecucion(programacion);
        programacion.getAmbito().stream().forEach(programacionAmbito -> {
            PeriodosRequestDto request = new PeriodosRequestDto();
            request.setData(new GenericFilterDto());
            request.getData().setItem(new ArrayList<GenericFilterParametersDto>());
            request.setPage(meta4Properties.get(Meta4PropertiesConstants.PERIODOS).getPage());
            request.getData().getItem()
                    .add(GenericFilterParametersDto.builder().idSociedadReg(programacionAmbito.getIdOrgenization())
                            .abierto(Meta4Constants.TRUE).activo(Meta4Constants.TRUE).vigente(Meta4Constants.TRUE)
                            .build());
            List<PeriodoDto> periodos = periodoMapper
                    .periodoResultItemDtoToPeriodoDto(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
            if (CollectionUtils.isNotEmpty(periodos)) {
                periodos.stream().forEach(periodo -> runProgramacion.getRunProgramacionPeriodo()
                        .add(RunProgramacionPeriodoDto.builder().periodo(periodo).programacionAmbito(programacionAmbito)
                                .trabajo(trabajoService
                                        .create(trabajoService.merge(programacion, programacionAmbito, periodo)))
                                .build()));
            } else {
                log.warn("No existen periodos activos para la organización {}", programacionAmbito.getIdOrgenization());
            }
        });
        return runProgramacion;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<RunProgramacionDto> create() {
        List<RunProgramacionDto> result = new ArrayList<>();
        programacionService.findPendiente().stream().forEach(programacion -> {
            senderProgramacion.send(IdProgramacionDto.builder().id(programacion.getId()).build());
            RunProgramacionDto runProgramacion = RunProgramacionDto.builder().programacion(programacion)
                    .runProgramacionPeriodo(new ArrayList<>()).build();
            result.add(runProgramacion);
        });
        return result;
    }

}
