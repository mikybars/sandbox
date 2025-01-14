package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaPersonaEstructuraPoliticaDto implements Serializable {

  private static final long serialVersionUID = -4806531575285048264L;

  private Long id;

  @NonNull
  private Long idTarea;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String idEstructuraPolitica;

  @NotBlank
  private String idTipoPolitica;

  @NonNull
  private Date fechaInicio;

  @NonNull
  private Date fechaFin;

  @NonNull
  private Boolean excluidoDenominador;

  @NotBlank
  private String idTipoUnidadTiempo;

  @NotBlank
  private String numeroUnidades;

  @NotBlank
  private String valor;

  @NonNull
  private Integer tramo;

  private String numMesesCalcMedia;

  private String numHoras;

  private String idMotivoBaja;

  private String importe;

}
