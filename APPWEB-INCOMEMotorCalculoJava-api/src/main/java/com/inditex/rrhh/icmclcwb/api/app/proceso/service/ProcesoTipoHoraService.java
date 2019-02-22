package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;

public interface ProcesoTipoHoraService {

    CompletableFuture<Void> save(final List<PtrPresenciaTiposHorasResultItemDto> item, final ProcesoDto proceso);

}
