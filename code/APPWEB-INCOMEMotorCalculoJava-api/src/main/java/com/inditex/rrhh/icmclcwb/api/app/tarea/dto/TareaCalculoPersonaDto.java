package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaCalculoPersonaDto implements Serializable {

  private static final long serialVersionUID = -3291036377867267819L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdOrigen;

  @NotNull
  private EstadoTareaPersonaDto estado;

}
