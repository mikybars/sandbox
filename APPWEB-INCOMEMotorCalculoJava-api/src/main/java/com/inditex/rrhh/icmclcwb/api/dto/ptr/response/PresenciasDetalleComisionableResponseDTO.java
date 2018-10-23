package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.util.Date;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO.PresenciasDetalleComisionableRequestDTOBuilder;

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
public class PresenciasDetalleComisionableResponseDTO {
	private static final long serialVersionUID = 1L;
	private Integer tienda;
	private Integer seccion;
	private Integer persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	private Integer cadena;
	private Boolean	modificadoIncome;
}
