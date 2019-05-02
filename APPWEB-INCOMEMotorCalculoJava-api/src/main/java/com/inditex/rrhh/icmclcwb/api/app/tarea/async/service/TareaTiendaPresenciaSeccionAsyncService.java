package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;



import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaTiendaPresenciaSeccionAsyncService {

    CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TareaDto tarea);

}
