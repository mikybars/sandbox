package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class FaseAccionPk implements Serializable {

  @OneToOne
  @JoinColumn(name = "ID_FASE", nullable = false)
  private Fase fase;

  @OneToOne
  @JoinColumn(name = "ID_ACCION", nullable = false)
  private Accion accion;

}
