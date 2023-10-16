package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
