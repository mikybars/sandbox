package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class VentaManualWlocFilterDto implements Serializable {

  private static final long serialVersionUID = -1L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<String> idsEmpresa;

  private String idCadena;

  private List<VentaManualWlocFilterParametersDto> item;

}
