package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TIPO_PRESENCIA")
@Data
public class TipoPresencia {

  @Id
  @Column(name = "ID_TIPO_PRESENCIA")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

  @NonNull
  @Column(name = "PESO", nullable = false)
  private Long peso;

}
