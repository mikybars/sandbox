package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarVentaService {
    
    void ventaOnlineEntregaTiendaAgrupacionCadena(@Valid RunTareaDto runTarea);
    
    void ventaOnlineEntregaTiendaAgrupacionCadenaSeccion(@Valid RunTareaDto runTarea);
    
    void ventaFisicaAgrupacionCadena(@Valid RunTareaDto runTarea);
    
    void ventaFisicaAgrupacionCadenaSeccion(@Valid RunTareaDto runTarea);
    
    void ventaLocalizacionSeccion(@Valid RunTareaDto runTarea);
    
    void ventaLocalizacionTienda(@Valid RunTareaDto runTarea);

    void saveAbierto(@Valid RunTareaDto runTarea);

    void saveCerrado(@Valid RunTareaDto runTarea);

    void trasladar(@Valid RunTareaDto runTarea);

}
