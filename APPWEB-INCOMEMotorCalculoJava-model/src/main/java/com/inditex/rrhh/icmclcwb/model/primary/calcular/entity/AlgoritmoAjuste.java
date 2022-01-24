package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "ALGORITMO_AJUSTE")
@Data
public class AlgoritmoAjuste {

  @Id
  @Column(name = "ID_ALGORITMO_AJUSTE")
  private Integer id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_POLITICA")
  private TipoPolitica tipoPolitica;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotNull
  @Column(name = "PESO", nullable = false)
  private Long peso;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

}
