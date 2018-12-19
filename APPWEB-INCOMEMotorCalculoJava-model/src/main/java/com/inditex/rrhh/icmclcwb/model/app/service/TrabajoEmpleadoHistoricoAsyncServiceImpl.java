package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoHistoricoService;

@Service
public class TrabajoEmpleadoHistoricoAsyncServiceImpl implements TrabajoEmpleadoHistoricoAsyncService {

    @Autowired
    private TrabajoEmpleadoHistoricoService trabajoEmpleadoHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoHistoricoDto>  trabajoEmpleadoHistorico, @Valid TrabajoDto trabajo) throws Exception {
        trabajoEmpleadoHistoricoService.save(trabajoEmpleadoHistorico, trabajo);
        return CompletableFuture.completedFuture(null);
    }
    
}
