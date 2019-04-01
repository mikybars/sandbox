package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarVentaService {
    
    void ventaLocalizacionSeccion(@Valid RunTareaDto runTarea);
    
    void ventaLocalizacionTienda(@Valid RunTareaDto runTarea);

}
