package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DesplazamientosMultiempresaRequestItemDto implements Serializable {

  private static final long serialVersionUID = -1791994449980402147L;

  private LocalDate fechaInicio;

  private LocalDate fechaFin;

  private String idOrigen;

  private String idEmpresa;

}
