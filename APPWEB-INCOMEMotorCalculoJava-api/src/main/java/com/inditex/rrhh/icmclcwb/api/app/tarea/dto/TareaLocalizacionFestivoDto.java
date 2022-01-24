package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionFestivoDto implements Serializable {

  private static final long serialVersionUID = -3737607409295676791L;

  @ApiModelProperty(value = "Identificador de la tabla localizacion festivo", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Identificador de la localizacion", required = true)
  private Long stdIdWorkLocat;

  @NotNull
  private Date fecha;

}
