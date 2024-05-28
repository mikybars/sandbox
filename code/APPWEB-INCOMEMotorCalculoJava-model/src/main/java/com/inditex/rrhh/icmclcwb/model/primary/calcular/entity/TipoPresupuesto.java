package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_PRESUPUESTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoPresupuesto {

  @Id
  @Column(name = "ID_TIPO_PRESUPUESTO")
  private Integer id;

  @NotBlank
  @Column(name = "ICM_ID_TP_PRESUPUESTO", nullable = false, length = 48)
  private String icmIdTpPresupuesto;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

}
