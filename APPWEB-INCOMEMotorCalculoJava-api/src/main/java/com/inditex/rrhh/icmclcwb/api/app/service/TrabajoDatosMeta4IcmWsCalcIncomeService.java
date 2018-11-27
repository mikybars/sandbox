package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeService {

	void tiendasEmpleado(@Valid TrabajoDto trabajo) throws Exception;

}