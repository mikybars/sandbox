package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PresenciasTotalTiendaRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> tiendas;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	private Integer cadena;
	private Integer origen;

}