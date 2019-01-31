package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResultItemDto;

@Service
public class TrabajoTiendaSeccionVentaAsyncServiceImpl implements TrabajoTiendaSeccionVentaAsyncService {

    @Autowired
    private TrabajoTiendaSeccionVentaService trabajoTiendaSeccionVentaService;

    @Async
    @Override
    public CompletableFuture<Void> save(PtrVentaTotalizadoResultItemDto dto, TrabajoDto trabajoDto) {
        trabajoTiendaSeccionVentaService.save(dto, trabajoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> save(List<PtrVentaTotalizadoResultItemDto> dto, @Valid TrabajoDto trabajoDto) throws Exception  {
        trabajoTiendaSeccionVentaService.save(dto, trabajoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
