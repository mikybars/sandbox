package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionPresupuestoVentaDto implements Serializable {

  private static final long serialVersionUID = -9168287171777824121L;

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private Long cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String cclIdCadena;

  @NonNull
  private Integer ordinal;

  @NonNull
  private Double importeSinImpuestos;

  @NonNull
  private Double importeConImpuestos;

  private Integer idTipoPresupuesto;

  private String icmIdConceptoVenta;

  @NotBlank
  private String cclIdOrigen;

  @NonNull
  private Boolean activo;

  @NonNull
  private Integer idTipoDato;

}
