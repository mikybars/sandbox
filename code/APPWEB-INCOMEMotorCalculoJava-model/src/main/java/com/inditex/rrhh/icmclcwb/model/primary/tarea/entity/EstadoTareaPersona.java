package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "ESTADO_TAREA_PERSONA")
@Data
public class EstadoTareaPersona {

  @Id
  @Column(name = "ID_ESTADO_TAREA_PERSONA")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @Column(name = "PESO", nullable = true)
  private Integer peso;

}
