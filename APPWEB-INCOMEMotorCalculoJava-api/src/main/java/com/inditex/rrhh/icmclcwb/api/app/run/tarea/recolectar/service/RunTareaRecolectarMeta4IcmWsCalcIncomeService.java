package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomeService {

    void tiendasHistorico(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void tiendasEmpleadoHistorico(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void condicionesEmpleados(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void empleadosTienda(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void tiendasPresencia(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void tiendasComisionable(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void personaByRunTarea(@Valid final RunTareaDto runTarea);

    void personaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito);

    void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void localizacionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito);

    void condicionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);
    
    void condicionPersonaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea, @NotNull @Valid final TareaAmbitoDto tareaAmbito);

}