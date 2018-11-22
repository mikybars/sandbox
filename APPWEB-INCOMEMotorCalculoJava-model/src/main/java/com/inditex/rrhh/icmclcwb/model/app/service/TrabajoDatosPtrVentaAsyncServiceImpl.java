package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaService;

@Service
public class TrabajoDatosPtrVentaAsyncServiceImpl implements TrabajoDatosPtrVentaAsyncService {

    @Autowired
    private TrabajoDatosPtrVentaService trabajoDatosPtrVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        trabajoDatosPtrVentaService.ventaTotalizadaTienda(trabajo, tipoTrabajoTienda);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo) throws Exception {
        trabajoDatosPtrVentaService.ventaDetalleEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }

}