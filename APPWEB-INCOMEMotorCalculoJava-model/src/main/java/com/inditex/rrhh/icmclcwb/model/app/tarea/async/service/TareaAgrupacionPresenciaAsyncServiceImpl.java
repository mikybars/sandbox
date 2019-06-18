package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TareaAgrupacionPresenciaAsyncServiceImpl implements TareaAgrupacionPresenciaAsyncService {

    @Autowired
    private TareaAgrupacionPresenciaService tareaAgrupacionPresenciaService;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea,
        List<TareaAgrupacionCadenasDto> agrupaciones) {
        tareaAgrupacionPresenciaService.save(dto, tarea, agrupaciones);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
