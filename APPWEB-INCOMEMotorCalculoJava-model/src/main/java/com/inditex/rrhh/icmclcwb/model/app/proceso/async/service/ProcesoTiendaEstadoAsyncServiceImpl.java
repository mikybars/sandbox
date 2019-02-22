package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
public class ProcesoTiendaEstadoAsyncServiceImpl implements ProcesoTiendaEstadoAsyncService {

    @Autowired
    private ProcesoTiendaEstadoService procesoTiendaEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final RunProcesoRecolectarDto runProcesoRecolectar, final ProcesoDto proceso) {
        List<ProcesoTiendaEstadoDto> list = Stream
                .of(runProcesoRecolectar.getUno().getTienda(), runProcesoRecolectar.getDos().getTienda())
                .flatMap(Set::stream).collect(Collectors.toList());
        for (List<ProcesoTiendaEstadoDto> iter : StreamUtils.partition(list, /* TODO Parametrizar */200)) {
            procesoTiendaEstadoService.save(iter, proceso);
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
