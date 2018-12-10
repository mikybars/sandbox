package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoHistoricoDto;

public interface TrabajoEmpleadoHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico, @Valid TrabajoDto trabajo);

}
