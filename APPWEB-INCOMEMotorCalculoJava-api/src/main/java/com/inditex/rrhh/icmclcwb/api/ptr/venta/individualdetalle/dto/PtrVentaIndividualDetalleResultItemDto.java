package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleResultItemDto implements Serializable {
	
	
	private static final long serialVersionUID = -801740758955645983L;

	@NotBlank
	private String fecha;

	private Integer pais;

	private Integer cadena;
	
    private Integer empresa;

	@NotBlank
	private Integer tienda;

	private Integer seccion;

	private Integer temporada;

	private Integer producto;

	@NotNull
	private BigDecimal importeSinIVA;

	@NotNull
	private BigDecimal importeConIVA;
	
	private Integer vendedor;
	
	private String fechaVentaInicial;
	
	private Integer cajero;
	
	private String operacion;
	
	private List<PtrSeccionVentaOnlineGenericType> listaSeccion;
	
}
