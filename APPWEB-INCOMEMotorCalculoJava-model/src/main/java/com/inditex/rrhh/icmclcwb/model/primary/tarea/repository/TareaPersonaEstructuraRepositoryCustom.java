package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import java.util.List;

public interface TareaPersonaEstructuraRepositoryCustom {

    List<TareaPersonaEstructura> save(List<TareaPersonaEstructura> src);

    void updateActivoTopes(TareaDto tarea);

}
