package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaManualService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

@Service
public class TareaLocalizacionPersonaPresenciaManualAsyncServiceImpl
        implements TareaLocalizacionPersonaPresenciaManualAsyncService {

    @Autowired
    private TareaLocalizacionPersonaPresenciaManualService tareaLocalizacionPersonaPresenciaManualService;
    
    @Async
    @Override
    public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(final List<GenericEmpleadoResultItemDto> src, final TareaDto tareaDto)  {
        tareaLocalizacionPersonaPresenciaManualService.save(src, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
