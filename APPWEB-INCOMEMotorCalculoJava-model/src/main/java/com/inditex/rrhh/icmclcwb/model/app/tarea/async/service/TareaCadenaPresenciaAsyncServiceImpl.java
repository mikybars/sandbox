package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCadenaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCadenaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TareaCadenaPresenciaAsyncServiceImpl implements TareaCadenaPresenciaAsyncService {

    @Autowired
    private TareaCadenaPresenciaService tareaCadenaPresenciaService;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea) {
        tareaCadenaPresenciaService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
