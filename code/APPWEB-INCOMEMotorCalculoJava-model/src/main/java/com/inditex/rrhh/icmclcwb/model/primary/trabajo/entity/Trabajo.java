package com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTrabajo;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TRABAJO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trabajo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TRABAJO")
  private Long id;

  @NotBlank
  @Column(name = "NOMBRE_USUARIO", nullable = false, length = 12)
  private String nombreUsuario;

  @NonNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private LocalDateTime fechaHoraCreacion;

  @NonNull
  @Column(name = "ICM_ID_PERIODO", nullable = false)
  private Long icmIdPeriodo;

  @NonNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  private LocalDate fechaInicioPeriodo;

  @NonNull
  @Column(name = "FECHA_FIN_PERIODO", nullable = false)
  private LocalDate fechaFinPeriodo;

  @Column(name = "FECHA_HORA_INICIO_TRABAJO", nullable = true)
  private LocalDate fechaHoraInicioTrabajo;

  @Column(name = "FECHA_HORA_FIN_TRABAJO", nullable = true)
  private LocalDate fechaHoraFinTrabajo;

  @NotBlank
  @Column(name = "ID_ORGANIZATION", nullable = false, length = 48)
  private String idOrganization;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_AMBITO", nullable = false)
  private TipoAmbito tipoAmbito;

  @ManyToOne
  @JoinColumn(name = "ID_PROGRAMACION")
  private Programacion programacion;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "ID_ESTADO_TRABAJO", nullable = false)
  private EstadoTrabajo estado;

}
