package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosService;

@Service
@Validated
public class TrabajoDatosAsyncServiceImpl implements TrabajoDatosAsyncService {

    @Autowired
    private TrabajoDatosService trabajoDatosService;

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.empleadosTienda(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.tiendasParametro(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        trabajoDatosService.ventaTotalizadaTienda(trabajo, tipoTrabajoTienda);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.condicionesEmpleados(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.ventaDetalleEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
        trabajoDatosService.tiposHoras(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(@Valid TrabajoDto trabajo) throws Exception {
        trabajoDatosService.tiendasHistorico(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @NotNull List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        trabajoDatosService.presenciaTotalizadaTienda(trabajo, tipoTrabajoTienda);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(@Valid TrabajoDto trabajo) throws Exception {
        trabajoDatosService.presenciaDetalleEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }

}