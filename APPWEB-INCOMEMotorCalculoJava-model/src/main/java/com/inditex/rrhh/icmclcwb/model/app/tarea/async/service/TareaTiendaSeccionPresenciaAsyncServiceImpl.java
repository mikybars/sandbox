package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaSeccionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TareaTiendaSeccionPresenciaAsyncServiceImpl implements TareaTiendaSeccionPresenciaAsyncService {

    @Autowired
    private TareaTiendaSeccionPresenciaService tareaTiendaSeccionPresenciaService;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea) {
        tareaTiendaSeccionPresenciaService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
