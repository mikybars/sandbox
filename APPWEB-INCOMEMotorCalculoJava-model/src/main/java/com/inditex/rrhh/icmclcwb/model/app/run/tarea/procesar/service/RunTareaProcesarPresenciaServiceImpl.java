package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;

@Service
@Validated
public class RunTareaProcesarPresenciaServiceImpl implements RunTareaProcesarPresenciaService {
    
    @Autowired
    private TareaTiendaPresenciaSeccionService tareaTiendaPresenciaSeccionService;
    
    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaService tareaLocalizacionPersonaSeccionPresenciaService;
    
    @Autowired
    private TareaLocalizacionPersonaPresenciaSeccionService tareaLocalizacionPersonaPresenciaSeccionService;
    
    @Autowired
    private TareaLocalizacionPresenciaService tareaLocalizacionPresenciaService;
    
    @Auditoria
    @Override
    public void compensarLocalizacionSeccion(@Valid RunTareaDto runTarea) {
        tareaTiendaPresenciaSeccionService.compensar(runTarea);
    }
    
    @Auditoria
    @Override
    public void compensarLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.compensar(runTarea);
    }
        
    @Auditoria
    @Override
    public void updateActivoTotalizadoLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.updateActivo(runTarea);
    }
    
    @Auditoria
    @Override
    public void updateActivoTotalizadoLocalizacionSeccion(@Valid RunTareaDto runTarea) {
        tareaTiendaPresenciaSeccionService.updateActivo(runTarea);
    }
    
    @Auditoria
    @Override
    public void updateActivoLocalizacionPersonaSeccionPresencia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaSeccionPresenciaService.updateActivo(runTarea);
    }
    
    @Auditoria
    @Override
    public void updateActivoLocalizacionPersonaPresenciaSeccion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaSeccionService.updateActivo(runTarea);
    }
}
