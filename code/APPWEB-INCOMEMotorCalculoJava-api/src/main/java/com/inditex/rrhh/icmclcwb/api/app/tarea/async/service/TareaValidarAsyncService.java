package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaValidarAsyncService {

  CompletableFuture<List<String>> checkDuplicatedTiendasHistorico(Long idTarea);

  CompletableFuture<Integer> countEmpleadosHistorico(Long idTarea);

  CompletableFuture<Integer> countTiendasHistorico(Long idTarea);

  CompletableFuture<Integer> countEstructuras(Long idTarea);

  CompletableFuture<Integer> countTiendaPresenciaSeccion(Long idTarea);

  CompletableFuture<Integer> countLocalizacionPersonaPresencia(Long idTarea);

  CompletableFuture<Integer> countLocalizacionVenta(Long idTarea);

  CompletableFuture<List<String>> validateAmbito(Long idTarea);

  CompletableFuture<List<String>> checkDuplicatedTiposHora(Long idTarea);

}
