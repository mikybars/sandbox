package com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GetVentaTotalizadoResponseDTO implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;
	
	private List<GetVentaTotalizadoResponseItemDTO> ventaTotalizado;

}