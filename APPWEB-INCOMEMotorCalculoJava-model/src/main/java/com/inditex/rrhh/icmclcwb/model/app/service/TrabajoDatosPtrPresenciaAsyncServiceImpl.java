package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaService;

@Service
public class TrabajoDatosPtrPresenciaAsyncServiceImpl implements TrabajoDatosPtrPresenciaAsyncService {

    @Autowired
    private TrabajoDatosPtrPresenciaService trabajoDatosPtrPresenciaService;

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo) throws Exception {
        trabajoDatosPtrPresenciaService.tiposHoras(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        trabajoDatosPtrPresenciaService.presenciaTotalizadaTienda(trabajo, tipoTrabajoTienda);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(TrabajoDto trabajo) throws Exception {
        trabajoDatosPtrPresenciaService.presenciaDetalleEmpleado(trabajo);
        return CompletableFuture.completedFuture(null);
    }

}