package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsIncomeService;

@Deprecated
@Service
public class TrabajoDatosMeta4IcmWsIncomeAsyncServiceImpl implements TrabajoDatosMeta4IcmWsIncomeAsyncService {

    @Autowired
	private TrabajoDatosMeta4IcmWsIncomeService trabajoDatosMeta4IcmWsIncomeService;

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4IcmWsIncomeService.empleadosTienda(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasParametro(final TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4IcmWsIncomeService.tiendasParametro(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4IcmWsIncomeService.condicionesEmpleados(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4IcmWsIncomeService.tiendasHistorico(trabajo);
        return CompletableFuture.completedFuture(null);
    }

}