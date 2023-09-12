package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaAgrupacionConfiguracionChallengeTipoVentaAsyncService {

  CompletableFuture<Void> save(List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src, TareaDto tarea);

  CompletableFuture<Void> saveConfChTpVentaResultItemDto(List<ConfChTpVentaResultItemDto> src, TareaDto tarea);

}
