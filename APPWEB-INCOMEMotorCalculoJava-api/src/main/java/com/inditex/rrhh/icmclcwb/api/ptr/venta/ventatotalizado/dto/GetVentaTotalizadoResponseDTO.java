package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GetVentaTotalizadoResponseDTO implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;
	
	private List<GetVentaTotalizadoResponseItemDTO> ventaTotalizado;

}