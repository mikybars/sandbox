package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class RunTareaProcesarCondicionesServiceImpl implements RunTareaProcesarCondicionesService {

    @Autowired
    private TareaLocalizacionPresupuestoRepositoryCustom tareaLocalizacionPresupuestoService;

    @Autowired
    private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

    @Autowired
    private TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;

    @Override
    public void updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoService.updateActivoBandaExcepcion(runTarea.getTarea());
    }

    @Override
    public void updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoService.updateActivoBandasSinExcepcion(runTarea.getTarea());
    }

    @Override
    public void updateActivoEstructuraTopes(@Valid TareaDto tarea) {
        tareaPersonaEstructuraRepositoryCustom.updateActivoTopes(tarea);
    }

    @Override
    public void relacionarPresupuestosEstructurasSinDesplazamiento(@Valid TareaDto tarea) {
        tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom.relacionarEstructuraSinDesplazamiento(tarea);
    }

    @Override
    public void relacionarPresupuestosEstructurasDesplazamiento(@Valid TareaDto tarea) {
        tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom.relacionarEstructuraDesplazamiento(tarea);
    }

}
