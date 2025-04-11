package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaImporteExcedidoDto;

import jakarta.validation.constraints.NotNull;

public interface TareaImporteExcedidoService {

  List<TareaPersonaImporteExcedidoDto> findPersonaImporteExcedidoByIdTarea(@NotNull Long idTarea);
}
