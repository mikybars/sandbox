package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoEmpleadoHistoricoAsyncServiceImpl implements ProcesoEmpleadoHistoricoAsyncService {

    @Autowired
    private ProcesoEmpleadoHistoricoService procesoEmpleadoHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<ProcesoEmpleadoHistoricoDto>  procesoEmpleadoHistorico, @Valid ProcesoDto proceso) {
        procesoEmpleadoHistoricoService.save(procesoEmpleadoHistorico, proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
