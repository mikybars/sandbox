package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionFestivoDto implements Serializable {

  private static final long serialVersionUID = -3737607409295676791L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private Long stdIdWorkLocat;

  @NotNull
  private Date fecha;

}
