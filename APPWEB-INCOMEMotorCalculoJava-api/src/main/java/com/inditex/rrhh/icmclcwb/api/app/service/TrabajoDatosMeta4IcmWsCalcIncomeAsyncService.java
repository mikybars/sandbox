package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

	CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception;

	CompletableFuture<Void> tiendasEmpleadoHistorico(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception;

	CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception;

	CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception;

	CompletableFuture<Void> tiendasPresencia(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception;

    CompletableFuture<Void> tiendasComisionable(final TrabajoDto trabajo,
            final @NotNull @NotEmpty List<TipoTrabajoTiendaDto> tipoTrabajoTienda, 
            final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

}