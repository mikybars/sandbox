package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaDiariaResponseDto implements Serializable {

	private static final long serialVersionUID = 7711562648623939042L;
	
	private List<PtrVentaDiariaResultItemDto> ventaDiaria;

}
