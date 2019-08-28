package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;

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
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Transactional
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public List<RunProgramacionDto> run() {
        List<RunProgramacionDto> result = new ArrayList<>();
        programacionService.findPendiente().stream().forEach(programacion -> {
            RunProgramacionDto runProgramacion = RunProgramacionDto.builder().programacion(programacion)
                    .runProgramacionPeriodo(new ArrayList<>()).build();
            programacionService.updateEjecucion(programacion);
            programacion.getAmbito().stream().forEach(programacionAmbito -> {
                PeriodosRequestDto request = new PeriodosRequestDto();
                request.setPage(new PageDto());
                request.setData(new GenericFilterDto());
                request.getData().setItem(new ArrayList<GenericFilterParametersDto>());
                request.getData().getItem()
                        .add(GenericFilterParametersDto.builder().idSociedadReg(programacionAmbito.getIdOrgenization())
                                .abierto(Meta4Constants.TRUE).activo(Meta4Constants.TRUE)
                                .vigente(Meta4Constants.TRUE).build());
                List<PeriodoDto> periodos = periodoMapper
                        .periodoResultItemDtoToPeriodoDto(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
                if (CollectionUtils.isNotEmpty(periodos)) {
                    periodos.stream()
                            .forEach(periodo -> runProgramacion.getRunProgramacionPeriodo()
                                    .add(RunProgramacionPeriodoDto.builder().periodo(periodo)
                                            .programacionAmbito(programacionAmbito)
                                            .trabajo(trabajoService.create(
                                                    trabajoService.merge(programacion, programacionAmbito, periodo)))
                                            .build()));
                } else {
                    log.warn("No existen periodos activos para la organización {}",
                            programacionAmbito.getIdOrgenization());
                }
            });
            result.add(runProgramacion);
        });
        return result;
    }

}