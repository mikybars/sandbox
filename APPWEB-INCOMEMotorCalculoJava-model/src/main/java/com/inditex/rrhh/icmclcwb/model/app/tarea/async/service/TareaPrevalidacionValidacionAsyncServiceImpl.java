/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPrevalidacionValidacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionValidacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;

@Service
public class TareaPrevalidacionValidacionAsyncServiceImpl implements TareaPrevalidacionValidacionAsyncService {

    @Autowired
    private TareaPrevalidacionValidacionService tareaPrevalidacionValidacionService;

    @Override
    public CompletableFuture<Void> save(final List<ConfPreValidResultItemDto> confPreValidResultItemDto,
            final TareaPrevalidacionDto tareaPrevalidacionDto) {
        this.tareaPrevalidacionValidacionService.saveConfPreValidResultItemDto(confPreValidResultItemDto,
                tareaPrevalidacionDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
