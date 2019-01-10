package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;

@Service
public class TrabajoEmpleadoEstadoAsyncServiceImpl implements TrabajoEmpleadoEstadoAsyncService {

    @Autowired
    private TrabajoEmpleadoEstadoService trabajoEmpleadoEstadoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) throws Exception {
        trabajoEmpleadoEstadoService.save(trabajoEmpleadoEstado);
        return CompletableFuture.completedFuture(null);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> save(final TrabajoRunDatosDto trabajoRunDatos, 
            @Valid final TrabajoDto trabajo) throws Exception {
        
        List<TrabajoEmpleadoEstadoDto> list = new ArrayList<>();
        
        list.addAll(trabajoRunDatos.getUno().getEmpleado().stream().collect(Collectors.toList()));
        list.addAll(trabajoRunDatos.getDos().getEmpleado().stream().collect(Collectors.toList()));
        
        final AtomicInteger counter1 = new AtomicInteger(0);
        for (List<TrabajoEmpleadoEstadoDto> iter : list.stream()
                .collect(Collectors.groupingBy(
                        item -> counter1.getAndIncrement() / 200))
                .values()) {
            trabajoEmpleadoEstadoService.save(iter, trabajo);
        }
        return CompletableFuture.completedFuture(null);
    }


}