package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ConfChTpVentaFilterDto implements Serializable {

  private static final long serialVersionUID = -5476703489860402785L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private String idCadena;

  private String idEmpresa;

  private List<ConfChTpVentaFilterParametersDto> item;

}
