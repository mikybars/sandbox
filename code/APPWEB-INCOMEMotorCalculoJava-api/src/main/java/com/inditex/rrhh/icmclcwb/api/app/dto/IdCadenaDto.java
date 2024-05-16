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
public class IdCadenaDto implements Serializable {

  private static final long serialVersionUID = -1227104329383244750L;

  @NotBlank
  private String id;

}
