package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaPersonaCoeficienteDto implements Serializable {

  private static final long serialVersionUID = 2150494287535837812L;

  private String id;

  @NonNull
  private Long idTarea;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  private Date fechaInicioPar;

  private Date fechaFinPar;

  private Date fechaInicioCom;

  private Date fechaFinCom;

  @NonNull
  private BigDecimal coeficiente;

}
