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
public class TareaCalculoPk implements Serializable {

  private static final long serialVersionUID = 8454270610096980039L;

  @Column(name = "ID_TAREA_CALCULO")
  private Long id;

  @NonNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPeriodo;

}
