package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "PERIODO_CALCULO_PERSONA")
@Data
public class PeriodoCalculoPersona {

  @EmbeddedId
  private PeriodoCalculoPersonaPk pk;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA_ACTUAL", nullable = false)
  private Tarea tareaActual;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA_ULTIMA", nullable = false)
  private Tarea tareaUltima;

  @NonNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private Date fechaHoraCreacion;

  @NonNull
  @Column(name = "FECHA_HORA_ACTUALIZACION", nullable = false)
  private Date fechaHoraActualizacion;

  @OneToOne
  @JoinColumn(name = "ID_ESTADO", nullable = false)
  private EstadoPeriodoCalculoPersona estado;

  @NonNull
  @Column(name = "ES_BLOQUEADO", nullable = false)
  private Boolean bloqueado;

}
