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
public class IdPersonaLocalComisionManualDto implements Serializable {

  private static final long serialVersionUID = -2502605283470902910L;

  @NotBlank
  private String idPersonaLocal;

  private String importe;

  private String grupoManual;

  private String tipoComision;
}
