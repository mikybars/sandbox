package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PresupuestosWlocFilterDto implements Serializable {

  private static final long serialVersionUID = 5924519730735658156L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private String idSeccion;

  private String banda;

  private String ordinal;

  private List<PresupuestosWlocFilterParametersDto> item;

}
