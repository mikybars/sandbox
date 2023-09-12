package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ConfPrecioHoraFilterDto implements Serializable {

  private static final long serialVersionUID = -1696271383981290890L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<ConfPrecioHoraFilterParametersDto> item;

}
