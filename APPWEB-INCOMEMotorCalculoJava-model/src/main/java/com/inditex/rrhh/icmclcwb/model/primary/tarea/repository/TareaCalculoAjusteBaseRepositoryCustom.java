package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.springframework.scheduling.annotation.Async;

public interface TareaCalculoAjusteBaseRepositoryCustom {

  List<IdPersonaLocalDto> ids(final TareaDto tarea);

  @Async("ajusteExecutor")
  CompletableFuture<Void> ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
      final List<IdPersonaLocalDto> personas);

  String getSqlAjustar(final AlgoritmoAjusteDto algoritmoAjuste);

}
