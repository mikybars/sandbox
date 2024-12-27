package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosComunesVenta extends DatosComunes {

  @NonNull
  @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
  private Double importeSinImpuestos;

  @NonNull
  @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
  private Double importeConImpuestos;
}
