package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

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
    public void updateActivoPresupuestosBandaExcepcion(final RunTareaDto runTarea) {
        this.tareaLocalizacionPresupuestoService.updateActivoBandaExcepcion(runTarea.getTarea());
    }

    @Override
    public void updateActivoPresupuestosBandasSinExcepcion(final RunTareaDto runTarea) {
        this.tareaLocalizacionPresupuestoService.updateActivoBandasSinExcepcion(runTarea.getTarea());
    }

    @Override
    public void updateActivoEstructuraTopes(@Valid final TareaDto tarea) {
        this.tareaPersonaEstructuraRepositoryCustom.updateActivoTopes(tarea);
    }

    @Override
    public void relacionarPresupuestosEstructurasSinDesplazamiento(@Valid final TareaDto tarea) {
        this.tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom
            .relacionarEstructuraSinDesplazamiento(tarea);
    }

    @Override
    public void relacionarPresupuestosEstructurasDesplazamiento(@Valid final TareaDto tarea) {
        this.tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom
            .relacionarEstructuraDesplazamiento(tarea);
    }

    @Override
    public void desactivarChallengeOpcionOrigen(@Valid final TareaDto tarea) {
        this.tareaPersonaEstructuraRepositoryCustom.desactivarChallengeOpcionOrigen(tarea);
    }

    @Override
    public void desactivarManualOrdinalDoble(@Valid final TareaDto tarea) {
        this.tareaPersonaEstructuraRepositoryCustom.desactivarManualOrdinalDoble(tarea);
    }

    @Override
    public void crearChallengeOpcionOrigen(@Valid final TareaDto tarea) {
        this.tareaPersonaEstructuraRepositoryCustom.crearChallengeOpcionOrigen(tarea);
    }

}
