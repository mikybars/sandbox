package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosService;

@Service
public class TrabajoDatosAsyncServiceImpl implements TrabajoDatosAsyncService {

    @Autowired
    private TrabajoDatosService trabajoDatosService;

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.empleadosTienda(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasParametro(final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.tiendasParametro(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        trabajoDatosService.ventaTotalizadaTienda(trabajo, tipoTrabajoTienda);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.condicionesEmpleados(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.ventaDetalleEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.tiposHoras(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(TrabajoDto trabajo) throws Exception {
        trabajoDatosService.tiendasHistorico(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        trabajoDatosService.presenciaTotalizadaTienda(trabajo, tipoTrabajoTienda);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(TrabajoDto trabajo) throws Exception {
        trabajoDatosService.presenciaDetalleEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }

}