package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunDatosDto")
@Data
public class TrabajoRunDatosDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

	private TrabajoRunDatosBloqueDto uno = new TrabajoRunDatosBloqueDto();
	
	private TrabajoRunDatosBloqueDto dos = new TrabajoRunDatosBloqueDto();

}

