package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto;

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
public class PtrPresenciasDetalleRequestDto implements Serializable {

	private static final long serialVersionUID = 2089515262512038387L;

	@ApiModelProperty(value = "Id tienda", required = false, example = "160")
	private Integer tienda;

	@ApiModelProperty(value = "Id seccion", required = false, example = "1")
	private Integer seccion;

	@ApiModelProperty(value = "Id empleados", required = false, allowableValues = "1645")
	private List<Integer> personas;

	@ApiModelProperty(value = "Fecha inicio rango", required = false, example = "2017-01-01")
	private Date fechaDesde;

	@ApiModelProperty(value = "Fecha final rango", required = false, example = "2017-12-31")
	private Date fechaHasta;

	@ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
	private Integer tipo;

	@ApiModelProperty(value = "Id cadena", required = true, allowableValues = "1")
	@NotNull
	private List<Integer> cadena;
	
	@NotNull
	@ApiModelProperty(value = "Id Origen", required = false, example = "11")
	private Integer origen;
}
