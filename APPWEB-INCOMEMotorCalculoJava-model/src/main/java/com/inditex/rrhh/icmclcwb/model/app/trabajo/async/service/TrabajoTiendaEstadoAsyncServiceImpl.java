package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
public class TrabajoTiendaEstadoAsyncServiceImpl implements TrabajoTiendaEstadoAsyncService {

    @Autowired
    private TrabajoTiendaEstadoService trabajoTiendaEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final RunTrabajoRecolectarDto runTrabajoRecolectar, final TrabajoDto trabajo) {
        List<TrabajoTiendaEstadoDto> list = Stream
                .of(runTrabajoRecolectar.getUno().getTienda(), runTrabajoRecolectar.getDos().getTienda())
                .flatMap(Set::stream).collect(Collectors.toList());
        for (List<TrabajoTiendaEstadoDto> iter : StreamUtils.partition(list, /* TODO Parametrizar */200)) {
            trabajoTiendaEstadoService.save(iter, trabajo);
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
