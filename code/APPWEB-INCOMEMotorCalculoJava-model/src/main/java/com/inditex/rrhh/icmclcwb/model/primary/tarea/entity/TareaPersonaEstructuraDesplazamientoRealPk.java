package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Embeddable
@Data
public class TareaPersonaEstructuraDesplazamientoRealPk implements Serializable {

  @Column(name = "ID_TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO_REAL")
  private Long id;

  @NonNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPeriodo;

}
