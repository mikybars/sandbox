package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

@Service
public class TareaPersonaLocalizacionVentaAsyncServiceImpl implements TareaPersonaLocalizacionVentaAsyncService {

    @Autowired
    private TareaPersonaLocalizacionVentaService tareaPersonaLocalizacionVentaService;

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(
            final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, final TareaDto tarea) {
        tareaPersonaLocalizacionVentaService.savePtrVentaOnlineIpodIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponseDto(
            final PtrVentaIndividualDetalleResponseDto dto, final TareaDto tarea) {
        tareaPersonaLocalizacionVentaService.savePtrVentaIndividualDetalleResponseDto(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
