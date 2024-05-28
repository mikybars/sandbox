package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaAusenciaHistoricoDto implements Serializable {

  private static final long serialVersionUID = 573166701833849298L;

  private Long id;

  @NotNull
  private Long idTarea;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String cclIdOrigen;

  @NotNull
  private Date fechaInicio;

  @NotNull
  private Date fechaFin;

  private Integer idTipoAusencia;

  @NotNull
  private LocalDate fechaInicioPeriodo;

}
