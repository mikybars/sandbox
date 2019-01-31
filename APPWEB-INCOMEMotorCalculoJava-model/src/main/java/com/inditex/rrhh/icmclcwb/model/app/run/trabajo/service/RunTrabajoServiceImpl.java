package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTrabajoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;

@Service
@Validated
public class RunTrabajoServiceImpl implements RunTrabajoService {

    @Autowired
    private TrabajoService trabajoService;
    
    @Autowired
    private RunTrabajoRecolectarService runTrabajoRecolectarService;

    @Autowired
    private RunTrabajoCalcularService runTrabajoCalcularService;
    
    @Autowired
    private RunTrabajoConsolidarService runTrabajoConsolidarService;

    @CounterMetric
    @TimerMetric
    @RunTrabajoAuditoria
    @Override
    public RunTrabajoDto run(@NotNull @Valid final RunTrabajoDto runTrabajo) throws Exception {
        try {
            runTrabajoRecolectarService.run(runTrabajo);
            runTrabajoCalcularService.run(runTrabajo);
            runTrabajoConsolidarService.run(runTrabajo);
        } catch (Exception e) {
            trabajoService.modifyEstadoTrabajo(runTrabajo.getTrabajoDto(), EstadoTrabajoEnum.ERROR.getDto());
            throw e;
        }
        return runTrabajo;
    }

}