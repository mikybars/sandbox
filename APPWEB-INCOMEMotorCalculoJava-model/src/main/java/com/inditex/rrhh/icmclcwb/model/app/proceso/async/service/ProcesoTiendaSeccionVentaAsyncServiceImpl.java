package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

@Service
public class ProcesoTiendaSeccionVentaAsyncServiceImpl implements ProcesoTiendaSeccionVentaAsyncService {

    @Autowired
    private ProcesoTiendaSeccionVentaService procesoTiendaSeccionVentaService;

    @Async
    @Override
    public CompletableFuture<Void> save(final PtrVentaTotalizadoResultItemDto item, final ProcesoDto proceso) {
        procesoTiendaSeccionVentaService.save(item, proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> save(final List<PtrVentaTotalizadoResultItemDto> item, @Valid final ProcesoDto proceso)  {
        procesoTiendaSeccionVentaService.save(item, proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
