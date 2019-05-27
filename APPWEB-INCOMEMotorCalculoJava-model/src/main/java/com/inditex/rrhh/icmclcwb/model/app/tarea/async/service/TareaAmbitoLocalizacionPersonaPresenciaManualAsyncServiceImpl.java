package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoLocalizacionPersonaPresenciaManualAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionPersonaPresenciaManualService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

@Service
public class TareaAmbitoLocalizacionPersonaPresenciaManualAsyncServiceImpl
        implements TareaAmbitoLocalizacionPersonaPresenciaManualAsyncService {

    @Autowired
    private TareaAmbitoLocalizacionPersonaPresenciaManualService tareaLocalizacionPersonaPresenciaManualService;
    
    @Override
    public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(final List<GenericEmpleadoResultItemDto> src, final TareaDto tareaDto)  {
        tareaLocalizacionPersonaPresenciaManualService.save(src, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
