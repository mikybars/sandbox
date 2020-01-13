package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPostProcesarService;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones.AntiguedadRunPostProcesar;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones.BajaItRunPostProcesar;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones.CarenciaRunPostProcesar;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones.MaximoGarantizadoRunPostProcesar;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones.MinimoGarantizadoRunPostProcesar;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones.VacacionesRunPostProcesar;

@Service
@Validated
public class RunTareaPostProcesarServiceImpl implements RunTareaPostProcesarService{

    @Autowired
    private AntiguedadRunPostProcesar antiguedadRunPostProcesar;
    
    @Autowired
    private BajaItRunPostProcesar bajaItRunPostProcesar;
    
    @Autowired
    private VacacionesRunPostProcesar vacacionesRunPostProcesar;
    
    @Autowired
    private MaximoGarantizadoRunPostProcesar maximoGarantizadoRunPostProcesar;
    
    @Autowired
    private MinimoGarantizadoRunPostProcesar minimoGarantizadoRunPostProcesar;
    
    @Autowired
    private CarenciaRunPostProcesar carenciaRunPostProcesar;
    
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        antiguedadRunPostProcesar.execute(runTarea);
        bajaItRunPostProcesar.execute(runTarea);
        vacacionesRunPostProcesar.execute(runTarea);
        
        maximoGarantizadoRunPostProcesar.execute(runTarea);
        minimoGarantizadoRunPostProcesar.execute(runTarea);
        
        carenciaRunPostProcesar.execute(runTarea);
    }

}
