package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PresupuestosRangoFilterDto implements Serializable {

  private static final long serialVersionUID = 5924519730735658156L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<PresupuestosRangoFilterParametersDto> item;

}
