package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoPresenciasSinVentasService {

  List<IdLocalizacionLocalDto> findTiendaPresenciasSinVentas(@NotNull Long idTarea);
}
