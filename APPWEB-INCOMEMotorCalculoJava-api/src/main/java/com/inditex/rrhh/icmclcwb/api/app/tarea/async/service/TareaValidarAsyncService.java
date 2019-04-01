package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;




import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaValidarAsyncService {

    CompletableFuture<List<String>> checkDuplicatedEmpleados(Long idTarea);

    CompletableFuture<List<String>> checkDuplicatedTiendas(Long idTarea);

    CompletableFuture<List<String>> checkDuplicatedTiendasHistorico(Long idTarea);

    CompletableFuture<Integer> countEmpleados(Long idTarea);

    CompletableFuture<Integer> countEmpleadosHistorico(Long idTarea);

    CompletableFuture<Integer> countTiendas(Long idTarea);

    CompletableFuture<Integer> countTiendasHistorico(Long idTarea);

    CompletableFuture<Integer> countEstructuras(Long idTarea);

    CompletableFuture<Integer> countTiendaPresenciaSeccion(Long idTarea);

    CompletableFuture<Integer> countTiendaEmpleadoPresenciaSeccion(Long idTarea);

    CompletableFuture<Integer> countTiendaVentaSeccion(Long idTarea);

    CompletableFuture<List<String>> validateAmbito(Long idTarea);

}
