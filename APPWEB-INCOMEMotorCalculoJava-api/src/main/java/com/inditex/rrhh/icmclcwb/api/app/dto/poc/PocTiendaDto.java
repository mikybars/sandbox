package com.inditex.rrhh.icmclcwb.api.app.dto.poc;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PocTiendaDto implements Serializable {

	private static final long serialVersionUID = -625793975651873916L;

	private String id;

	@NotBlank
	private String idPais;

	@NotBlank
	private String idCadena;

}