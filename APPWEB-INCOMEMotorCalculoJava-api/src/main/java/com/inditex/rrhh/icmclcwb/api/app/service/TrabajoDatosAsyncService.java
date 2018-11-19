package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosAsyncService {

    CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> tiendasParametro(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

    CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

}