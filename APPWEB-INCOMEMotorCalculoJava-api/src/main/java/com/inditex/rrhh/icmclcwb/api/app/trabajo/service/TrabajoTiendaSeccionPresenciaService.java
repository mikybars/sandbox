package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface TrabajoTiendaSeccionPresenciaService {

	CompletableFuture<Void> save(@Valid final TrabajoTiendaSeccionPresenciaDto dto);

    CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TrabajoDto trabajo)
           ;

}
