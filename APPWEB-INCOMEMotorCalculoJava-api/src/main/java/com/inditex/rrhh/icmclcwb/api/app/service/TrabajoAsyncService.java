package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoAsyncService {

	CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception;
	
	CompletableFuture<Void> tiendasHistorico(@Valid final TrabajoDto trabajo) throws Exception;
	
	CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo) throws Exception;
	
	CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;
	
	CompletableFuture<Void> presenciaTotalizadaTienda(@Valid final TrabajoDto trabajo) throws Exception;
	
	CompletableFuture<Void> presenciaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;

}