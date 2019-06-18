package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;

public interface RunTareaProcesarVentaService {

    void ventaLocalizacionSeccion(@Valid RunTareaDto runTarea);

    void ventaLocalizacionTienda(@Valid RunTareaDto runTarea);

    void saveAbierto(@Valid RunTareaDto runTarea);

    void saveCerrado(@Valid RunTareaDto runTarea);

    void trasladar(@Valid RunTareaDto runTarea);

    void compensar(@Valid RunTareaDto runTarea);

    void repartoVentaEntregaDomicilioAgrupaciones(@Valid RunTareaDto runTarea);

    void repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(@Valid RunTareaDto runTarea);

    void repartoVentaEntregaDomicilioSeccion(@Valid RunTareaDto runTarea);

}
