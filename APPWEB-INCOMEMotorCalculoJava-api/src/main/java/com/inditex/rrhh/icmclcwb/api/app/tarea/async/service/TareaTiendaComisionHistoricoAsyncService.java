package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;

public interface TareaTiendaComisionHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoDto);

}
