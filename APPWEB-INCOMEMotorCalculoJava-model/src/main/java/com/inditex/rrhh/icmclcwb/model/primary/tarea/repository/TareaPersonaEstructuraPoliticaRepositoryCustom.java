package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

public interface TareaPersonaEstructuraPoliticaRepositoryCustom {

    List<TareaPersonaEstructuraPolitica> save(List<TareaPersonaEstructuraPolitica> src);

    void updateImporteEstructuraPoliticas(@NotNull TareaDto tarea, @NotNull TrabajoDto trabajoDto);

}
