package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrVentaEcommerceAsyncServiceImpl
        implements RunTareaRecolectarPtrVentaEcommerceAsyncService {

    @Autowired
    private RunTareaRecolectarPtrVentaEcommerceService tareaRecolectarPtrVentaEcommerceService;
    
    @Async
    @Override
    public CompletableFuture<Void> ventaOnlineEntregaDomicilio(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaDomicilio(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> ventaOnlineEntregaTienda(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaTienda(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> ventaOnlineiPod(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineiPod(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> ventaOnlineIpodIndividualDetalle(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodIndividualDetalle(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
  
    @Async
    @Override
    public CompletableFuture<Void> ventaOnlinePicking(final RunTareaDto runTarea, final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlinePicking(runTarea, runTareaRecolectarBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
