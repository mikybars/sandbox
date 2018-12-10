package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Deprecated
public interface TrabajoDatosMeta4IcmWsIncomeAsyncService {

    CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> tiendasParametro(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo) throws Exception;

}