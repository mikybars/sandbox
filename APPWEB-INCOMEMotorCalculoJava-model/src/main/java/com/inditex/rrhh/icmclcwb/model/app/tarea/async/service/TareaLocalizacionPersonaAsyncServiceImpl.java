package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

@Service
public class TareaLocalizacionPersonaAsyncServiceImpl implements TareaLocalizacionPersonaAsyncService {

    @Autowired
    private TareaLocalizacionPersonaService tareaLocalizacionPersonaService;
    
    @Override
    public CompletableFuture<Void> savePtrPresenciaEmpleadosTiendaResponse(final PtrPresenciaEmpleadosTiendaResponseDto dto, final TareaDto tarea)  {
        tareaLocalizacionPersonaService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> mergePersonaLocalizacion(final RunTareaDto tarea)  {
        tareaLocalizacionPersonaService.mergePersonaLocalizacion(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
