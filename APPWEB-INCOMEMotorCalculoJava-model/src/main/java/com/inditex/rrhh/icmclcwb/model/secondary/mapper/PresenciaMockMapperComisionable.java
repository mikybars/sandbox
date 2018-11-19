package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;

public class PresenciaMockMapperComisionable {

	
	public static PresenciasDetalleRequestDto asPresenciaComisionableToDetalle(PresenciasDetalleComisionableRequestDto src){
		List<Integer> list  = new ArrayList<Integer>();
		for (int i=0;i<src.getCadena().size();i++){
		list.add(src.getCadena().get(i));
		}
		return new PresenciasDetalleRequestDto(src.getTienda(),src.getSeccion(), src.getPersonas(),src.getFechaDesde(),src.getFechaHasta(), src.getTipo(), list, src.getOrigen());
		
	}
}
