package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;

@Service
public class TareaValidarAsyncServiceImpl implements TareaValidarAsyncService {

    @Autowired
    private TareaValidarService tareaValidarService;
    
    @Async
    @Override
    public CompletableFuture<List<String>> checkDuplicatedEmpleados(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedEmpleados(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<List<String>> checkDuplicatedTiendas(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedTiendas(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<List<String>> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedTiendasHistorico(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countEmpleados(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countEmpleados(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countEmpleadosHistorico(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countEmpleadosHistorico(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countTiendas(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendas(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countTiendasHistorico(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendasHistorico(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countEstructuras(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countEstructuras(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendaPresenciaSeccion(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendaEmpleadoPresenciaSeccion(idTarea));
    }

    @Async
    @Override
    public CompletableFuture<Integer> countTiendaVentaSeccion(@NotNull @Positive Long idTarea) {
        return CompletableFuture.completedFuture(tareaValidarService.countTiendaVentaSeccion(idTarea));
    }

}
