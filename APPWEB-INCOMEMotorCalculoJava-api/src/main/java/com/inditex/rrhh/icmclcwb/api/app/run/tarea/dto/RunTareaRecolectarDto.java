package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class RunTareaRecolectarDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

	private RunTareaRecolectarBloqueDto uno = new RunTareaRecolectarBloqueDto();
	
	private RunTareaRecolectarBloqueDto dos = new RunTareaRecolectarBloqueDto();

}

