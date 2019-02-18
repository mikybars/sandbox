package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRecolectarMeta4IcmWsCalcIncomeService {

    void tiendasHistorico(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void tiendasEmpleadoHistorico(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void condicionesEmpleados(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void empleadosTienda(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void tiendasPresencia(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void tiendasComisionable(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}