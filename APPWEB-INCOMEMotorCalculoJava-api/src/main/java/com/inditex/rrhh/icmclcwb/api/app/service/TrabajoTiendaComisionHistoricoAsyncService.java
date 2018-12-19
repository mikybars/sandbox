package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaComisionHistoricoDto;

public interface TrabajoTiendaComisionHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto);

}
