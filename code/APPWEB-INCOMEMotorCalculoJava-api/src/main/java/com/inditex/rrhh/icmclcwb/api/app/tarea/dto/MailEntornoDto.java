package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailEntornoDto implements Serializable {

  @NotBlank
  private String entorno;

  @NonNull
  private Boolean activo;
}
