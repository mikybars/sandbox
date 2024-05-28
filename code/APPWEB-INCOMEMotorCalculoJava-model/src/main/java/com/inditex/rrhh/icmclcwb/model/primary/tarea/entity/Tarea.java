package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.time.LocalDate;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA")
@Data
public class Tarea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA")
  private Long id;

  @OneToOne
  @JoinColumn(name = "ID_ESTADO_TAREA", nullable = false)
  private EstadoTarea estado;

  @NotNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private Date fechaHoraCreacion;

  @Column(name = "FECHA_HORA_INICIO_TAREA", nullable = true)
  private Date fechaHoraInicioTarea;

  @Column(name = "FECHA_HORA_FIN_TAREA", nullable = true)
  private Date fechaHoraFinTarea;

  @NotBlank
  @Column(name = "ID_ORGANIZATION", nullable = false, length = 48)
  private String idOrganization;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

  @NotNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  private LocalDate fechaInicioPeriodo;

  @NotNull
  @Column(name = "FECHA_FIN_PERIODO", nullable = false)
  private LocalDate fechaFinPeriodo;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_TRABAJO")
  private Trabajo trabajo;

}
