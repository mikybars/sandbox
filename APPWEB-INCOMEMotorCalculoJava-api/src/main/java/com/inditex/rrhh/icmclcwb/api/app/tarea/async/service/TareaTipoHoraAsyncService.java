package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaTipoHoraAsyncService {

    CompletableFuture<Void> save(List<PtrPresenciaTiposHorasResultItemDto> dto, TareaDto tareaDto);

    CompletableFuture<Void> save(TiposHoraResponseDto dto, TareaDto tarea);

}
