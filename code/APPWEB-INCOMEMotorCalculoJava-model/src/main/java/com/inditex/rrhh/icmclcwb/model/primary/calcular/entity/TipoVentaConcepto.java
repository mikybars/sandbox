package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_VENTA_CONCEPTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoVentaConcepto {

  @Id
  @Column(name = "ID_TIPO_VENTA_CONCEPTO")
  private Long id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

  @NotBlank
  @Column(name = "ICM_ID_CONCEPTO_VENTA", length = 8, nullable = false)
  private String icmIdConceptoVenta;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA", nullable = false)
  private TipoVenta tipoVenta;

}
