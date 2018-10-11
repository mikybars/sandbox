package com.inditex.rrhh.icmclcwb.api.ptr.venta.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GetVentaTotalizadoRequestDTO implements Serializable {

	private static final long serialVersionUID = -529195772706345954L;

	@NotNull
	private String fechaDesde;
	
	@NotNull
	private String fechaHasta;

	@NotNull
	private String pais;

	@NotNull
	private String cadena;

	private List<String> tienda;

//	private String seccion;
//
//	private String temporada;
//
//	private String producto;
//	
//	private String agrupacion;

}