package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaseRequestDto implements Serializable {

  private static final long serialVersionUID = 2454820792779045948L;

  private String cclIdOrigen;

}
