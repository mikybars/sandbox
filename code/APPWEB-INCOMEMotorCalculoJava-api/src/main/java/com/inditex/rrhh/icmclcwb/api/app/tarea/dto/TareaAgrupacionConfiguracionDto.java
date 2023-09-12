package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaAgrupacionConfiguracionDto implements Serializable {

  private static final long serialVersionUID = -8470928612425957019L;

  @ApiModelProperty(value = "Identificador", required = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @ApiModelProperty(value = "Id de la agrupacion", required = true)
  private Long icmIdAgrupacionOnline;

  @ApiModelProperty(value = "Fecha inicio", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaInicio;

  @ApiModelProperty(value = "Fecha fin", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaFin;

  @ApiModelProperty(value = "Id de la cadena", required = true)
  private String cclIdOrigen;

  @ApiModelProperty(value = "Porcentaje inclusion", required = true)
  private Double porcentajeInclusion;

  @ApiModelProperty(value = "Tipo venta concepto", required = true)
  private TipoVentaConceptoDto tipoVentaConcepto;

}
