package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoEmpleadoEstructuraAsyncServiceImpl implements ProcesoEmpleadoEstructuraAsyncService {

    @Autowired
    private ProcesoEmpleadoEstructuraService procesoEmpleadoEstructuraService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<ProcesoEmpleadoEstructuraDto> procesoEmpleadoEstructura , @Valid ProcesoDto proceso) {
        procesoEmpleadoEstructuraService.save(procesoEmpleadoEstructura, proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
