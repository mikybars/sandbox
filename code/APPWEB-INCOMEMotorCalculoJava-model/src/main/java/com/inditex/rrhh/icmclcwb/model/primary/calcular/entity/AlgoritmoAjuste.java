package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "ALGORITMO_AJUSTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlgoritmoAjuste {

  @Id
  @Column(name = "ID_ALGORITMO_AJUSTE")
  private Integer id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_POLITICA")
  private TipoPolitica tipoPolitica;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NonNull
  @Column(name = "PESO", nullable = false)
  private Long peso;

  @NonNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

}
