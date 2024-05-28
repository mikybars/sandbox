package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "FASE_ACCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FaseAccion {

  @EmbeddedId
  private FaseAccionPk pk;

  @OneToOne
  @JoinColumn(name = "ID_PUNTO_EJECUCION", nullable = false)
  private PuntoEjecucion puntoEjecucion;

  @Column(name = "PESO", nullable = true)
  private Integer peso;

}
