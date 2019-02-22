package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;

public interface ProcesoEmpleadoEstructuraAsyncService {

    CompletableFuture<Void> save(final List<ProcesoEmpleadoEstructuraDto> procesoEmpleadoEstructura,
            @Valid ProcesoDto proceso);

}
