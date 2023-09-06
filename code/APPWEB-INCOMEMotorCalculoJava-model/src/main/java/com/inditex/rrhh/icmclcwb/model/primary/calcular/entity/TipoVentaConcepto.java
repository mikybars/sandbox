package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
