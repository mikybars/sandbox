package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleRequestDto implements Serializable {

	private static final long serialVersionUID = -3408775260498412294L;
	
	@NotNull
	private String fechaDesde;
	
	@NotNull
	private String fechaHasta;

	@NotNull
	private Integer pais;

	private Integer cadena;
	
	private Integer empresa;

	private List<Integer> tienda = new ArrayList<>();
	
	private Integer seccion;
	
	private Integer temporada;
	
	private Integer producto;
	
	private List<Integer> vendedores = new ArrayList<>();
	
	private String fechaVentaInicial;
	
	private Integer cajero;
	
	private String operacion;
	
	private PtrGroupSellerTypeEnum agrupacion;
	
	private Integer agruparSeccion;

}
