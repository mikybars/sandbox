package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> tiendasEmpleadoHistorico(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> tiendasPresencia(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> tiendasComisionable(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

}