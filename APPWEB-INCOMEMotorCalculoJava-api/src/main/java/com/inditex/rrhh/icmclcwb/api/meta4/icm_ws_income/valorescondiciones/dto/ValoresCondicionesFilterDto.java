package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class ValoresCondicionesFilterDto implements Serializable {

	private static final long serialVersionUID = -2620395625831508326L;
	
	private String idEstructura;
    private String tipoCondicion;
    private String tiposPlantillas;
    private String subtipoCondicion;

}