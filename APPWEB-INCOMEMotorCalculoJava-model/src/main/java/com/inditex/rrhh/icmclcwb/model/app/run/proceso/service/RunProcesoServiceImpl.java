package com.inditex.rrhh.icmclcwb.model.app.run.proceso.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunProcesoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;

@Service
@Validated
public class RunProcesoServiceImpl implements RunProcesoService {

    @Autowired
    private ProcesoService procesoService;
    
    @Autowired
    private RunProcesoRecolectarService runProcesoRecolectarService;

    @Autowired
    private RunProcesoCalcularService runProcesoCalcularService;
    
    @Autowired
    private RunProcesoConsolidarService runProcesoConsolidarService;

    @CounterMetric
    @TimerMetric
    @RunProcesoAuditoria
    @Override
    public RunProcesoDto run(@NotNull @Valid final RunProcesoDto runProceso) {
        try {
            runProcesoRecolectarService.run(runProceso);
            runProcesoCalcularService.run(runProceso);
            runProcesoConsolidarService.run(runProceso);
        } catch (Exception e) {
            procesoService.modifyEstadoProcesoFinal(runProceso.getProceso(), EstadoProcesoEnum.ERROR.getDto());
            throw new IcmclcwbException(e.getMessage(), e);
        }
        return runProceso;
    }

}