package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;

@Service
public class Meta4IcmWsCalcIncomeSessionAsyncServiceImpl implements Meta4IcmWsCalcIncomeSessionAsyncService {

    @Autowired
	private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Async
    @Override
    public CompletableFuture<List<TiendasEmpleadoResultItemDto>> getTiendasEmpleado(TiendasEmpleadoRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getTiendasEmpleado(request));
    }
    
    @Async
    @Override
    public CompletableFuture<List<SearchTiendasResultItemDto>> searchTiendas(SearchTiendasRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.searchTiendas(request));
    }
    
    @Async
    @Override
    public CompletableFuture<List<TiendasResultItemDto>> getTiendas(TiendasRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getTiendas(request));
    }
    
    @Async
    @Override
    public CompletableFuture<List<SearchEmpleadosResultItemDto>> searchEmpleados(SearchEmpleadosRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.searchEmpleados(request));
    }

    @Async
    @Override
    public CompletableFuture<List<ComisionEmpleadoResultItemDto>> getComisionEmpleado(ComisionEmpleadoRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getComisionEmpleado(request));
    }
    
    @Async
    @Override
    public CompletableFuture<List<EmpleadosResultItemDto>> getEmpleados(EmpleadosRequestDto request)
            throws Exception {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEmpleados(request));
    }
}