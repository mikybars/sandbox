package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
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
	@NotEmpty
	private List<String> cadena = new ArrayList<>();

	private List<Integer> tienda = new ArrayList<>();
	
	private String seccion;
	
	private String temporada;
	
	private String producto;
	
	private List<Integer> vendedores = new ArrayList<>();
	
	private String agrupacion;

}
