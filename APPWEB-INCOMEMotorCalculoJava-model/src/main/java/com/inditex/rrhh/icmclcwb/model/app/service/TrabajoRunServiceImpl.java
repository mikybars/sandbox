package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunDatosService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;

@Service
@Validated
public class TrabajoRunServiceImpl implements TrabajoRunService {

    @Autowired
    private TrabajoService trabajoService;
    
    @Autowired
    private TrabajoRunDatosService trabajoRunDatosService;

    @Autowired
    private TrabajoRunCalcularService trabajoRunCalcularService;
    
    @Autowired
    private TrabajoRunConsolidarService trabajoRunConsolidarService;

    @CounterMetric
    @TimerMetric
    @AuditoriaTrabajoRun
    @Override
    public TrabajoRunDto run(@NotNull @Valid final TrabajoRunDto trabajoRun) throws Exception {
        try {
            trabajoRunDatosService.run(trabajoRun);
            trabajoRunCalcularService.run(trabajoRun);
            trabajoRunConsolidarService.run(trabajoRun);
        } catch (Exception e) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.ERROR.getDto(), trabajoRun.getTrabajoDto());
            throw e;
        }
        return trabajoRun;
    }

}