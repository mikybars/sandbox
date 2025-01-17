package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ACCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Accion {

  @Id
  @Column(name = "ID_ACCION")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

  @Column(name = "REACCION_PESO", nullable = true)
  private Integer peso;

  @NotNull
  @Column(name = "ES_REACCION_ESPERAR", nullable = false)
  private Boolean esReaccionEsperar;

  @NotNull
  @Column(name = "ES_REACCION_REINTENTO", nullable = false)
  private Boolean esReaccionReintento;

  @Column(name = "REACCION_REINTENTO_MAX", nullable = true)
  private Integer reintentoMax;

  @Column(name = "REACCION_REINTENTO_DELAY", nullable = true)
  private Integer reintentoDelay;

}
