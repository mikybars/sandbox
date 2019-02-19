package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
public class TareaEmpleadoEstadoAsyncServiceImpl implements TareaEmpleadoEstadoAsyncService {

    @Autowired
    private TareaEmpleadoEstadoService tareaEmpleadoEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado) {
        tareaEmpleadoEstadoService.save(tareaEmpleadoEstado);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> save(final RunTareaRecolectarDto runTareaRecolectar,
            @Valid final TareaDto tarea) {
        List<TareaEmpleadoEstadoDto> list = new ArrayList<>();
        list.addAll(runTareaRecolectar.getUno().getEmpleado().stream().collect(Collectors.toList()));
        list.addAll(runTareaRecolectar.getDos().getEmpleado().stream().collect(Collectors.toList()));
        for (List<TareaEmpleadoEstadoDto> iter : StreamUtils.partition(list, /*TODO Parametrizar*/200)) {
            tareaEmpleadoEstadoService.save(iter, tarea);
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
