package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErorresGuardadoResultItemDto implements Serializable {

  private String resultado;

  private List<ErroresGuardadoResultItemParametersDto> errores;

}
