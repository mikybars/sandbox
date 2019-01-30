package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoDatosPtrPresenciaAsyncServiceImpl implements TrabajoDatosPtrPresenciaAsyncService {

    @Autowired
    private TrabajoDatosPtrPresenciaService trabajoDatosPtrPresenciaService;

    @Async
    @Override
    public CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo) throws Exception {
        trabajoDatosPtrPresenciaService.tiposHoras(trabajo);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosPtrPresenciaService.presenciaTotalizadaTienda(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        trabajoDatosPtrPresenciaService.presenciaDetalleEmpleado(trabajo, trabajoRunDatosBloque);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}