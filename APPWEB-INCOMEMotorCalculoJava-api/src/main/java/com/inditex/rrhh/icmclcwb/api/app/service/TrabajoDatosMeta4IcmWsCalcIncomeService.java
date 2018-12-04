package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeService {

	void tiendasEmpleado(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

	void condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception;

	void searchTiendas(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

}