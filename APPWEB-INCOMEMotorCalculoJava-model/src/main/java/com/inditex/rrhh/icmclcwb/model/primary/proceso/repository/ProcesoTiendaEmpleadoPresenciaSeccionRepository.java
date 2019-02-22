package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoTiendaEmpleadoPresenciaSeccionRepository {

	void save(@NotNull final ProcesoDto procesoDto);

}
