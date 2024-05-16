package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaAmbitoPersonaDto implements Serializable {

  private static final long serialVersionUID = -5751239783803104019L;

  private Long id;

  private Long idTarea;

  @NotBlank
  private String cclIdOrigen;

  private String cclIdPerson;

  private String stdOrHrPeriod;

}
