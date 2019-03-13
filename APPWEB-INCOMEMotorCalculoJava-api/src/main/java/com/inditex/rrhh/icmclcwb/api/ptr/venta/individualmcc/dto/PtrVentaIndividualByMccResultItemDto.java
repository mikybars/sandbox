package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.MccType;

import lombok.Data;

@Data
public class PtrVentaIndividualByMccResultItemDto implements Serializable {
	
    private static final long serialVersionUID = 3679255063774407004L;

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
    
    private Integer empresa;

    private Integer vendedor;

	@NotNull
	private BigDecimal importeSinIVA;

	@NotNull
	private BigDecimal importeConIVA;
	
}
