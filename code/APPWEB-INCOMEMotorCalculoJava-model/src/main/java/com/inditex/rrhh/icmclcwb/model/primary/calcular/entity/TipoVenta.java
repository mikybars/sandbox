package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_VENTA")
@Data
public class TipoVenta {

  @Id
  @Column(name = "ID_TIPO_VENTA")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

  @NotNull
  @Column(name = "PESO", nullable = false)
  private Integer peso;

  @NotNull
  @Column(name = "ES_ONLINE", nullable = false)
  private Boolean online;

}
