package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

@Service
@Validated
public class TrabajoRunConsolidarServiceImpl implements TrabajoRunConsolidarService {

    @Autowired
    private TrabajoService trabajoService;

    @CounterMetric
    @TimerMetric
    @AuditoriaTrabajoRun
    @Override
    public TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception {
        final TrabajoDto trabajo = trabajoRun.getTrabajoDto();
        if (EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CONSOLIDACION.getDto(), trabajo);
            TestUtils.threadSleep();
            trabajo.setFechaFinTrabajo(LocalDateTime.now());
            trabajo.setEstado(EstadoTrabajoEnum.FINALIZADO_SIN_ERRORES.getDto());
            trabajoService.modifyTrabajo(trabajo);
        }
        return trabajoRun;
    }

}