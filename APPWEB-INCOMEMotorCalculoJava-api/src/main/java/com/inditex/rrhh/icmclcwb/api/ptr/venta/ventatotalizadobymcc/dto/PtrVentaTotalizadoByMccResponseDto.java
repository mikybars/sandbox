package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaTotalizadoByMccResponseDto implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;
	
	private List<PtrVentaTotalizadoByMccResultItemDto> ventaTotalizadoByMCC;

}