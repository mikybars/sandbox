package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseItemDTO;

public interface TrabajoTiendaSeccionVentaService {

	TrabajoTiendaSeccionVentaDto save(TrabajoTiendaSeccionVentaDto dto);

	CompletableFuture<Void> save(List<GetVentaTotalizadoResponseItemDTO> dto, TrabajoDto trabajoDto);

	CompletableFuture<Void> save(GetVentaTotalizadoResponseItemDTO dto, TrabajoDto trabajoDto);

}
