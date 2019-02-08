package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaTotalizadoByMccResultItemDto implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;

	private String fecha;

	private Integer pais;

	private Integer cadena;

	private Integer tienda;

	private Integer seccion;

	private Integer temporada;

	private Integer producto;
	
	private List<MccType> mcc;

	private BigDecimal importeSinIVA;

	private BigDecimal importeConIVA;

}