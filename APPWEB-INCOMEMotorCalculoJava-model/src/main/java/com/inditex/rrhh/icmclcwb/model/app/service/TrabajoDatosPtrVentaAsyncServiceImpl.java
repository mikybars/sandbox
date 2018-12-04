package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaService;

@Service
public class TrabajoDatosPtrVentaAsyncServiceImpl implements TrabajoDatosPtrVentaAsyncService {

    @Autowired
    private TrabajoDatosPtrVentaService trabajoDatosPtrVentaService;

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo,
            final List<TipoTrabajoTiendaDto> tipoTrabajoTienda, final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        trabajoDatosPtrVentaService.ventaTotalizadaTienda(trabajo, tipoTrabajoTienda, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo, final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        trabajoDatosPtrVentaService.ventaDetalleEmpleado(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

}