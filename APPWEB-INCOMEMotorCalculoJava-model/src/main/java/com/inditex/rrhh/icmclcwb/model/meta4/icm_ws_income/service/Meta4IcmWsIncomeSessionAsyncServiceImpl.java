package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.service;

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
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto.TiendaComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto.TiendaComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;

@Deprecated
@Service
public class Meta4IcmWsIncomeSessionAsyncServiceImpl implements Meta4IcmWsIncomeSessionAsyncService {

    @Autowired
	private Meta4IcmWsIncomeSessionService meta4IcmWsIncomeSessionService;
    
    @Async
    @Override
    public CompletableFuture<List<EmpleadosTiendaResultItemDto>> getEmpleadosTienda(EmpleadosTiendaRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsIncomeSessionService.getEmpleadosTienda(request));
    }

    @Async
    @Override
    public CompletableFuture<List<EmpleadosEstructuraResultItemDto>> getEmpleadosEstructura(
            EmpleadosEstructuraRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsIncomeSessionService.getEmpleadosEstructura(request));
    }

    @Async
    @Override
    public CompletableFuture<List<ValoresCondicionesResultItemDto>> getValoresCondiciones(ValoresCondicionesRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsIncomeSessionService.getValoresCondiciones(request));
    }
    
    @Async
    @Override
    public CompletableFuture<List<TiendaComisionableResultItemDto>> getTiendaComisionable(TiendaComisionableRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsIncomeSessionService.getTiendaComisionable(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PeriodoDto>> periodo() {
        return CompletableFuture.completedFuture(meta4IcmWsIncomeSessionService.periodo());
    }

    @Async
    @Override
    public CompletableFuture<List<PocTiendaDto>> getTiendas(TrabajoDto trabajo) {
        return CompletableFuture.completedFuture(meta4IcmWsIncomeSessionService.getTiendas(trabajo));
    }

}