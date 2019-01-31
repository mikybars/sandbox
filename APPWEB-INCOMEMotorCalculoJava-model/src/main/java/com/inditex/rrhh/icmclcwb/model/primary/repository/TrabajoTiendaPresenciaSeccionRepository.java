package com.inditex.rrhh.icmclcwb.model.primary.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoTiendaPresenciaSeccionRepository {

	void save(@NotNull final TrabajoDto trabajoDto);

}
