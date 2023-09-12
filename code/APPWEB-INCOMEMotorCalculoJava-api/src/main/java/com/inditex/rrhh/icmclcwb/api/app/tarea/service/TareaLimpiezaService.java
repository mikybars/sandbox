package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

public interface TareaLimpiezaService {

  TareaLimpiezaDto save(TareaLimpiezaDto tareaLimpieza);

  List<TareaLimpiezaDto> save(List<IdTareaDTO> idTareas);

  TareaLimpiezaDto find(Long id);

}
