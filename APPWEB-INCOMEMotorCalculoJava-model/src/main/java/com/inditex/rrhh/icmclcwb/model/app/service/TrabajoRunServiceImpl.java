package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunDatosService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunInicioService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;

@Service
@Validated
public class TrabajoRunServiceImpl implements TrabajoRunService {

    @Autowired
    private TrabajoService trabajoService;
    
    @Autowired
    private TrabajoRunInicioService trabajoRunInicioService;
    
    @Autowired
    private TrabajoRunDatosService trabajoRunDatosService;

    @Autowired
    private TrabajoRunCalcularService trabajoRunCalcularService;
    
    @Autowired
    private TrabajoRunConsolidarService trabajoRunConsolidarService;

    @CounterMetric
    @TimerMetric
    //@HistogramMetric
    @AuditoriaTrabajo
    @Override
    public TrabajoDto run(@NotNull @Valid final TrabajoDto trabajo) throws Exception {
        try {
            trabajoRunInicioService.run(trabajo);
            trabajoRunDatosService.run(trabajo);
            trabajoRunCalcularService.run(trabajo);
            trabajoRunConsolidarService.run(trabajo);
        } catch (Exception e) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.ERROR.getDto(), trabajo);
            throw e;
        }
        return trabajo;
    }

}