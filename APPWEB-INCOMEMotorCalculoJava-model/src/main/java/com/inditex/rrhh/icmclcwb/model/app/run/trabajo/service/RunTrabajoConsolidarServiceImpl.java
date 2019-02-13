package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTrabajoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

@Service
@Validated
public class RunTrabajoConsolidarServiceImpl implements RunTrabajoConsolidarService {

    @Autowired
    private TrabajoService trabajoService;

    @CounterMetric
    @TimerMetric
    @RunTrabajoAuditoria
    @Override
    public RunTrabajoDto run(@Valid final RunTrabajoDto trabajoRun) {
        final TrabajoDto trabajo = trabajoRun.getTrabajoDto();
        if (EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(trabajo, EstadoTrabajoEnum.EN_CURSO_CONSOLIDACION.getDto());
            TestUtils.threadSleep();
            trabajoService.modifyEstadoTrabajoFinal(trabajo, EstadoTrabajoEnum.FINALIZADO_SIN_ERRORES.getDto());
        }
        return trabajoRun;
    }

}