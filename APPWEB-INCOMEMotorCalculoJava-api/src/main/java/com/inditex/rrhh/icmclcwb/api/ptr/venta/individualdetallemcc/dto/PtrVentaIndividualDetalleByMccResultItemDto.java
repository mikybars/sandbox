package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.MccType;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleByMccResultItemDto implements Serializable {
	
    private static final long serialVersionUID = -3557469878677993042L;

    @NotBlank
	private String fecha;

	private Integer pais;

	private Integer cadena;

	@NotBlank
	private Integer tienda;

	private Integer seccion;

	private Integer temporada;

	private Integer producto;
	
	private MccType mcc;

	@NotNull
	private BigDecimal importeSinIVA;

	@NotNull
	private BigDecimal importeConIVA;
	
	private Integer vendedor;
	
	private String fechaVentaInicial;
	
	private Integer cajero;
	
	private String operacion;
	
}
