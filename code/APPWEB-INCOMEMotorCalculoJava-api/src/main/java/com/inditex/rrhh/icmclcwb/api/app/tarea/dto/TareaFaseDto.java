package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo TareaFaseDto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseDto implements Serializable {

  @ApiModelProperty(value = "Identificador de tarea fase dto", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador de tarea", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idTarea;

  @ApiModelProperty(value = "Identificador de fase", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idFase;

  @ApiModelProperty(value = "Identificador de estado tarea fase", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private EstadoTareaFaseDto estadoTareaFase;

  @ApiModelProperty(value = "Fecha en la que se creo el tarea fase", required = false,
      accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDateTime fechaHoraCreacion;

  @ApiModelProperty(value = "Fecha en la que se empieza a procesar la fase", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraInicio;

  @ApiModelProperty(value = "Fecha en la que se termina de procesar la fase", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraFin;

  @NotNull
  @ApiModelProperty(value = "Flag activo", required = true)
  private Boolean activo;

}
