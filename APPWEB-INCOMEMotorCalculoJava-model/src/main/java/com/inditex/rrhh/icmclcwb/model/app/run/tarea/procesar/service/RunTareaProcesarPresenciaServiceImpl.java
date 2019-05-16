package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;

@Service
@Validated
public class RunTareaProcesarPresenciaServiceImpl implements RunTareaProcesarPresenciaService {
    
    @Autowired
    private TareaTiendaPresenciaSeccionService tareaTiendaPresenciaSeccionService;
    
    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaService tareaLocalizacionPersonaSeccionPresenciaService;
    
    @Auditoria
    @Override
    public void compensar(@Valid RunTareaDto runTarea) {
        tareaTiendaPresenciaSeccionService.compensar(runTarea);
    }
    
    @Override
    public void updateActivo(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaSeccionPresenciaService.updateActivo(runTarea);
    }
}
