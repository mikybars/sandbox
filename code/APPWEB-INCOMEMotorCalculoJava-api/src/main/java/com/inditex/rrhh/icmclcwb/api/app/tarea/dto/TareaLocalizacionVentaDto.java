package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLocalizacionVentaDto implements Serializable {

  private static final long serialVersionUID = -1628018951831382514L;

  private Long id;

  @NotNull
  private Long idTarea;

  private LocalDate fecha;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotNull
  private Double importeSinImpuestos;

  @NotNull
  private Double importeConImpuestos;

  private Long idTipoImporteVenta;

  @NotNull
  private Boolean activo;

}
