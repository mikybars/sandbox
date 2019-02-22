package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;

public interface ProcesoTiendaComisionHistoricoAsyncService {

    CompletableFuture<Void> save(final List<ProcesoTiendaComisionHistoricoDto> procesoTiendaComisionHistoricoDto);

}
