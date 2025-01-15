package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ESTADO_TRABAJO")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
