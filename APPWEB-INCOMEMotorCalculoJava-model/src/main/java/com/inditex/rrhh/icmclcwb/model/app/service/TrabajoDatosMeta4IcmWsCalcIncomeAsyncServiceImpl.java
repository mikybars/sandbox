package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoDatosMeta4IcmWsCalcIncomeAsyncServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

    @Autowired
    private TrabajoDatosMeta4IcmWsCalcIncomeService trabajoDatosMeta4IcmWsCalcIncomeService;

    @Async
    @Override
    public CompletableFuture<Void> tiendasPresencia(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasPresencia(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasComisionable(final TrabajoDto trabajo, final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasComisionable(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasHistorico(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasEmpleadoHistorico(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasEmpleadoHistorico(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.condicionesEmpleados(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.empleadosTienda(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}