package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaEstructuraDesplazamientoDto implements Serializable {

  private static final long serialVersionUID = -7730621144181571265L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

  @NotBlank
  private String idMotivoDesplazamiento;

  @NotNull
  private Integer idTipoOpcionCalculoEstructura;

  @NotNull
  private Integer idTipoOpcionCalculoEfectiva;

  @NotBlank
  private String cclIdPuestoDestino;

  @NotBlank
  private String cclIdSeccionDestino;

  @NotBlank
  private String cclIdCodOrigenDestino;

  @NotBlank
  private String stdIdWorkLocatDestino;

  @NotBlank
  private String icmIdTpReqCom;

  @NotNull
  private Boolean horasOrigen;

  @NotNull
  private Boolean horasDestino;

  @NotNull
  private Boolean activo;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String icmIdEstrComisionBase;

  @NotBlank
  private String icmIdEstrComision;

  @NotBlank
  private String icmIdEstrComisionPadre;

  @NotNull
  private Integer ordinalEstructura;

  @NotBlank
  private String icmIdEstructuraAmbito;

  @NotNull
  private LocalDate fechaInicioPeriodo;

  @NotNull
  private Boolean totalCondiciones;

}
