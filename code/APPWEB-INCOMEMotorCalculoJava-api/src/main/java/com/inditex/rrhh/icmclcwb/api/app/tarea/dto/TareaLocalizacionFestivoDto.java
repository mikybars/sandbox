package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionFestivoDto implements Serializable {

  private static final long serialVersionUID = -3737607409295676791L;

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private Long stdIdWorkLocat;

  @NonNull
  private Date fecha;

}
