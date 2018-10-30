package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class PresenciasTotalTiendaSeccionRequestDTO {

		private List<TiendaSeccionDTO> tiendaSeccion;
		private Date fechaDesde;
		private Date fechaHasta;
		private Integer tipo;
		@NotNull
		private Integer cadena;
		private Integer origen;
}
		
	