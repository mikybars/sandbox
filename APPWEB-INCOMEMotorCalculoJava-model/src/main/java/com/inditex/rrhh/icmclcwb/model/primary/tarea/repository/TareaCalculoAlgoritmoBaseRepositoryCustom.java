package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoAlgoritmoBaseRepositoryCustom {

    List<IdPersonaLocalDto> ids(final AlgoritmoDto algoritmo, final TareaDto tarea);

    @Async("calculoExecutor")
    CompletableFuture<Void> calcular(final AlgoritmoDto algoritmo, final TareaDto tarea,
            final List<IdPersonaLocalDto> personas);

    String getSqlCalcular(final AlgoritmoDto algoritmo);

}
