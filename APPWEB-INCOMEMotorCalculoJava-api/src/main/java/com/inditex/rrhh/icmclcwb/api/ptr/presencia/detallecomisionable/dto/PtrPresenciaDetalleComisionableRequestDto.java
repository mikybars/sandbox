package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto;

import java.io.Serializable;
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
public class PtrPresenciaDetalleComisionableRequestDto implements Serializable {

	private static final long serialVersionUID = 484679933963140419L;

	@ApiModelProperty(value = "Id tienda", required = false, example = "160")
	private Integer tienda;

	@ApiModelProperty(value = "Id seccion", required = false, example = "1")
	private Integer seccion;

	@ApiModelProperty(value = "Id empleado", required = false, allowableValues = "1645")
	private List<Integer> persona;

	@ApiModelProperty(value = "Fecha inicio rango de busqueda", required = false, example = "2017-01-01")
	private String fechaDesde;

	@ApiModelProperty(value = "Fecha fin rango de busqueda", required = false, example = "2017-12-31")
	private String fechaHasta;

	@ApiModelProperty(value = "Id cadena", required = true, example = "1")
	private Integer cadena;

	@ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
	private Integer tipo;

	@NotNull
	@ApiModelProperty(value = "Id Origen", required = false, example = "11")
	private Integer origen;

}