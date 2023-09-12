package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TareaAgrupacion {

  private String fecha;

  private Long idAgrupacion;

  private Integer idSeccion;

  private Long idTarea;

  private Integer idPais;

}
