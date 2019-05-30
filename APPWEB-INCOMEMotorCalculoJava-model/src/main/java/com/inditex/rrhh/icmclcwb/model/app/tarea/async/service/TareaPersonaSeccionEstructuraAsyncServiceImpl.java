package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaSeccionEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaSeccionEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

@Service
public class TareaPersonaSeccionEstructuraAsyncServiceImpl implements TareaPersonaSeccionEstructuraAsyncService{

    @Autowired
    private TareaPersonaSeccionEstructuraService tareaPersonaSeccionEstructuraService;
    
    @Override
    public CompletableFuture<Void> save(List<TareaPersonaSeccionEstructuraDto> tareaEmpleadoEstructura,
            TareaDto tareaDto) {
        tareaPersonaSeccionEstructuraService.save(tareaEmpleadoEstructura, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> saveComisionEmpleadoResultItemDto(
            List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, TareaDto tareaDto) {
        tareaPersonaSeccionEstructuraService.saveComisionEmpleadoResultItemDto(comisionEmpleadoResultItemDto, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
