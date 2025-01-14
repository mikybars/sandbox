package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jspecify.annotations.NonNull;

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

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA_FASE", nullable = false)
  private TareaFase tareaFase;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_ACCION", nullable = false)
  private Accion accion;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_PUNTO_EJECUCION", nullable = false)
  private PuntoEjecucion puntoEjecucion;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_ESTADO_TAREA_FASE_ACCION", nullable = false)
  private EstadoTareaFaseAccion estadoTareaFaseAccion;

  @NonNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private Date fechaHoraCreacion;

  @Column(name = "FECHA_HORA_INICIO", nullable = true)
  private Date fechaHoraInicio;

  @Column(name = "FECHA_HORA_FIN", nullable = true)
  private Date fechaHoraFin;

  @NonNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

}
