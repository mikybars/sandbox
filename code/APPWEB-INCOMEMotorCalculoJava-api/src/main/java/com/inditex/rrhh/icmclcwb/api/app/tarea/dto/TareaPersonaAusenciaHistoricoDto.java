package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaPersonaAusenciaHistoricoDto implements Serializable {

  private static final long serialVersionUID = 573166701833849298L;

  private Long id;

  @NonNull
  private Long idTarea;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String cclIdOrigen;

  @NonNull
  private Date fechaInicio;

  @NonNull
  private Date fechaFin;

  private Integer idTipoAusencia;

  @NonNull
  private LocalDate fechaInicioPeriodo;

}
