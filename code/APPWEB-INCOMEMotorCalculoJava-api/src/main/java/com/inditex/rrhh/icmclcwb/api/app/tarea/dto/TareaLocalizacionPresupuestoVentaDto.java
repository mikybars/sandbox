package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPresupuestoVentaDto implements Serializable {

  private static final long serialVersionUID = -9168287171777824121L;

  @ApiModelProperty(value = "Identificador de la entidad", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Identificador de la localizacion", required = true)
  private Long cclIdCodOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la seccion", required = true)
  private String cclIdSeccion;

  @NotBlank
  @ApiModelProperty(value = "Id de la cadena", required = true)
  private String cclIdCadena;

  @NotNull
  private Integer ordinal;

  @NotNull
  @ApiModelProperty(value = "Importe sin impuestos", required = true)
  private Double importeSinImpuestos;

  @NotNull
  @ApiModelProperty(value = "Importe con impuestos", required = true)
  private Double importeConImpuestos;

  @ApiModelProperty(value = "Tipo presupuesto", required = true)
  private Integer idTipoPresupuesto;

  @ApiModelProperty(value = "Id de concepto venta", required = true)
  private String icmIdConceptoVenta;

  @NotBlank
  @ApiModelProperty(value = "Id de origen", required = true)
  private String cclIdOrigen;

  @NotNull
  @ApiModelProperty(value = "Flag activo", required = true)
  private Boolean activo;

  @NotNull
  @ApiModelProperty(value = "Id de tipo de dato", required = true)
  private Integer idTipoDato;

}
