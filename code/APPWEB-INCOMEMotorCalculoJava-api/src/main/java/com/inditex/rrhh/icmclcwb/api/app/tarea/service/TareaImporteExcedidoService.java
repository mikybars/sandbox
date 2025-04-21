package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;

import jakarta.validation.constraints.NotNull;

public interface TareaImporteExcedidoService {

  List<IdPersonaLocalDto> findPersonaImporteExcedidoByIdTarea(@NotNull Long idTarea);
}
