package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TareaConfiguracionChallengeDiasMinimosDto implements Serializable {

  private static final long serialVersionUID = -4403021667905217229L;

  private Long id;

  private Long idTarea;

  private String icmIdTpCalculo;

  private Integer icmMinNumDays;

  private Date fechaInicio;

  private Date fechaFin;

  private String cclIdOrigen;

}
