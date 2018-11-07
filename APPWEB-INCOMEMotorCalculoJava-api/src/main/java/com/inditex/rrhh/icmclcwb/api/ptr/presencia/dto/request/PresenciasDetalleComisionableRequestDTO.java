package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class PresenciasDetalleComisionableRequestDTO  implements Serializable {
	@ApiModelProperty(value = "Id tienda", required = false,example = "160")
	private Integer tienda;
	@ApiModelProperty(value = "Id seccion", required = false ,example = "1")
	private Integer seccion;
	@ApiModelProperty(value = "Id empleado", required = false, allowableValues = "1645")
	private Integer persona;
	@ApiModelProperty(value = "Fecha inicio rango de busqueda", required = false,example = "2017-01-01")
	private Date fechaDesde;
	@ApiModelProperty(value = "Fecha fin rango de busqueda", required = false,example = "2017-12-31")
	private Date fechaHasta;
	@ApiModelProperty(value = "Id tipo", required = false,example = "1")
	private Integer tipo;
	@ApiModelProperty(value = "Id cadena", required = true,example = "1")
	private Integer cadena;	
}
