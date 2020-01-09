package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.service;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunLimpiezaServiceImpl implements RunLimpiezaService {

    @Autowired
    private LimpiezaService limpiezaService;

    @Auditoria
    @CounterMetric 
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunLimpiezaDto runLimpieza) {
        limpiezaService.runTarea(runLimpieza.getTarea());
    }

}
