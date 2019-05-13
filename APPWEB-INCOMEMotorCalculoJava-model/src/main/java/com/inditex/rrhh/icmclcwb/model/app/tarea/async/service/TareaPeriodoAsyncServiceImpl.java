package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPeriodoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;

@Service
public class TareaPeriodoAsyncServiceImpl implements TareaPeriodoAsyncService {

    @Autowired
    private TareaPeriodoService tareaPeriodoService;
    
    @Override
    public CompletableFuture<Void> save(final List<PeriodosResultItemDto> src,
           final TareaDto tarea) {
        tareaPeriodoService.save(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
