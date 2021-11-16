package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "ESTADO_TRABAJO")
@Data
public class EstadoTrabajo {

  @Id
  @Column(name = "ID_ESTADO_TRABAJO")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotNull
  @Column(name = "PESO", nullable = false)
  private Integer peso;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_ESTADO_TAREA")
  private EstadoTarea estadoTarea;

}
