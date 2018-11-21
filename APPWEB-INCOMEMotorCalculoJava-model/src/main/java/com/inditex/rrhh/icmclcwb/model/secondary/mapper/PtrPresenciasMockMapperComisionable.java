package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;

public class PtrPresenciasMockMapperComisionable {

	public static PtrPresenciasMockDetalleRequestDto asPresenciaComisionableToDetalle(
			PtrPresenciasMockDetalleComisionableRequestDto src) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < src.getCadena().size(); i++) {
			list.add(src.getCadena().get(i));
		}
		return new PtrPresenciasMockDetalleRequestDto(src.getTienda(), src.getSeccion(), src.getPersonas(),
				src.getFechaDesde(), src.getFechaHasta(), src.getTipo(), list, src.getOrigen());

	}
}
