package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TareaAgrupacionConfiguracionChallengeTipoVentaDto implements Serializable {

  private Long id;

  private Long idTarea;

  private Long icmIdAgrupacionOnline;

  private String icmIdConceptoVenta;

  private Date fechaInicio;

  private Date fechaFin;

  private String cclIdOrigen;

}
