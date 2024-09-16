package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_DATO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDato {

  @Id
  @Column(name = "ID_TIPO_DATO")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

  @NotBlank
  @Column(name = "ES_PROCESADO", nullable = false)
  private Boolean procesado;

  @OneToOne
  @JoinColumn(name = "ID_TIPO_PRESENCIA", nullable = true)
  private TipoPresencia tipoPresencia;

  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA", nullable = true)
  private TipoVenta tipoVenta;

}
