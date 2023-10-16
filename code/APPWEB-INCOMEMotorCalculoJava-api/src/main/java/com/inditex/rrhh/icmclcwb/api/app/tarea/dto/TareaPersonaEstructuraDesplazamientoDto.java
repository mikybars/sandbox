package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaEstructuraDesplazamientoDto implements Serializable {

  private static final long serialVersionUID = -7730621144181571265L;

  @ApiModelProperty(value = "Identificador de la persona estructura desplazamiento", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
  private LocalDateTime fechaInicio;

  @NotNull
  @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
  private LocalDateTime fechaFin;

  @NotBlank
  @ApiModelProperty(value = "Motivo del desplazamiento", required = true)
  private String idMotivoDesplazamiento;

  @NotNull
  @ApiModelProperty(value = "Tipo de opción de cálculo de la estructura", required = true)
  private Integer idTipoOpcionCalculoEstructura;

  @NotNull
  @ApiModelProperty(value = "Tipo de opción de cálculo usada en el propio cálculo", required = true)
  private Integer idTipoOpcionCalculoEfectiva;

  @NotBlank
  @ApiModelProperty(value = "Puesto del destino del desplazamiento", required = true)
  private String cclIdPuestoDestino;

  @NotBlank
  @ApiModelProperty(value = "Sección del destino del desplazamiento", required = true)
  private String cclIdSeccionDestino;

  @NotBlank
  @ApiModelProperty(value = "Lugar de trabajo del desitno del desplazamiento", required = true)
  private String cclIdCodOrigenDestino;

  @NotBlank
  @ApiModelProperty(value = "Lugar de trabajo del desitno del desplazamiento", required = true)
  private String stdIdWorkLocatDestino;

  @NotBlank
  @ApiModelProperty(value = "Condiciones de la comision", required = true)
  private String icmIdTpReqCom;

  @NotNull
  @ApiModelProperty(value = "Incluir horas en origen", required = true)
  private Boolean horasOrigen;

  @NotNull
  @ApiModelProperty(value = "Incluir horas en destino", required = true)
  private Boolean horasDestino;

  @NotNull
  @ApiModelProperty(value = "Flag activo/inactivo", required = true)
  private Boolean activo;

  @NotBlank
  @ApiModelProperty(value = "Id origen", required = true)
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la persona", required = true)
  private String stdIdHr;

  @NotBlank
  @ApiModelProperty(value = "Ordinal de la persona", required = true)
  private String stdOrHrPeriod;

  @NotBlank
  @ApiModelProperty(value = "Id local de la persona", required = true)
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Id estructura asociada al empleado por APV", required = true)
  private String icmIdEstrComisionBase;

  @NotBlank
  @ApiModelProperty(value = "Id estructura destino", required = true)
  private String icmIdEstrComision;

  @NotBlank
  @ApiModelProperty(value = "Id estructura padre", required = true)
  private String icmIdEstrComisionPadre;

  @NotNull
  @ApiModelProperty(value = "Oridnal de la estructura")
  private Integer ordinalEstructura;

  @NotBlank
  @ApiModelProperty(value = "Id estructura del ambito", required = true)
  private String icmIdEstructuraAmbito;

  @NotNull
  @ApiModelProperty(value = "Fecha inicio periodo", required = true)
  private LocalDate fechaInicioPeriodo;

  @NotNull
  @ApiModelProperty(value = "Flag incluir total condiciones", required = true)
  private Boolean totalCondiciones;

}
