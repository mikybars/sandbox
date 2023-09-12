package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoLimpiezaDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotNull;
import lombok.Data;

@ApiModel(description = "Modelo TareaLimpiezaDto")
@Data
public class TareaLimpiezaDto implements Serializable {

  private static final long serialVersionUID = -170294147407207684L;

  @NotNull
  @ApiModelProperty(value = "Identificador de la limpieza", required = true)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Estado de la limpieza", required = true)
  private EstadoLimpiezaDto estado;

  @NotNull
  @ApiModelProperty(value = "Tipo de limpieza", required = true)
  private TipoLimpiezaDto tipo;

  @ApiModelProperty(value = "Fecha en la que se creó la tarea de limpieza", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraCreacion;

  @ApiModelProperty(value = "Fecha en la que se inició la limpieza", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraInicio;

  @ApiModelProperty(value = "Fecha en la que se finalizó la limpieza", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraFin;

  @ApiModelProperty(value = "Nombre del usuario que solicito la limpieza", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true, example = "IAGOML")
  private String nombreUsuario;

}
