package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IdProgramacionDto implements Serializable {

  private static final long serialVersionUID = -7670148375169828983L;

  @NotNull
  private Long id;

}
