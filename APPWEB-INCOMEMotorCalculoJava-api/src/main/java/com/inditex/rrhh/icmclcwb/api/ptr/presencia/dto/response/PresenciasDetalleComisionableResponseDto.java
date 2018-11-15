package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response;

import java.util.Date;
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
public class PresenciasDetalleComisionableResponseDto {

	private Integer tienda;

	private Integer seccion;

	private Integer persona;

	private Date fecha;

	private Integer minutos;

	private Integer tipo;

	private Integer cadena;

	private Boolean modificado_income;


}