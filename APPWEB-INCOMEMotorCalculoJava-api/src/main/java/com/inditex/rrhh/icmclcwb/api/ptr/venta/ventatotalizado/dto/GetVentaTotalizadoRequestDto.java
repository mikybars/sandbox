package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GetVentaTotalizadoRequestDto implements Serializable {

	private static final long serialVersionUID = -529195772706345954L;

	@NotNull
	private String fechaDesde;
	
	@NotNull
	private String fechaHasta;

	@NotNull
	private String pais;

	//TODO: XSD En el XSD viene como simple pero en el Postman funciona con múltiple
	@NotNull
	private List<String> cadena;

	private List<String> tienda;
	
	private String agrupacion;

//	private String seccion;
//
//	private String temporada;
//
//	private String producto;
//	
//	private String agrupacion;

}