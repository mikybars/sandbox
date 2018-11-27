package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableRequestDto;

public class PtrPresenciasMockMapperComisionable {

	
	public static PtrPresenciasDetalleRequestDto asPresenciaComisionableToDetalle(PtrPresenciasDetalleComisionableRequestDto src){
		List<Integer> list  = new ArrayList<Integer>();
		for (int i=0;i<src.getCadena().size();i++){
		list.add(src.getCadena().get(i));
		}
		return new PtrPresenciasDetalleRequestDto(src.getTienda(),src.getSeccion(), src.getPersonas(),src.getFechaDesde(),src.getFechaHasta(), src.getTipo(), list, src.getOrigen());
		
	}
}
