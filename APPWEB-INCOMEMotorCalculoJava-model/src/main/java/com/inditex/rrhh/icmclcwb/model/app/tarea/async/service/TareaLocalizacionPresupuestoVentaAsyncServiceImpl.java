package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class TareaLocalizacionPresupuestoVentaAsyncServiceImpl
        implements TareaLocalizacionPresupuestoVentaAsyncService {

    @Autowired
    private TareaLocalizacionPresupuestoVentaService tareaLocalizacionPresupuestoVentaService;

    @Override
    public CompletableFuture<Void> save(List<TareaLocalizacionPresupuestoVentaDto> dto) {
        tareaLocalizacionPresupuestoVentaService.save(dto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> saveVentaCongeladaResultItemDto(List<VentaCongeladaResultItemDto> src, TareaDto tarea) {
        tareaLocalizacionPresupuestoVentaService.save(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto src, TareaDto tarea) {
        tareaLocalizacionPresupuestoVentaService.savePtrVentaTotalizadoResponse(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(PtrVentaOnlineIpodResponseDto src, TareaDto tarea) {
        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineIpodResponse(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(PtrVentaOnlinePickingResponseDto src, TareaDto tarea) {
        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlinePickingResponse(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(PtrVentaOnlineEntregaTiendaResponseDto src, TareaDto tarea) {
        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineEntregaTiendaResponse(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(PtrVentaOnlineEntregaDomicilioResponseDto src, TareaDto tarea) {
        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineEntregaDomicilioResponse(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
