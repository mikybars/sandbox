package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PresenciasTotalTiendaRequestDTO implements Serializable {	
	
	@ApiModelProperty(value = "Id tienda", required = false)
	private List<Integer> tiendas;
	
	@ApiModelProperty(value = "Fecha inico Rango", required = false)
	private Date fechaDesde;
	
	@ApiModelProperty(value = "Fecha fin rango", required = false)
	private Date fechaHasta;
	
	@ApiModelProperty(value = "Id tipo hora", required = false)
	private Integer tipo;
	
	@ApiModelProperty(value = "Id cadena", required = true)
	@NotNull
	private Integer cadena;
	
	@ApiModelProperty(value = "Id origen", required = false)
	private Integer origen;

}