package com.inditex.rrhh.icmclcwb.api.app.run.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class RunTrabajoRecolectarDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

	private RunTrabajoRecolectarBloqueDto uno = new RunTrabajoRecolectarBloqueDto();
	
	private RunTrabajoRecolectarBloqueDto dos = new RunTrabajoRecolectarBloqueDto();

}

