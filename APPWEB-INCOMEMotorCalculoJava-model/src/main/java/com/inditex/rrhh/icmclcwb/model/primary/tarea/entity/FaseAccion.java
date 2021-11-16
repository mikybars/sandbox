package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
