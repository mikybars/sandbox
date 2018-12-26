package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstructuraDto;

public interface TrabajoEmpleadoEstructuraAsyncService {

    CompletableFuture<Void> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura,
            @Valid TrabajoDto trabajo) throws Exception;

}
