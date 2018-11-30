package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeService {

	void tiendasEmpleado(@Valid TrabajoDto trabajo) throws Exception;

	void condicionesEmpleados(@Valid TrabajoDto trabajo) throws Exception;

	void searchTiendas(@Valid TrabajoDto trabajo) throws Exception;

}