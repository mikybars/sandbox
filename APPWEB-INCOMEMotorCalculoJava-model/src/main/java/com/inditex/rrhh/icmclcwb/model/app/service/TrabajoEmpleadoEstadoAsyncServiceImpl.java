package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;

@Service
public class TrabajoEmpleadoEstadoAsyncServiceImpl implements TrabajoEmpleadoEstadoAsyncService {

    @Autowired
    private TrabajoEmpleadoEstadoService trabajoEmpleadoEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) {
        trabajoEmpleadoEstadoService.save(trabajoEmpleadoEstado);
        return CompletableFuture.completedFuture(null);
    }

}