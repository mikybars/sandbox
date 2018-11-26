package com.inditex.rrhh.icmclcwb.model.primary.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoTiendaPresenciaSeccionRepository {

	void save(@NotNull TrabajoDto trabajoDto);

}
