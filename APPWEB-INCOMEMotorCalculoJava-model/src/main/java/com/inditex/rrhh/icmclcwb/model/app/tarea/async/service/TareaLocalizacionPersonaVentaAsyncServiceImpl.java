package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

@Service
public class TareaLocalizacionPersonaVentaAsyncServiceImpl implements TareaLocalizacionPersonaVentaAsyncService {

    @Autowired
    private TareaLocalizacionPersonaVentaService tareaLocalizacionPersonaVentaService;

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(
            final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, final TareaDto tarea) {
        tareaLocalizacionPersonaVentaService.savePtrVentaOnlineIpodIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponseDto(
            final PtrVentaIndividualDetalleResponseDto dto, final TareaDto tarea) {
        tareaLocalizacionPersonaVentaService.savePtrVentaIndividualDetalleResponseDto(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
