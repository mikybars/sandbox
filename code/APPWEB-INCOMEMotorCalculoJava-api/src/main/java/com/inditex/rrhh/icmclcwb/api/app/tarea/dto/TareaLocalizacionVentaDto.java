package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLocalizacionVentaDto implements Serializable {

  private static final long serialVersionUID = -1628018951831382514L;

  private Long id;

  @NonNull
  private Long idTarea;

  private LocalDate fecha;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NonNull
  private Double importeSinImpuestos;

  @NonNull
  private Double importeConImpuestos;

  private Long idTipoImporteVenta;

  @NonNull
  private Boolean activo;

}
