package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

	CompletableFuture<Void> tiendasEmpleado(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

	CompletableFuture<Void> searchTiendas(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    CompletableFuture<Void> tiendas(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    CompletableFuture<Void> tiendasParametro(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception;
}