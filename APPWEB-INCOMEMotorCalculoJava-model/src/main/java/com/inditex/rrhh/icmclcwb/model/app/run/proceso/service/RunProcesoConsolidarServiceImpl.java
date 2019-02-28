package com.inditex.rrhh.icmclcwb.model.app.run.proceso.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

@Service
@Validated
public class RunProcesoConsolidarServiceImpl implements RunProcesoConsolidarService {

    @Autowired
    private ProcesoService procesoService;

    @CounterMetric
    @TimerMetric
    @Auditoria
    @Override
    public RunProcesoDto run(@Valid final RunProcesoDto runProceso) {
        final ProcesoDto proceso = runProceso.getProceso();
        if (EstadoProcesoEnum.PENDIENTE_CONSOLIDAR.getId().equals(proceso.getEstado().getId())) {
            procesoService.modifyEstadoProceso(proceso, EstadoProcesoEnum.EN_CURSO_CONSOLIDAR.getDto());
            TestUtils.threadSleep();
            procesoService.modifyEstadoProcesoFinal(proceso, EstadoProcesoEnum.FINALIZADO_SIN_ERRORES.getDto());
        }
        return runProceso;
    }

}