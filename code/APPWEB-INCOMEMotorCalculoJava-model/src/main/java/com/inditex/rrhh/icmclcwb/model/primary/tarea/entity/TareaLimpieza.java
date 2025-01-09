package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoLimpieza;

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
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_LIMPIEZA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLimpieza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LIMPIEZA")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_ESTADO_LIMPIEZA", nullable = false)
  private EstadoLimpieza estado;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_LIMPIEZA", nullable = false)
  private TipoLimpieza tipo;

  @NonNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private Date fechaHoraCreacion;

  @Column(name = "FECHA_HORA_INICIO", nullable = true)
  private Date fechaHoraInicio;

  @Column(name = "FECHA_HORA_FIN", nullable = true)
  private Date fechaHoraFin;

  @NotBlank
  @Column(name = "NOMBRE_USUARIO", nullable = false, length = 12)
  private String nombreUsuario;

}
