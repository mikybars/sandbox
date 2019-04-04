package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

@Service
@Validated
public class RunTareaRecolectarServiceImpl implements RunTareaRecolectarService {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private RunTareaRecolectarAmbitoService runTareaRecolectarAmbitoService;

    @Autowired
    private RunTareaRecolectarCondicionesService runTareaRecolectarCondicionesService;
    
    @Autowired
    @Qualifier(value="recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        if (EstadoTareaEnum.PENDIENTE_RECOLECTAR.getId().equals(tarea.getEstado().getId())) {
            runTarea.getRecolectarProperties().setDaysNumber(recolectarProperties.getDaysNumber());
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.EN_CURSO_RECOLECTAR.getDto());
            runTareaRecolectarAmbitoService.run(runTarea);
            // TODO Una vez tengamos las localizaciones, personas y condiciones hay que
            // recuperar las personas o localizaciones adicionales según condiciones
            // Por ejemplo si un empleado tiene un tipo de calculo por venta, habrá que
            // recuperar todos los empleados de las tiendas en las que este ese empleado
            // para recuperar sus condiciones
            runTareaRecolectarCondicionesService.run(runTarea);
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.PENDIENTE_CALCULAR.getDto());
        }
        return runTarea;
    }

}
