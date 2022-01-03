package com.inditex.rrhh.icmclcwb.api.app.periodo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class PeriodoLocalizacionPersonaDto {

  @ApiModelProperty(value = "Identificador del periodo", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long icmIdPeriodo;

  @ApiModelProperty(value = "Identificador del origen", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long cclIdOrigen;

  @ApiModelProperty(value = "Identificador de la empresa", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long stdIdLegEnt;

  @ApiModelProperty(value = "Identificador de la localizacion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long stdIdWorkLocat;

  @ApiModelProperty(value = "Identificador de la persona", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long cclIdPerson;

}
