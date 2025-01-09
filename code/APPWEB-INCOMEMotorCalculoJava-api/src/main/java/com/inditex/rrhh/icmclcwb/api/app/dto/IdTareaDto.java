package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdTareaDto implements Serializable {

  private static final long serialVersionUID = -2999803240189313755L;

  @NonNull
  private Long id;

}
