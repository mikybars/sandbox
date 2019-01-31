package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;

public interface TrabajoTipoHoraService {

    CompletableFuture<Void> save(List<PtrPresenciaTiposHorasResultItemDto> dto, TrabajoDto trabajoDto) throws Exception;

}
