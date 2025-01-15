package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROGRAMACION")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Programacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION")
  private Long id;

  @NotNull
  @Column(name = "HORA_PROGRAMACION", nullable = false)
  private LocalTime horaProgramacion;

  @NotNull
  @Column(name = "PROGRAMACION_HUSO", length = 12, nullable = false)
  private String programacionHuso;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @NotBlank
  @Column(name = "NOMBRE_USUARIO", length = 12, nullable = false)
  private String nombreUsuario;

  @NotNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private LocalDateTime fechaHoraCreacion;

  @Column(name = "FECHA_HORA_ULTIMA_EJECUCION", nullable = true)
  private LocalDateTime fechaHoraUltimaEjecucion;

  @NotNull
  @Column(name = "FECHA_HORA_SIGUIENTE_EJECUCION", nullable = false)
  private LocalDateTime fechaHoraSiguienteEjecucion;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_AMBITO", nullable = false)
  private TipoAmbito tipoAmbito;

}
