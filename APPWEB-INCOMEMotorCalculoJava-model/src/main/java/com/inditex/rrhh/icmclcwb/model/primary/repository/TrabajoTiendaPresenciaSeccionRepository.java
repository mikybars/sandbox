package com.inditex.rrhh.icmclcwb.model.primary.repository;

import javax.validation.constraints.NotNull;

public interface TrabajoTiendaPresenciaSeccionRepository {

	void save(@NotNull Long trabajoId);

}
