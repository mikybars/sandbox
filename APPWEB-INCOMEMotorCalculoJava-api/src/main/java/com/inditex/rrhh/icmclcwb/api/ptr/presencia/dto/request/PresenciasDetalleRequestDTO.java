package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PresenciasDetalleRequestDTO implements Serializable{
	@ApiModelProperty(value = "Id tienda", required = false)
	private Integer tienda;
	
	@ApiModelProperty(value = "Id seccion", required = false)
	private Integer seccion;
	 
	@ApiModelProperty(value = "Id empleados", required = false)
	private List<Integer> personas;
	
	@ApiModelProperty(value = "Fecha inicio rango", required = false)
	private Date fechaDesde;
	
	@ApiModelProperty(value = "Fecha final rango", required = false)
	private Date fechaHasta;
	
	@ApiModelProperty(value = "Id tipo hora", required = false)
	private Integer tipo;
	
	@ApiModelProperty(value = "Id cadena", required = true)
	@NotNull
	private Integer cadena;
	
	@ApiModelProperty(value = "Id Origen", required = false)
	private Integer origen;
}
