package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaRecolectarPtrVentaEcommerceAsyncServiceImpl
        implements RunTareaRecolectarPtrVentaEcommerceAsyncService {

    @Autowired
    private RunTareaRecolectarPtrVentaEcommerceService tareaRecolectarPtrVentaEcommerceService;
    
    @Override
    public CompletableFuture<Void> ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> ventaOnlineIpodDetalleLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
        tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodDetalleLocalizacionSeccionByRunTarea(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
