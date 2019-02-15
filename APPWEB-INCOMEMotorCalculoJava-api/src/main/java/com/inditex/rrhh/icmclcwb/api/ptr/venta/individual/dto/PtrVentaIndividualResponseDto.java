package com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaIndividualResponseDto implements Serializable {

	private static final long serialVersionUID = 7711562648623939042L;
	
	private List<PtrVentaIndividualResultItemDto> ventaIndividual;

}
