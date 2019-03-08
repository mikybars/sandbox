package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaSeccionEmpleadoPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

@Deprecated
@Service
public class TareaTiendaSeccionEmpleadoPresenciaAsyncServiceImpl implements TareaTiendaSeccionEmpleadoPresenciaAsyncService{

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaService tareaTiendaSeccionEmpleadoPresenciaService;
    
    @Override
    public CompletableFuture<Void> save(@Valid final TareaTiendaSeccionEmpleadoPresenciaDto dto) {
        tareaTiendaSeccionEmpleadoPresenciaService.save(dto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TareaDto tareaDto) {
        tareaTiendaSeccionEmpleadoPresenciaService.save(dtos, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
