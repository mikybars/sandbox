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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ALGORITMO_AJUSTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
