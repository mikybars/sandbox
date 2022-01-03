package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SistemaDestinoRequestDto implements Serializable {

  private static final long serialVersionUID = -696560080258051258L;

  private String cclIdOrigen;

}
