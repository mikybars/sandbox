package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaProcesarCondicionesServiceImpl implements RunTareaProcesarCondicionesService {

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Override
    public void updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoService.updateActivoBandaExcepcion(runTarea.getTarea());
    }

    @Override
    public void updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoService.updateActivoBandasSinExcepcion(runTarea.getTarea());
    }
}
