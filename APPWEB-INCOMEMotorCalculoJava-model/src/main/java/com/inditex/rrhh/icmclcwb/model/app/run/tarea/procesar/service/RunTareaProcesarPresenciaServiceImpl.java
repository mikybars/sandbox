package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;

@Service
@Validated
public class RunTareaProcesarPresenciaServiceImpl implements RunTareaProcesarPresenciaService {

    
    @Autowired
    private TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;
    
    @Autowired
    private TareaLocalizacionPresenciaService tareaLocalizacionPresenciaService;

    @Autowired
    private TareaAgrupacionPresenciaService tareaAgrupacionPresenciaService;
    
    @Auditoria
    @Override
    public void compensarLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.compensar(runTarea);
    }
        
    @Auditoria
    @Override
    public void updateActivoLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.updateActivo(runTarea);
    }
   
    @Auditoria
    @Override
    public void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.updateActivo(runTarea);
    }

    @Auditoria
    @Override
    public void compensarLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.compensar(runTarea);
    }

    @Auditoria
    @Override
    public void presenciaAgrupacionCadena(@Valid RunTareaDto runTarea) {
        tareaAgrupacionPresenciaService.procesarPresenciaAgrupacion(runTarea);
    }

}
