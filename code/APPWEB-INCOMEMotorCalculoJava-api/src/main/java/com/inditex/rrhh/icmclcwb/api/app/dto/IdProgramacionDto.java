package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
public class IdProgramacionDto implements Serializable {

  private static final long serialVersionUID = -7670148375169828983L;

  @NonNull
  private Long id;

}
