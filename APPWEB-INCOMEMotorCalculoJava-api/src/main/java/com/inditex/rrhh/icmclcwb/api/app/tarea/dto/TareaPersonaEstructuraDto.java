package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaEstructuraDto implements Serializable {

  private static final long serialVersionUID = -543194407813312935L;

  @ApiModelProperty(value = "Identificador de la persona estructura", required = false)
  private String id;

  @ApiModelProperty(value = "Oridnal de la estructura")
  private Integer ordinalEstructura;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

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
  private String icmIdEstrComision;

  @NotBlank
  @ApiModelProperty(value = "Id tipo calculo asociado a la estructura", required = true)
  private String icmIdTpCalculo;

  @NotBlank
  @ApiModelProperty(value = "Id tipo comisión asociado a la estructura ", required = true)
  private String icmIdTpComision;

  @NotBlank
  @ApiModelProperty(value = "valor asociado a la seccion", required = true)
  private String valor;

  @NotBlank
  @ApiModelProperty(value = "Seccion usada en el calculo", required = true)
  private String cclIdSeccionEfectiva;

  @NotBlank
  @ApiModelProperty(value = "Seccion usada en la estructura", required = true)
  private String cclIdSeccionEstructura;

  @NotNull
  @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
  private Date fechaInicio;

  @NotNull
  @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
  private Date fechaFin;

  @NotNull
  @ApiModelProperty(value = "Flag que indica si hay desplazamientos para el empleado", required = true)
  private Boolean desplazamiento;

  @NotNull
  @ApiModelProperty(value = "Flag que indica si es una estructura de desplazamiento, pero es la base",
      required = true)
  private Boolean desplazamientoBase;

  @ApiModelProperty(value = "Estructura de desplazamiento", required = false)
  private TareaPersonaEstructuraDesplazamientoDto estructuraDesplazamiento;

  @NotNull
  @ApiModelProperty(value = "Flag activo/inactivo", required = true)
  private Boolean activo;

  @ApiModelProperty(value = "Flag dia / lunes", required = false)
  private Boolean diaL;

  @ApiModelProperty(value = "Flag dia / martes", required = false)
  private Boolean diaM;

  @ApiModelProperty(value = "Flag dia / miercoles", required = false)
  private Boolean diaX;

  @ApiModelProperty(value = "Flag dia / jueves", required = false)
  private Boolean diaJ;

  @ApiModelProperty(value = "Flag dia / viernes", required = false)
  private Boolean diaV;

  @ApiModelProperty(value = "Flag dia / sabado", required = false)
  private Boolean diaS;

  @ApiModelProperty(value = "Flag dia / domingo", required = false)
  private Boolean diaD;

  @NotBlank
  @ApiModelProperty(value = "Id estructura asociada al empleado por APV", required = true)
  private String icmIdEstrComisionBase;

  @NotBlank
  @ApiModelProperty(value = "Id estructura padre", required = true)
  private String icmIdEstrComisionPadre;

  @NotNull
  @ApiModelProperty(value = "Tope", required = true)
  private Integer tope;

  @NotBlank
  @ApiModelProperty(value = "Id tipo estructura ", required = true)
  private String icmIdTpEstructura;

  @NotNull
  @ApiModelProperty(value = "Fecha inicio periodo", required = true)
  private LocalDate fechaInicioPeriodo;

  @ApiModelProperty(value = "Check festivos", required = false)
  private Boolean festivo;

  @ApiModelProperty(value = "Grupo manual", required = false)
  private String grupoManual;

}
