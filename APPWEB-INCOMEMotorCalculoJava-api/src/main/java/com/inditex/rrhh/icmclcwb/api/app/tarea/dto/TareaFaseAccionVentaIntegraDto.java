package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo TareaFaseAccionVentaIntegraDto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseAccionVentaIntegraDto {

  @ApiModelProperty(value = "Identificador de TareaFaseAccion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idTareaFaseAccion;

  @ApiModelProperty(value = "Identificador de TipoDato", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idTipoDato;

  @ApiModelProperty(value = "ID Tienda", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private String tienda;

  @ApiModelProperty(value = "Fecha desintegridad", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDate fechaDesintegridad;

}
