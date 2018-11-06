package com.inditex.rrhh.icmclcwb.api.app.dto.poc;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PocEjecucionDto implements Serializable {

	private static final long serialVersionUID = -1304185252983882000L;

	private /* BigInteger */ Long id;

	private LocalDateTime fechaCreacion;

	@NotBlank
	private String sistema;

	private /* BigInteger */ Long idSistemaEjecucion;

	@NotBlank
	private String periodo;
	
	@NotBlank
	private String idPais;

	@NotBlank
	private String idCadena;

	private List<String> tiendas;

}