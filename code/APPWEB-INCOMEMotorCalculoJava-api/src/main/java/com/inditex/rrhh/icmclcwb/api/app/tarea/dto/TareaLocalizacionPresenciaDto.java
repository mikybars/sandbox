package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPresenciaDto {

  @ApiModelProperty(value = "Identificador de la entidad", required = false,
      accessMode = ApiModelProperty.AccessMode.READ_ONLY)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Tarea", required = true)
  private Long idTarea;

  @ApiModelProperty(value = "Fecha en la que se consultó la venta", required = true,
      accessMode = ApiModelProperty.AccessMode.READ_ONLY)
  private LocalDate fecha;

  @NotBlank
  @ApiModelProperty(value = "Id de la localizacion", required = true)
  private String cclIdCodOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la seccion", required = true)
  private String cclIdSeccion;

  @NotBlank
  @ApiModelProperty(value = "Id de la cadena", required = true)
  private String cclIdCadena;

  @NotNull
  @ApiModelProperty(value = "Tiempo seccion", required = false, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
  private Long minutos;

}
