package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

	CompletableFuture<Void> tiendasEmpleado(TrabajoDto trabajo) throws Exception;

}