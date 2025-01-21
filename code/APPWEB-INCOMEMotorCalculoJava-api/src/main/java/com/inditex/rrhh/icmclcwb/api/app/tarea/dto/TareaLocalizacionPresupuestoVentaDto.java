package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPresupuestoVentaDto implements Serializable {

  private static final long serialVersionUID = -9168287171777824121L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private Long cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String cclIdCadena;

  @NotNull
  private Integer ordinal;

  @NotNull
  private Double importeSinImpuestos;

  @NotNull
  private Double importeConImpuestos;

  private Integer idTipoPresupuesto;

  private String icmIdConceptoVenta;

  @NotBlank
  private String cclIdOrigen;

  @NotNull
  private Boolean activo;

  @NotNull
  private Integer idTipoDato;

}
