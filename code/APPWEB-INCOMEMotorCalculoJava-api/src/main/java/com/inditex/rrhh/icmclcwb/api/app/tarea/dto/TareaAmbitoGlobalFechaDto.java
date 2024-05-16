package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TareaAmbitoGlobalFechaDto implements Serializable {

  private Long id;

  private Long idTarea;

  private Date fechaInicio;

  private Date fechaFin;

}
