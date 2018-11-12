package com.inditex.rrhh.icmclcwb.api.ptr.venta.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GetVentaIndividualDetalleResponseItemDTO implements Serializable {
	
	
	private static final long serialVersionUID = -801740758955645983L;

	@NotBlank
	private String fecha;

	private String pais;

	private String cadena;

	@NotBlank
	private String tienda;

	private String seccion;

	private String temporada;

	private String producto;

	@NotNull
	private BigDecimal importeSinIVA;

	@NotNull
	private BigDecimal importeConIVA;
	
	private String vendedor;
	
	private String fechaVentaInicial;
	
	private String cajero;
	
	private String operacion;
	
}
