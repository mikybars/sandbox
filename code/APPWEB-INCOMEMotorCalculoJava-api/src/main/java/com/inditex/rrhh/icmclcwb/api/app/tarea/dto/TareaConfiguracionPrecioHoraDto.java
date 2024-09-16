package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TareaConfiguracionPrecioHoraDto implements Serializable {

  private static final long serialVersionUID = 4336409770546732390L;

  private Long id;

  private Long idTarea;

  private Boolean icmCkTpHoraComis;

  private Boolean icmCkTpHoraIncPtpo;

  private Date fechaInicio;

  private Date fechaFin;

  private String cclIdOrigen;

}
