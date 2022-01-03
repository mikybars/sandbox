package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class TiendasFilterDto implements Serializable {

  private static final long serialVersionUID = 1406333465393030459L;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private String idEmpresa;

  private LocalDateTime fechaInicio;

  private List<TiendasFilterParametersDto> items;

}
