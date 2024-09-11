package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class DatosComunesVenta extends DatosComunes {

  @NotNull
  @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
  private Double importeSinImpuestos;

  @NotNull
  @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
  private Double importeConImpuestos;
}
