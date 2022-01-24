package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo EstadoTareaFaseDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoTareaFaseDto implements Serializable {

  private static final long serialVersionUID = -445087475658451015L;

  @ApiModelProperty(value = "Identificador de estado tarea fase", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer id;

}
