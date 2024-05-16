package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdTareaDto implements Serializable {

  private static final long serialVersionUID = -2999803240189313755L;

  @NotNull
  private Long id;

}
