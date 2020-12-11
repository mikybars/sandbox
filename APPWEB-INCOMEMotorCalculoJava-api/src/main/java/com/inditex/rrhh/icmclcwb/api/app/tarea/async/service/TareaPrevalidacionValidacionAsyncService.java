/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaPrevalidacionValidacionAsyncService {

    CompletableFuture<Void> save(List<ConfPreValidResultItemDto> confPreValidResultItemDto,
            TareaPrevalidacionDto tareaPrevalidacionDto);

}
