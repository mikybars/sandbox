package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

public interface ProcesoTiendaSeccionVentaService {

	ProcesoTiendaSeccionVentaDto save(@Valid final ProcesoTiendaSeccionVentaDto item);

	ProcesoTiendaSeccionVentaDto save(final PtrVentaTotalizadoResultItemDto item, final ProcesoDto proceso);
	
	List<ProcesoTiendaSeccionVentaDto> save(final List<PtrVentaTotalizadoResultItemDto> item, final ProcesoDto proceso);

}
