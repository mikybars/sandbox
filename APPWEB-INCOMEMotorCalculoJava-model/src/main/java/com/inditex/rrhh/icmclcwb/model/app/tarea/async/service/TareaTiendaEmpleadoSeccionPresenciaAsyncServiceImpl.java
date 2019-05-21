package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEmpleadoSeccionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaEmpleadoSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

@Service
public class TareaTiendaEmpleadoSeccionPresenciaAsyncServiceImpl implements TareaTiendaEmpleadoSeccionPresenciaAsyncService {
    
    @Autowired
    private TareaTiendaEmpleadoSeccionPresenciaService tareaTiendaEmpleadoSeccionPresenciaService;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleResultItemDto> dtos, TareaDto tareaDto) {
        tareaTiendaEmpleadoSeccionPresenciaService.save(dtos, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
