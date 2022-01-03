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
public class IdPersonaLocalDto implements Serializable {

  private static final long serialVersionUID = -2999803240189313755L;

  @NotBlank
  private String idPersonaLocal;

  @NotBlank
  private String stdOrHrPeriod;

}
