package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TAREA_FASE_ACCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TareaFaseAccion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_FASE_ACCION")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA_FASE", nullable = false)
  private TareaFase tareaFase;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_ACCION", nullable = false)
  private Accion accion;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_PUNTO_EJECUCION", nullable = false)
  private PuntoEjecucion puntoEjecucion;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_ESTADO_TAREA_FASE_ACCION", nullable = false)
  private EstadoTareaFaseAccion estadoTareaFaseAccion;

  @NotNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private Date fechaHoraCreacion;

  @Column(name = "FECHA_HORA_INICIO", nullable = true)
  private Date fechaHoraInicio;

  @Column(name = "FECHA_HORA_FIN", nullable = true)
  private Date fechaHoraFin;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

}
