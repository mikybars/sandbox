package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoSeccionEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoSeccionEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

@Service
public class TareaEmpleadoSeccionEstructuraAsyncServiceImpl implements TareaEmpleadoSeccionEstructuraAsyncService{

    @Autowired
    private TareaEmpleadoSeccionEstructuraService tareaEmpleadoSeccionEstructuraService;
    
    @Override
    public CompletableFuture<Void> save(List<TareaEmpleadoSeccionEstructuraDto> tareaEmpleadoEstructura,
            TareaDto tareaDto) {
        tareaEmpleadoSeccionEstructuraService.save(tareaEmpleadoEstructura, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> saveComisionEmpleadoResultItemDto(
            List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, TareaDto tareaDto) {
        tareaEmpleadoSeccionEstructuraService.saveComisionEmpleadoResultItemDto(comisionEmpleadoResultItemDto, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
