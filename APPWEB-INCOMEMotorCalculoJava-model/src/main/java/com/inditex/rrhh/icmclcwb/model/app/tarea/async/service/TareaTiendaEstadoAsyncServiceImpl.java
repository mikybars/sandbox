package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
public class TareaTiendaEstadoAsyncServiceImpl implements TareaTiendaEstadoAsyncService {

    @Autowired
    private TareaTiendaEstadoService tareaTiendaEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final RunTareaRecolectarDto runTareaRecolectar, final TareaDto tarea) {
        List<TareaTiendaEstadoDto> list = Stream
                .of(runTareaRecolectar.getUno().getTienda(), runTareaRecolectar.getDos().getTienda())
                .flatMap(Set::stream).collect(Collectors.toList());
        for (List<TareaTiendaEstadoDto> iter : StreamUtils.partition(list, /* TODO Parametrizar */200)) {
            tareaTiendaEstadoService.save(iter, tarea);
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
