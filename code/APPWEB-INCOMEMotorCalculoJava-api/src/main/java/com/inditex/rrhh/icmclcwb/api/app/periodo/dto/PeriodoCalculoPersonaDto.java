package com.inditex.rrhh.icmclcwb.api.app.periodo.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class PeriodoCalculoPersonaDto {

  @ApiModelProperty(value = "Identificador del periodo", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long icmIdPeriodo;

  @ApiModelProperty(value = "Identificador del origen", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long cclIdOrigen;

  @ApiModelProperty(value = "Identificador de la empresa", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long stdIdLegEnt;

  @ApiModelProperty(value = "Identificador de la persona", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long cclIdPerson;

  @ApiModelProperty(value = "Ordinal de la persona", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long stdOrHrPeriod;

  @ApiModelProperty(value = "Tarea actual", required = true)
  private Long idTareaActual;

  @ApiModelProperty(value = "Tarea ultima", required = true)
  private Long idTareaUltima;

  @ApiModelProperty(value = "Identificador del estado", required = true)
  private Long idEstado;

  @ApiModelProperty(value = "Fecha en la que se crea la tarea", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDateTime fechaHoraCreacion;

  @ApiModelProperty(value = "Fecha de ultima actualización de la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraActualizacion;

}
