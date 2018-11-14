package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoRunAsyncService {

	CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> tiendasHistorico(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> presenciaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;

	CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
			@NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

	CompletableFuture<Void> presenciaTotalizadaTienda(@Valid final TrabajoDto trabajo,
			@NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

	void exceptionally(final TrabajoDto trabajo, final CompletableFuture<?> cf, final List<CompletableFuture<?>> cfList)
			throws Exception;

	boolean isOk(final TrabajoDto trabajo, final List<CompletableFuture<?>> cfList) throws Exception;

}