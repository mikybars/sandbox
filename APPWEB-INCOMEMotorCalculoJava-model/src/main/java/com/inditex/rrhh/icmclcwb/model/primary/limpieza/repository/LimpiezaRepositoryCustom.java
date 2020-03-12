package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface LimpiezaRepositoryCustom {

    void limpieza(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito);

    void consolidar(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TrabajoDto trabajo);

    void limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea);

    void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea);
}
