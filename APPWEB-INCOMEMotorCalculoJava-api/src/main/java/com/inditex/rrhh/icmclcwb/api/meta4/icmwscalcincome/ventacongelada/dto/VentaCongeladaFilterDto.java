package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class VentaCongeladaFilterDto implements Serializable {

  private static final long serialVersionUID = -9140799941342961404L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private List<VentaCongeladaFilterParametersDto> item;

}
