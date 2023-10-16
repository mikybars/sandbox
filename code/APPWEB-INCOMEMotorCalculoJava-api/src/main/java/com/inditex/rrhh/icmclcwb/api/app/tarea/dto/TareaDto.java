package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@ApiModel(description = "Modelo TareaDto")
@Data
public class TareaDto implements Serializable {

  private static final long serialVersionUID = -7287619714621366577L;

  @ApiModelProperty(value = "Identificador de la tarea", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long id;

  @ApiModelProperty(value = "Estado actual de la tarea", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private EstadoTareaDto estado;

  @NotNull
  @ApiModelProperty(value = "Trabajo asociado", required = true, accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idTrabajo;

  @ApiModelProperty(value = "Fecha en la que se creo el tarea", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDateTime fechaHoraCreacion;

  @ApiModelProperty(value = "Fecha en la que se empieza a procesar la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraInicioTarea;

  @ApiModelProperty(value = "Fecha en la que se termina de procesar la tarea", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraFinTarea;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "0001")
  private String idOrganization;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
  private String stdIdLegEnt;

  @NotNull
  @ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true, example = "2017-03-01")
  private LocalDate fechaInicioPeriodo;

  @NotNull
  @ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true, example = "2017-03-31")
  private LocalDate fechaFinPeriodo;

  @ApiModelProperty(value = "Ambito de la tarea", required = false)
  private List<TareaAmbitoDto> ambito;

  @ApiModelProperty(value = "Ambito persona de la tarea", required = false)
  private List<TareaAmbitoPersonaDto> persona;

  @ApiModelProperty(value = "Ambito localizacion de la tarea", required = false)
  private List<TareaAmbitoLocalizacionDto> localizacion;

}
