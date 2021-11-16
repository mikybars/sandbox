package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class DesplazamientoRealFilterDto implements Serializable {

  private List<DesplazamientoRealFilterParametersDto> item;

}
