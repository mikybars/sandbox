package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo EstadoTrabajoDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoTrabajoDto implements Serializable {

  private static final long serialVersionUID = -7864441917446430800L;

  @ApiModelProperty(value = "Identificador del estado del trabajo", required = true)
  private Integer id;

}
