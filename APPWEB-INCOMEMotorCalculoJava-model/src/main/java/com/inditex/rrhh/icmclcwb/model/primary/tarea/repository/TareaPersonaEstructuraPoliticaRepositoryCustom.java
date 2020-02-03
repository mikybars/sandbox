package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface TareaPersonaEstructuraPoliticaRepositoryCustom {

    List<TareaPersonaEstructuraPolitica> save(List<TareaPersonaEstructuraPolitica> src);

    void updateImporteEstructuraPoliticas(@NotNull TareaDto tarea, @NotNull TrabajoDto trabajoDto);

}
