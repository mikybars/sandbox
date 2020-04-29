package com.inditex.rrhh.icmclcwb.api.app.limpieza.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface LimpiezaService {

    void runTarea(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid final TareaDto tarea);

}
