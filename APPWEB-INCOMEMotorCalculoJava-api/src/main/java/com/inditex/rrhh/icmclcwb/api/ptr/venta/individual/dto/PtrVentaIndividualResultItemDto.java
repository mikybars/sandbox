package com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import lombok.Data;

@Data
public class PtrVentaIndividualResultItemDto implements Serializable {
	
	
	private static final long serialVersionUID = -801740758955645983L;

	@NotBlank
	private String fecha;

	private Integer pais;

	private Integer cadena;

	@NotBlank
	private Integer tienda;

	private Integer seccion;

	private Integer temporada;

	private Integer producto;
	
	private Integer empresa;

    private Integer vendedor;

	@NotNull
	private BigDecimal importeSinIVA;

	@NotNull
	private BigDecimal importeConIVA;
	
	private List<PtrSeccionVentaOnlineGenericType> listaSeccion;
	
}
