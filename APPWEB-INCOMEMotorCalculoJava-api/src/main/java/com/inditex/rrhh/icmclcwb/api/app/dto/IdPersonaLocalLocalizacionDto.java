package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdPersonaLocalLocalizacionDto implements Serializable {

  private static final long serialVersionUID = 910271308863106061L;

  @NotBlank
  private String idPersonaLocal;

  @NotBlank
  private String cclIdCodOrigen;

}
