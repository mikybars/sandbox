package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo ProgramacionDto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacionDto implements Serializable {

  private static final long serialVersionUID = 3665361916795418905L;

  @ApiModelProperty(value = "Identificador de la programación", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long id;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppConstants.LOCAL_TIME_JSON)
  @ApiModelProperty(value = "Hora planificada de ejecución", required = true, dataType = "java.lang.String",
      example = "10:00")
  private LocalTime horaProgramacion;

  @ApiModelProperty(value = "Huso horario de la hora planificada de ejecución", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true, example = "UTC")
  private String programacionHuso;

  @NotNull
  @ApiModelProperty(value = "Si la planificación está [activada|desactivada]", required = true, example = "true")
  private Boolean activo;

  @ApiModelProperty(value = "Id del usuario que planificó la ejecución", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true, example = "IAGOML")
  private String nombreUsuario;

  @ApiModelProperty(value = "Fecha en la que se creo la planificación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime fechaHoraCreacion;

  @ApiModelProperty(value = "Fecha de la ultima ejecución", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDateTime fechaHoraUltimaEjecucion;

  @ApiModelProperty(value = "Fecha de la siguiente ejecución", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDateTime fechaHoraSiguienteEjecucion;

  @NotNull
  @ApiModelProperty(value = "Tipo Ambito", required = true, example = "1")
  private TipoAmbitoDto tipoAmbito;

  @NotNull
  @NotEmpty
  @ApiModelProperty(value = "Ambito de la programacion", required = true)
  private List<ProgramacionAmbitoDto> ambito;

}
