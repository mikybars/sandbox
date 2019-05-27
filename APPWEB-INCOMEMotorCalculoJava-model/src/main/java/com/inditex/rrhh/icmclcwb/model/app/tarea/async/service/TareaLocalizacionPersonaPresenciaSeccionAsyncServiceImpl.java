package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

@Service
public class TareaLocalizacionPersonaPresenciaSeccionAsyncServiceImpl
        implements TareaLocalizacionPersonaPresenciaSeccionAsyncService {

    @Autowired
    private TareaLocalizacionPersonaPresenciaSeccionService tareaLocalizacionPersonaPresenciaSeccionService;
    
    @Override
    public CompletableFuture<Void> save(@NotNull List<PtrPresenciaDetalleResultItemDto> src, @NotNull TareaDto tareaDto){
        tareaLocalizacionPersonaPresenciaSeccionService.save(src, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
