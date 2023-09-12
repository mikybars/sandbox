package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class EstructurasComFilterDto implements Serializable {

  private static final long serialVersionUID = -5790863324236725001L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<EstructurasComFilterParametersDto> item;

}
