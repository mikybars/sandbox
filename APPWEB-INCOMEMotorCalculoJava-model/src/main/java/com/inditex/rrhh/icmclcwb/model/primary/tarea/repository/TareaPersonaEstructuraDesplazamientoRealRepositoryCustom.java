package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.DesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamientoReal;

public interface TareaPersonaEstructuraDesplazamientoRealRepositoryCustom {

  List<TareaPersonaEstructuraDesplazamientoReal> save(List<TareaPersonaEstructuraDesplazamientoReal> src);

  List<DesplazamientoRealDto> findDesplazamientoReal(TareaDto tarea);

}
