package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import org.springframework.scheduling.annotation.Async;

public interface TareaCalculoAlgoritmoBaseRepositoryCustom {

  List<IdPersonaLocalDto> ids(final AlgoritmoDTO algoritmo, final TareaDto tarea);

  @Async("calculoExecutor")
  CompletableFuture<Void> calcular(final AlgoritmoDTO algoritmo, final TareaDto tarea,
      final List<IdPersonaLocalDto> personas);

  String getSqlCalcular(final AlgoritmoDTO algoritmo);

}
