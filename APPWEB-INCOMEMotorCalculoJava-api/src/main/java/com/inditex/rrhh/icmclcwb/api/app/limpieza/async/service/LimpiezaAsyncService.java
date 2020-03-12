package com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.springframework.scheduling.annotation.Async;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

@Async
public interface LimpiezaAsyncService {

    CompletableFuture<Void> limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea);

    CompletableFuture<Void> limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea);

    CompletableFuture<Void> limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea);

    CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea);

    CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea);

}
