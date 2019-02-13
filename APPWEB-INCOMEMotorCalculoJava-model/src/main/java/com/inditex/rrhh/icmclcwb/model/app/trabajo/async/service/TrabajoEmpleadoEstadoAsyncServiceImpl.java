package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
public class TrabajoEmpleadoEstadoAsyncServiceImpl implements TrabajoEmpleadoEstadoAsyncService {

    @Autowired
    private TrabajoEmpleadoEstadoService trabajoEmpleadoEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) {
        trabajoEmpleadoEstadoService.save(trabajoEmpleadoEstado);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> save(final RunTrabajoRecolectarDto runTrabajoRecolectar,
            @Valid final TrabajoDto trabajo) {
        List<TrabajoEmpleadoEstadoDto> list = new ArrayList<>();
        list.addAll(runTrabajoRecolectar.getUno().getEmpleado().stream().collect(Collectors.toList()));
        list.addAll(runTrabajoRecolectar.getDos().getEmpleado().stream().collect(Collectors.toList()));
        for (List<TrabajoEmpleadoEstadoDto> iter : StreamUtils.partition(list, /*TODO Parametrizar*/200)) {
            trabajoEmpleadoEstadoService.save(iter, trabajo);
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
