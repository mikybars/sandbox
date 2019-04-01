package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


import javax.validation.constraints.Positive;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaValidarAsyncService {

    CompletableFuture<List<String>> checkDuplicatedEmpleados(@NotNull @Positive Long idTarea);

    CompletableFuture<List<String>> checkDuplicatedTiendas(@NotNull @Positive Long idTarea);

    CompletableFuture<List<String>> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countEmpleados(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countEmpleadosHistorico(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countTiendas(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countTiendasHistorico(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countEstructuras(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea);

    CompletableFuture<Integer> countTiendaVentaSeccion(@NotNull @Positive Long idTarea);

    CompletableFuture<List<String>> validateAmbito(@NotNull @Positive Long idTarea);

}
