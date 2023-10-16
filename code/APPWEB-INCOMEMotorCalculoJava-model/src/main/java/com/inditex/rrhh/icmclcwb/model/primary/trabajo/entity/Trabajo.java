package com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTrabajo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TRABAJO")
@Data
public class Trabajo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TRABAJO")
  private Long id;

  @NotBlank
  @Column(name = "NOMBRE_USUARIO", nullable = false, length = 12)
  private String nombreUsuario;

  @NotNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private LocalDateTime fechaHoraCreacion;

  @NotNull
  @Column(name = "ICM_ID_PERIODO", nullable = false)
  private Long icmIdPeriodo;

  @NotNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  private LocalDate fechaInicioPeriodo;

  @NotNull
  @Column(name = "FECHA_FIN_PERIODO", nullable = false)
  private LocalDate fechaFinPeriodo;

  @Column(name = "FECHA_HORA_INICIO_TRABAJO", nullable = true)
  private LocalDate fechaHoraInicioTrabajo;

  @Column(name = "FECHA_HORA_FIN_TRABAJO", nullable = true)
  private LocalDate fechaHoraFinTrabajo;

  @NotBlank
  @Column(name = "ID_ORGANIZATION", nullable = false, length = 48)
  private String idOrganization;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_AMBITO", nullable = false)
  private TipoAmbito tipoAmbito;

  @ManyToOne
  @JoinColumn(name = "ID_PROGRAMACION")
  private Programacion programacion;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "ID_ESTADO_TRABAJO", nullable = false)
  private EstadoTrabajo estado;

}
