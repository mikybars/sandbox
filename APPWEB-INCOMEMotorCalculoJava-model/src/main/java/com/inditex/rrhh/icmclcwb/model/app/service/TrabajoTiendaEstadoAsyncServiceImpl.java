package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoService;

@Service
public class TrabajoTiendaEstadoAsyncServiceImpl implements TrabajoTiendaEstadoAsyncService {

	@Autowired
	private TrabajoTiendaEstadoService trabajoTiendaEstadoService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final TrabajoRunDatosDto trabajoRunDatos, final TrabajoDto trabajo) throws Exception {
    	
        List<TrabajoTiendaEstadoDto> list = getTiendas(trabajoRunDatos.getUno().getTienda(), 
                trabajoRunDatos.getDos().getTienda());     
        final AtomicInteger counter1 = new AtomicInteger(0);
        for (List<TrabajoTiendaEstadoDto> iter : list.stream()
                .collect(Collectors.groupingBy(
                        item -> counter1.getAndIncrement() / 200))
                .values()) {
            trabajoTiendaEstadoService.save(iter, trabajo);
        }
        return CompletableFuture.completedFuture(null);
    }
    
    private <T> List<T> getTiendas(Set<T>... args) {
        return Stream.of(args).flatMap(Set::stream).collect(Collectors.toList());
    }
}
