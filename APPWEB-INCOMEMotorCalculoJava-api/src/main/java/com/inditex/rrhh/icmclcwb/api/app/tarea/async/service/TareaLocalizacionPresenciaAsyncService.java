package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPresenciaAsyncService {

    CompletableFuture<Void> save(@NotNull List<PresenciaManualWlocResultItemDto> src,
            @NotNull TareaDto tareaDto);

}
