package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

@Service
public class TareaLocalizacionPersonaPresenciaAsyncServiceImpl
        implements TareaLocalizacionPersonaPresenciaAsyncService {

    @Autowired
    private TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrPresenciaEmpleadosTiendaResponse(final PtrPresenciaEmpleadosTiendaResponseDto dto, final TareaDto tarea)  {
        tareaLocalizacionPersonaPresenciaService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
