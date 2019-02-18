package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;

public interface TareaTiendaSeccionVentaService {

	TareaTiendaSeccionVentaDto save(@Valid final TareaTiendaSeccionVentaDto item);

	TareaTiendaSeccionVentaDto save(final PtrVentaTotalizadoResultItemDto item, final TareaDto tarea);
	
	List<TareaTiendaSeccionVentaDto> save(final List<PtrVentaTotalizadoResultItemDto> item, final TareaDto tarea);

}
