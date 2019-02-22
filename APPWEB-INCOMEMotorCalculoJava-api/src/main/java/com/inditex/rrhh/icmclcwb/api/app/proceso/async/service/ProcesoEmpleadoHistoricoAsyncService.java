package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;

public interface ProcesoEmpleadoHistoricoAsyncService {

    CompletableFuture<Void> save(final List<ProcesoEmpleadoHistoricoDto> procesoEmpleadoHistorico, @Valid ProcesoDto proceso);

}
