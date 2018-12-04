package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
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
    public CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            final List<TipoTrabajoTiendaDto> tipoTrabajoTienda, final TrabajoRunDatosDto trabajoRunDatos)
            throws Exception {
        trabajoDatosPtrPresenciaService.presenciaTotalizadaTienda(trabajo, tipoTrabajoTienda, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo,
            final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        trabajoDatosPtrPresenciaService.presenciaDetalleEmpleado(trabajo, trabajoRunDatos);
        return CompletableFuture.completedFuture(null);
    }

}