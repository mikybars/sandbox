package com.inditex.rrhh.icmclcwb.api.ptr.venta.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class GetVentaTotalizadoResponseItemDTO implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;

	private String fecha;

	private String pais;

	private String cadena;

	private String tienda;

	private String seccion;

	private String temporada;

	private String producto;

	private BigDecimal importeSinIVA;

	private BigDecimal importeConIVA;

}