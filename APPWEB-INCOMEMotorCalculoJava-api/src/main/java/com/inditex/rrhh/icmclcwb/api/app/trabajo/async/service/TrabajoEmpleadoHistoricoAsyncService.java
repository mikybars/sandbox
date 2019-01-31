package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;

public interface TrabajoEmpleadoHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico, @Valid TrabajoDto trabajo) throws Exception;

}
