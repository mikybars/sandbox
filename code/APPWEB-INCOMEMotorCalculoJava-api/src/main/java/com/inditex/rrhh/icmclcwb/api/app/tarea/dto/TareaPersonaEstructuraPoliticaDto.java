package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaEstructuraPoliticaDto implements Serializable {

  private static final long serialVersionUID = -4806531575285048264L;

  @ApiModelProperty(value = "Identificador de la persona estructura politica", required = false)
  private Long id;

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
  @ApiModelProperty(value = "Id estructura asociada a la politica", required = true)
  private String idEstructuraPolitica;

  @NotBlank
  @ApiModelProperty(value = "Id tipo politica", required = true)
  private String idTipoPolitica;

  @NotNull
  @ApiModelProperty(value = "Fecha de inicio en la politica", required = true)
  private Date fechaInicio;

  @NotNull
  @ApiModelProperty(value = "Fecha de fin en la politica", required = true)
  private Date fechaFin;

  @NotNull
  @ApiModelProperty(value = "Excluido deonminador", required = true)
  private Boolean excluidoDenominador;

  @NotBlank
  @ApiModelProperty(value = "Id unidad tiempo", required = true)
  private String idTipoUnidadTiempo;

  @NotBlank
  @ApiModelProperty(value = "Numero de unidades de tiempo", required = true)
  private String numeroUnidades;

  @NotBlank
  @ApiModelProperty(value = "Valor", required = true)
  private String valor;

  @NotNull
  @ApiModelProperty(value = "Tramo", required = true)
  private Integer tramo;

  @ApiModelProperty(value = "Numero meses que servirá para calcular la media de la comisión", required = false)
  private String numMesesCalcMedia;

  @ApiModelProperty(value = "Numero de horas fijas", required = false)
  private String numHoras;

  @ApiModelProperty(value = "Id motivo baja", required = false)
  private String idMotivoBaja;

  @ApiModelProperty(value = "Importe (minimo o maximo)", required = false)
  private String importe;

}
