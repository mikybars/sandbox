package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdEmpresaDto implements Serializable {

  @NotBlank
  private String stdIdLegEnt;

}
