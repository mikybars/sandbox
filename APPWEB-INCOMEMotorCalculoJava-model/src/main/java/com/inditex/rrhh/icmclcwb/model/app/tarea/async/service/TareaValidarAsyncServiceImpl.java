package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaValidarAsyncServiceImpl implements TareaValidarAsyncService {

  @Autowired
  private TareaValidarService tareaValidarService;

  @Override
  public CompletableFuture<List<String>> checkDuplicatedTiendasHistorico(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedTiendasHistorico(idTarea));
  }

  @Override
  public CompletableFuture<List<String>> checkDuplicatedTiposHora(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.checkDuplicatedTiposHora(idTarea));
  }

  @Override
  public CompletableFuture<Integer> countEmpleadosHistorico(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.countEmpleadosHistorico(idTarea));
  }

  @Override
  public CompletableFuture<Integer> countTiendasHistorico(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.countTiendasHistorico(idTarea));
  }

  @Override
  public CompletableFuture<Integer> countEstructuras(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.countEstructuras(idTarea));
  }

  @Override
  public CompletableFuture<Integer> countTiendaPresenciaSeccion(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.countTiendaPresenciaSeccion(idTarea));
  }

  @Override
  public CompletableFuture<Integer> countLocalizacionPersonaPresencia(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.countTiendaEmpleadoPresenciaSeccion(idTarea));
  }

  @Override
  public CompletableFuture<Integer> countLocalizacionVenta(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.countTiendaVentaSeccion(idTarea));
  }

  @Override
  public CompletableFuture<List<String>> validateAmbito(Long idTarea) {
    return CompletableFuture.completedFuture(tareaValidarService.validateAmbito(idTarea));
  }

}
