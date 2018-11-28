package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;

@Service
public class TrabajoDatosMeta4IcmWsCalcIncomeAsyncServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeAsyncService {

	@Autowired
	private TrabajoDatosMeta4IcmWsCalcIncomeService trabajoDatosMeta4IcmWsCalcIncomeService;
	
    @Async
    @Override
    public CompletableFuture<Void> tiendasEmpleado(final TrabajoDto trabajo) throws Exception {
    	trabajoDatosMeta4IcmWsCalcIncomeService.tiendasEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }
}