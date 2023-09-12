package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.inditex.aqsw.framework.common.validation.constraints.SpelExpression;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoDto")
@Data
@SpelExpression("fechaInicioPeriodo <= fechaFinPeriodo")
public class TrabajoDto implements Serializable {

  private static final long serialVersionUID = 6263836371385557891L;

  @ApiModelProperty(value = "Identificador del trabajo", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long id;

  @ApiModelProperty(value = "Programación asociada", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idProgramacion;

  @ApiModelProperty(value = "Estado actual del trabajo", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private EstadoTrabajoDto estado;

  @ApiModelProperty(value = "Nombre del usuario que solicito el trabajo", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true, example = "IAGOML")
  private String nombreUsuario;

  @ApiModelProperty(value = "Fecha en la que se creo el trabajo", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDateTime fechaHoraCreacion;

  @NotNull
  @ApiModelProperty(value = "Id del periodo a procesar", required = true, example = "1")
  private Long icmIdPeriodo;

  @ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private LocalDate fechaInicioPeriodo;

  @ApiModelProperty(value = "Fecha fin del periodo a procesar", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private LocalDate fechaFinPeriodo;

  @ApiModelProperty(value = "Fecha inicio del trabajo", required = false, example = "2017-03-01")
  private LocalDate fechaHoraInicioTrabajo;

  @ApiModelProperty(value = "Fecha fin del trabajo", required = false, example = "2017-03-31")
  private LocalDate fechaHoraFinTrabajo;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "0001")
  private String idOrganization;

  @NotNull
  @ApiModelProperty(value = "Tipo Ambito", required = true, example = "1")
  private TipoAmbitoDto tipoAmbito;

  @ApiModelProperty(value = "Ambito origen del trabajo", required = false)
  private List<TrabajoAmbitoOrigenDto> origen;

  @ApiModelProperty(value = "Ambito empresa del trabajo", required = false)
  private List<TrabajoAmbitoEmpresaDto> empresa;

  @ApiModelProperty(value = "Ambito persona del trabajo", required = false)
  private List<TrabajoAmbitoPersonaDto> persona;

  @ApiModelProperty(value = "Ambito localizacion del trabajo", required = false)
  private List<TrabajoAmbitoLocalizacionDto> localizacion;

}
