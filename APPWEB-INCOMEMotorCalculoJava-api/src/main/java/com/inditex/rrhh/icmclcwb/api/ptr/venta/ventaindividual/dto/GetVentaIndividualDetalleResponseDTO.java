package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GetVentaIndividualDetalleResponseDTO implements Serializable {

	private static final long serialVersionUID = 7711562648623939042L;
	
	private List<GetVentaIndividualDetalleResponseItemDTO> ventaIndividualDetalle;

}
