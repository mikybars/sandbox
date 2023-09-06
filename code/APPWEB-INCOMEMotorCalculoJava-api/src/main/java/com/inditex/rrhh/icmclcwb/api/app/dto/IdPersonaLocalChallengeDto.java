package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdPersonaLocalChallengeDto implements Serializable {

  private static final long serialVersionUID = -716693133637918351L;

  private String cclIdPerson;

  private String stdOrHrPeriod;

  private String icmIdTpCalculo;

  private String icmIdTpComision;

  private Boolean esDesplazamiento;

  private Boolean esDesplazamientoBase;

}
