package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaComisionHistoricoDto;

public interface TrabajoTiendaComisionHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto) throws Exception;

}
