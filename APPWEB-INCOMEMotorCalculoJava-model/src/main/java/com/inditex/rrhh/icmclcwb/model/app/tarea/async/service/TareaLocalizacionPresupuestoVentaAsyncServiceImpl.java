package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaLocalizacionPresupuestoVentaAsyncServiceImpl
        implements TareaLocalizacionPresupuestoVentaAsyncService {

    @Autowired
    private TareaLocalizacionPresupuestoVentaService tareaLocalizacionPresupuestoVentaService;

    @Override
    public CompletableFuture<Void> save(List<TareaLocalizacionPresupuestoVentaDto> dto) {
        tareaLocalizacionPresupuestoVentaService.save(dto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
