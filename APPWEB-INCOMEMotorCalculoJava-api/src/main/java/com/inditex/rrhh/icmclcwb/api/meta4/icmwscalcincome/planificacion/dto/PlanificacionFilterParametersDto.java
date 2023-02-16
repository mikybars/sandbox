package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanificacionFilterParametersDto implements Serializable {

  private static final long serialVersionUID = -1L;

  private LocalDate fecFin;

  private String idOrigen;

  private String listaEmpresas;

  private String listaEmpleados;

  private String listaTiendas;

  private String proceso;

  private Long idAmbito;

  private Long idPeriodo;

}
