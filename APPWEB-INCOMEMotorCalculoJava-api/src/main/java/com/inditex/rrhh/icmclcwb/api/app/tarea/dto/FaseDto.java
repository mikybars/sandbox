package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo FaseDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaseDto implements Serializable {

  @ApiModelProperty(value = "Identificador de fase", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer id;

}
