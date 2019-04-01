package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;

@Service
public class TareaValidarAsyncServiceImpl implements TareaValidarAsyncService {

    @Autowired
    private TareaValidarService tareaValidarService;
    
    
    @Override
    public CompletableFuture<List<String>> checkDuplicatedEmpleados(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedEmpleados(idTarea));
    }

    
    @Override
    public CompletableFuture<List<String>> checkDuplicatedTiendas(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedTiendas(idTarea));
    }

    
    @Override
    public CompletableFuture<List<String>> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedTiendasHistorico(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countEmpleados(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countEmpleados(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countEmpleadosHistorico(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countEmpleadosHistorico(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countTiendas(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendas(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countTiendasHistorico(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendasHistorico(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countEstructuras(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countEstructuras(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendaPresenciaSeccion(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendaEmpleadoPresenciaSeccion(idTarea));
    }

    
    @Override
    public CompletableFuture<Integer> countTiendaVentaSeccion(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendaVentaSeccion(idTarea));
    }
    
    
    @Override
    public CompletableFuture<List<String>> validateAmbito(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.validateAmbito(idTarea));
    }
    
}
