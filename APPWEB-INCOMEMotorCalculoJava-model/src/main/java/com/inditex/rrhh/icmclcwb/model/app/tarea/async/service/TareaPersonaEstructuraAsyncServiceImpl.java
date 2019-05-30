package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

@Service
public class TareaPersonaEstructuraAsyncServiceImpl implements TareaPersonaEstructuraAsyncService {

    @Autowired
    private TareaPersonaEstructuraService tareaPersonaEstructuraService;

    
    @Override
    public CompletableFuture<Void> save(final List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
           final TareaDto tarea) {
        tareaPersonaEstructuraService.save(tareaPersonaEstructura, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> saveComisionEmpleadoResultItemDto(
            final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto,final TareaDto tarea) {
        tareaPersonaEstructuraService.saveComisionEmpleadoResultItemDto(comisionEmpleadoResultItemDto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
