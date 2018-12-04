package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

@Service
@Validated
public class TrabajoRunCalcularServiceImpl implements TrabajoRunCalcularService {

    @Autowired
    private TrabajoService trabajoService;

    @CounterMetric
    @TimerMetric
    @AuditoriaTrabajoRun
    @Override
    public TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception {
        TrabajoDto trabajo = trabajoRun.getTrabajoDto();
        if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto(), trabajo);
            TestUtils.threadSleep();
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto(), trabajo);
        }
        return trabajoRun;
    }

}