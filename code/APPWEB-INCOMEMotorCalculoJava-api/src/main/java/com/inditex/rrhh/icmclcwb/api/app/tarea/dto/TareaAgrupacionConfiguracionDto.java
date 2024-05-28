package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;

import lombok.Data;

@Data
public class TareaAgrupacionConfiguracionDto implements Serializable {

  private static final long serialVersionUID = -8470928612425957019L;

  private Long id;

  private Long idTarea;

  private Long icmIdAgrupacionOnline;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String cclIdOrigen;

  private Double porcentajeInclusion;

  private TipoVentaConceptoDto tipoVentaConcepto;

}
