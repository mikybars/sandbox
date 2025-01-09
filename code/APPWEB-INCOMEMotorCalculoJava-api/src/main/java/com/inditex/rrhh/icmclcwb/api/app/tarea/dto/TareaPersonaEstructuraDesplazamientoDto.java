package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaPersonaEstructuraDesplazamientoDto implements Serializable {

  private static final long serialVersionUID = -7730621144181571265L;

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private LocalDateTime fechaInicio;

  @NonNull
  private LocalDateTime fechaFin;

  @NotBlank
  private String idMotivoDesplazamiento;

  @NonNull
  private Integer idTipoOpcionCalculoEstructura;

  @NonNull
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

  @NonNull
  private Boolean horasOrigen;

  @NonNull
  private Boolean horasDestino;

  @NonNull
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

  @NonNull
  private Integer ordinalEstructura;

  @NotBlank
  private String icmIdEstructuraAmbito;

  @NonNull
  private LocalDate fechaInicioPeriodo;

  @NonNull
  private Boolean totalCondiciones;

}
