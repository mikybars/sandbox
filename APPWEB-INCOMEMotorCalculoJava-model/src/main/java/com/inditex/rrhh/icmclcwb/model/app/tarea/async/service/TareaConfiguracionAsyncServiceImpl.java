package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TareaConfiguracionAsyncServiceImpl implements TareaConfiguracionAsyncService {

    @Override
    public CompletableFuture<Void> saveConfiguracionItemDto(List<ConfiguracionItemDto> src, TareaDto tarea) {

        return null;
    }
}
