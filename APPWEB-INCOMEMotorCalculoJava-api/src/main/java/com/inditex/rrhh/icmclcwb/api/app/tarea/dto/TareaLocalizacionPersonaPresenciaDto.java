package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPersonaPresenciaDto implements Serializable {

  private static final long serialVersionUID = -5245069232542882963L;

  @ApiModelProperty(value = "Identificador de la tabla de presencia por seccion", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Identificador de la tienda", required = true)
  private Long cclIdCodOrigen;

  @NotNull
  @ApiModelProperty(value = "Identificador de la persona", required = true)
  private Long cclIdPerson;

  @NotNull
  @ApiModelProperty(value = "Identificador del origen", required = true)
  private Long cclIdOrigen;

  @NotNull
  @ApiModelProperty(value = "Identificador de la empresa", required = true)
  private Long stdIdLegEnt;

  @NotNull
  @ApiModelProperty(value = "Identificador de la seccion", required = true)
  private Long cclIdSeccion;

  @NotNull
  private Date fecha;

  @NotNull
  @ApiModelProperty(value = "Minutos", required = true)
  private Long minutos;

  @ApiModelProperty(value = "Identificador del tipo de hora", required = true)
  private Integer idTipoHora;

  @ApiModelProperty(value = "Flag activo", required = true)
  private Boolean activo;

}
