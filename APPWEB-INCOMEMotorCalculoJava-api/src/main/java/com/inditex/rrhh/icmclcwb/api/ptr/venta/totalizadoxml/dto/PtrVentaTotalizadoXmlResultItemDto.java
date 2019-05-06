package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrVentaTotalizadoXmlResultItemDto implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;

	private String fecha;

	private Integer pais;

	private Integer cadena;

	private Integer tienda;

	private Integer seccion;

	private Integer temporada;

	private Integer producto;

	private BigDecimal importeSinIVA;

	private BigDecimal importeConIVA;

}