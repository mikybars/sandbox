package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface TareaTiendaPresenciaSeccionAsyncService {

    @Deprecated
    CompletableFuture<Void> pivot(@Valid final TareaDto tarea);

    CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TareaDto tarea);

}
