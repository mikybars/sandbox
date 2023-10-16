package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PERIODO_CALCULO_PERSONA")
@Data
public class PeriodoCalculoPersona {

  @EmbeddedId
  private PeriodoCalculoPersonaPk pk;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA_ACTUAL", nullable = false)
  private Tarea tareaActual;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA_ULTIMA", nullable = false)
  private Tarea tareaUltima;

  @NotNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private Date fechaHoraCreacion;

  @NotNull
  @Column(name = "FECHA_HORA_ACTUALIZACION", nullable = false)
  private Date fechaHoraActualizacion;

  @OneToOne
  @JoinColumn(name = "ID_ESTADO", nullable = false)
  private EstadoPeriodoCalculoPersona estado;

  @NotNull
  @Column(name = "ES_BLOQUEADO", nullable = false)
  private Boolean bloqueado;

}
