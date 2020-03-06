package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPresupuestoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TareaPresupuestoAsyncServiceImpl implements TareaPresupuestoAsyncService {

    @Autowired
    private TareaPresupuestoService tareaPresupuestoService;

    @Override
    public CompletableFuture<Void> save(List<PresupuestosWlocResultItemDto> src, TareaDto tarea) {
        tareaPresupuestoService.save(src, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
