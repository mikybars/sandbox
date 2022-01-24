package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo EstadoTareaPersonaDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoTareaPersonaDto implements Serializable {

  private static final long serialVersionUID = 690542159104929423L;

  @ApiModelProperty(value = "Identificador del estado", required = true)
  private Integer id;

}
