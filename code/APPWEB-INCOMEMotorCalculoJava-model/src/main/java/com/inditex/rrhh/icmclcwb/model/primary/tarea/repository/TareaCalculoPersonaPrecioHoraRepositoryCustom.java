package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

public interface TareaCalculoPersonaPrecioHoraRepositoryCustom {

    List<IdPersonaLocalDto> ids(@NotNull Long idTarea);

    @Async("calculoExecutor")
    CompletableFuture<Void> insertPrecioHora(@NotNull Long idTarea, @NotNull Long icmIdPeriodo, @NotNull List<String> cclIdPersonList);

}
