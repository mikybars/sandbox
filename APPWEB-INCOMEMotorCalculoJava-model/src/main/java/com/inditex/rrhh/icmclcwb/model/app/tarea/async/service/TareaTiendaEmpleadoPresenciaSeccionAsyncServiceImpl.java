package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEmpleadoPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaEmpleadoPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

@Service
public class TareaTiendaEmpleadoPresenciaSeccionAsyncServiceImpl
        implements TareaTiendaEmpleadoPresenciaSeccionAsyncService {

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionService tareaTiendaEmpleadoPresenciaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TareaDto tareaDto) {
        tareaTiendaEmpleadoPresenciaSeccionService.save(dtos, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
