package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PresenciasTotalTiendaRequestDTO implements Serializable {	
	private List<Integer> tiendas;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	@NotNull
	private Integer cadena;
	private Integer origen;

}