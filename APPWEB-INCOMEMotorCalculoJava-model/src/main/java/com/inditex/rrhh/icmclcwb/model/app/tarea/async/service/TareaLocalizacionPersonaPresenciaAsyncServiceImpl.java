package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

@Service
public class TareaLocalizacionPersonaPresenciaAsyncServiceImpl
        implements TareaLocalizacionPersonaPresenciaAsyncService {

    @Autowired
    private TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;

    @Override
    public CompletableFuture<Void> save(@NotNull List<GenericEmpleadoResultItemDto> src, @NotNull TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaService.save(src, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrPresenciaDetalle(@NotNull List<PtrPresenciaDetalleResultItemDto> src,
            @NotNull TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaService.savePtrPresenciaDetalle(src, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivo(@NotNull RunTareaDto runTareaDto) {
        tareaLocalizacionPersonaPresenciaService.updateActivo(runTareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
