package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResultItemDto;

public interface TrabajoTiendaSeccionVentaService {

	TrabajoTiendaSeccionVentaDto save(@Valid final TrabajoTiendaSeccionVentaDto dto);

	TrabajoTiendaSeccionVentaDto save(PtrVentaTotalizadoResultItemDto dto, TrabajoDto trabajoDto);
	
	List<TrabajoTiendaSeccionVentaDto> save(List<PtrVentaTotalizadoResultItemDto> dto, TrabajoDto trabajoDto);

}
