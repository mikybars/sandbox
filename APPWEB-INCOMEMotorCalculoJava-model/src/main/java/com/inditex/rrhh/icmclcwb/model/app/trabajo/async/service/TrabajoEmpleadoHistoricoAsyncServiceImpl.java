package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoEmpleadoHistoricoAsyncServiceImpl implements TrabajoEmpleadoHistoricoAsyncService {

    @Autowired
    private TrabajoEmpleadoHistoricoService trabajoEmpleadoHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoHistoricoDto>  trabajoEmpleadoHistorico, @Valid TrabajoDto trabajo) {
        trabajoEmpleadoHistoricoService.save(trabajoEmpleadoHistorico, trabajo);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
