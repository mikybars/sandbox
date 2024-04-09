package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TIPO_POLITICA")
@Data
public class TipoPolitica {

  @Id
  @Column(name = "ID_TIPO_POLITICA")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "ICM_ID_TP_POLITICAS", length = 24, nullable = false)
  private String icmIdTpPolitica;

  @NotNull
  @Column(name = "PESO", nullable = false)
  private Integer peso;

}
