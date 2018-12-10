package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstructuraService;

@Service
public class TrabajoEmpleadoEstructuraAsyncServiceImpl implements TrabajoEmpleadoEstructuraAsyncService {

    @Autowired
    private TrabajoEmpleadoEstructuraService trabajoEmpleadoEstructuraService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura , @Valid TrabajoDto trabajo) {
        trabajoEmpleadoEstructuraService.save(trabajoEmpleadoEstructura, trabajo);
        return CompletableFuture.completedFuture(null);
    }
}
