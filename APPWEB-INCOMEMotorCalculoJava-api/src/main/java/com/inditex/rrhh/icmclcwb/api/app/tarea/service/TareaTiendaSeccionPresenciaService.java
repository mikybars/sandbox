package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface TareaTiendaSeccionPresenciaService {

    CompletableFuture<Void> save(@Valid final TareaTiendaSeccionPresenciaDto dto);

    CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TareaDto tarea);

}
