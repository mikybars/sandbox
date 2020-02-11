package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

    @Override
    public void compensarLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.compensar(runTarea);
    }

    @Override
    public void totalizarLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.totalizar(runTarea);
    }

    @Override
    public void totalizarEcommerceLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.totalizarEcommerce(runTarea);
    }

    @Override
    public void totalizarEmpleadosPorVenta(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.totalizarEmpleadosPorVenta(runTarea);
    }

    @Override
    public void compensarLocalizacionEcommerce(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.compensarEcommerce(runTarea);
    }

    @Override
    public void updateActivoLocalizacionVacio(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresenciaService.updateActivoVacio(runTarea);
    }

    @Override
    public void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.updateActivo(runTarea);
    }

    @Override
    public void updateActivoLocalizacionPersonaPresenciaVacio(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.updateActivoVacio(runTarea);
    }

    @Override
    public void compensarLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.compensar(runTarea);
    }

    @Override
    public void calcularPresenciasTotalesAgrupacion(@Valid RunTareaDto runTarea) {
        tareaAgrupacionPresenciaService.calcularPresenciasTotalesAgrupacion(runTarea.getTarea());
    }

    @Override
    public void indicadorPresencia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.indicadorPresencia(runTarea);
    }

    @Override
    public void indicadorPresenciaDesplazamiento(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.indicadorPresenciaDesplazamiento(runTarea);
    }

    @Override
    public void indicadorPresenciaDesplazamientoBase(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.indicadorPresenciaDesplazamientoBase(runTarea);
    }
    
    @Override
    public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
    }

    @Override
    public void presenciasHorasFijas(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.presenciasHorasFijas(runTarea);
    }

    @Override
    public void presenciasHorasFijasDesplazamientos(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPersonaPresenciaService.presenciasHorasFijasDesplazamientos(runTarea);
    }
}
