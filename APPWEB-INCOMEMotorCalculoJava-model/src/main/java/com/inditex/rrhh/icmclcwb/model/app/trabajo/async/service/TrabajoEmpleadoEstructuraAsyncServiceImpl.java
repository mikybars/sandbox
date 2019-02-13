package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoEmpleadoEstructuraAsyncServiceImpl implements TrabajoEmpleadoEstructuraAsyncService {

    @Autowired
    private TrabajoEmpleadoEstructuraService trabajoEmpleadoEstructuraService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura , @Valid TrabajoDto trabajo) {
        trabajoEmpleadoEstructuraService.save(trabajoEmpleadoEstructura, trabajo);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
