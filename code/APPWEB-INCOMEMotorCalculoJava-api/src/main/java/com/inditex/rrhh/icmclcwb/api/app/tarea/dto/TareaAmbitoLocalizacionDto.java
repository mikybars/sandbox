package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaAmbitoLocalizacionDto implements Serializable {

  private static final long serialVersionUID = 872769150714543322L;

  private Long id;

  private Long idTarea;

  private String cclIdOrigen;

  private String stdIdWorkLocat;

}
