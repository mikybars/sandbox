package com.inditex.rrhh.icmclcwb.model.meta4.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;

@Service
public class Meta4SessionAsyncServiceImpl implements Meta4SessionAsyncService {

    @Autowired
    private Meta4SessionService meta4SessionService;
    
    @Async
    @Override
    public CompletableFuture<List<EmpleadosTiendaResultItemDto>> getEmpleadosTienda(EmpleadosTiendaRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4SessionService.getEmpleadosTienda(request));
    }

    @Async
    @Override
    public CompletableFuture<List<EmpleadosEstructuraResultItemDto>> getEmpleadosEstructura(
            EmpleadosEstructuraRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(meta4SessionService.getEmpleadosEstructura(request));
    }

    @Async
    @Override
    public CompletableFuture<List<ValoresCondicionesResultItemDto>> getValoresCondiciones(ValoresCondicionesRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4SessionService.getValoresCondiciones(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PeriodoDto>> periodo() {
        return CompletableFuture.completedFuture(meta4SessionService.periodo());
    }

    @Async
    @Override
    public CompletableFuture<List<PocTiendaDto>> getTiendas(TrabajoDto trabajo) {
        return CompletableFuture.completedFuture(meta4SessionService.getTiendas(trabajo));
    }

}