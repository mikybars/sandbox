package com.inditex.rrhh.icmclcwb.api.app.simulacion.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SimulacionDto implements Serializable {

  private static final long serialVersionUID = 204984813241998853L;

  private Long id;

  @NotNull
  private LocalDateTime fechaHoraCreacion;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdCadena;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String stdIdHr;

  @NotNull
  private Long icmIdPeriodo;

  @NotNull
  private Date fechaInicio;

  @NotNull
  private Date fechaFin;

  private String stdIdWorkLocat;

  @NotNull
  private Long cclIdOrigen;

  @NotNull
  private Boolean esVentaUltimoCalculo;

  @NotNull
  private Boolean esPresenciaTiendaUltimoCalculo;

  @NotNull
  private Boolean esPresenciaEmpleadoUltimoCalculo;

  @NotNull
  private List<SimulacionLocalizacionBandaExcepcionDto> bandasExcepcionadasSeccion;

}
