package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;

@Service
public class TrabajoDatosMeta4IcmWsCalcIncomeAsyncServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

	@Autowired
	private TrabajoDatosMeta4IcmWsCalcIncomeService trabajoDatosMeta4IcmWsCalcIncomeService;
	
    @Async
    @Override
    public CompletableFuture<Void> tiendasPresencia(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
    	trabajoDatosMeta4IcmWsCalcIncomeService.tiendasPresencia(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> tiendasComisionable(TrabajoDto trabajo, TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasComisionable(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> tiendasHistorico(TrabajoDto trabajo, TrabajoRunDatosDto trabajoRunDatos)
            throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasHistorico(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> tiendasParametro(TrabajoDto trabajo, TrabajoRunDatosDto trabajoRunDatos)
            throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.tiendasParametro(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> condicionesEmpleados(TrabajoDto trabajo, TrabajoRunDatosDto trabajoRunDatos)
            throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.condicionesEmpleados(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> empleadosTienda(TrabajoDto trabajo, TrabajoRunDatosDto trabajoRunDatos)
            throws Exception {
        trabajoDatosMeta4IcmWsCalcIncomeService.empleadosTienda(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }
}