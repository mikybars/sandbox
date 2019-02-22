package com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class RunProcesoRecolectarDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

	private RunProcesoRecolectarBloqueDto uno = new RunProcesoRecolectarBloqueDto();
	
	private RunProcesoRecolectarBloqueDto dos = new RunProcesoRecolectarBloqueDto();

}

