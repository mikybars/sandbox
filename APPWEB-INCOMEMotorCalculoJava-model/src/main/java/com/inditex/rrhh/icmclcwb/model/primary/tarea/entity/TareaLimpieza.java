package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoLimpieza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_LIMPIEZA")
@Data
public class TareaLimpieza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LIMPIEZA")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_ESTADO_LIMPIEZA", nullable = false)
  private EstadoLimpieza estado;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_LIMPIEZA", nullable = false)
  private TipoLimpieza tipo;

  @NotNull
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
