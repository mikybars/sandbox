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
public class TareaLocalizacionPresenciaPk implements Serializable {

  private static final long serialVersionUID = 1552322741633436428L;

  @Column(name = "ID_TAREA_LOCALIZACION_PRESENCIA")
  private Long id;

  @NotNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPeriodo;

}
