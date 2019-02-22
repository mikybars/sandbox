package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
public class ProcesoEmpleadoEstadoAsyncServiceImpl implements ProcesoEmpleadoEstadoAsyncService {

    @Autowired
    private ProcesoEmpleadoEstadoService procesoEmpleadoEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstado) {
        procesoEmpleadoEstadoService.save(procesoEmpleadoEstado);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> save(final RunProcesoRecolectarDto runProcesoRecolectar,
            @Valid final ProcesoDto proceso) {
        List<ProcesoEmpleadoEstadoDto> list = new ArrayList<>();
        list.addAll(runProcesoRecolectar.getUno().getEmpleado().stream().collect(Collectors.toList()));
        list.addAll(runProcesoRecolectar.getDos().getEmpleado().stream().collect(Collectors.toList()));
        for (List<ProcesoEmpleadoEstadoDto> iter : StreamUtils.partition(list, /*TODO Parametrizar*/200)) {
            procesoEmpleadoEstadoService.save(iter, proceso);
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
