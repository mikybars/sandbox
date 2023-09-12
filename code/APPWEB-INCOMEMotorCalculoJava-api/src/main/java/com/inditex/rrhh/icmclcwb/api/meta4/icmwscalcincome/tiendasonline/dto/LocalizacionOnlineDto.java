package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo LocalizacionOnlineDto")
@Data
public class LocalizacionOnlineDto implements Serializable {

  private static final long serialVersionUID = 1296063505005890364L;

  @ApiModelProperty(value = "Identificador de tienda online", required = false)
  private Long id;

}
