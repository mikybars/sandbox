package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class TareaPersonaEstructuraDesplazamientoRealPk implements Serializable {

  @Column(name = "ID_TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO_REAL")
  private Long id;

  @NotNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPeriodo;

}
