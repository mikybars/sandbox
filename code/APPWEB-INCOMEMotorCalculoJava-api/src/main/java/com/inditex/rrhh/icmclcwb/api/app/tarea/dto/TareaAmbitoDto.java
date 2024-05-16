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
public class TareaAmbitoDto implements Serializable {

  private static final long serialVersionUID = -5009774080452288030L;

  private Long id;

  private Long idTarea;

  private String cclIdOrigen;

}
