package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.util.Date;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PresenciasTotalTiendaResponseDTO {
	//TODO Pendiente de definir campos
	private Integer Tienda;
	private Date Fecha;
	private Integer Minutos;
}
