package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleRequestDto implements Serializable {

	private static final long serialVersionUID = -3408775260498412294L;
	
	@NotNull
	private String fechaDesde;
	
	@NotNull
	private String fechaHasta;

	@NotNull
	private String pais;

	//TODO: XSD En el XSD viene como simple pero en el Postman funciona con múltiple
	@NotNull
	private List<String> cadena;

	private List<Integer> tienda;
	
	private String seccion;
	
	private String temporada;
	
	private String producto;
	
	private List<Integer> vendedores;
	
	private String agrupacion;

}
