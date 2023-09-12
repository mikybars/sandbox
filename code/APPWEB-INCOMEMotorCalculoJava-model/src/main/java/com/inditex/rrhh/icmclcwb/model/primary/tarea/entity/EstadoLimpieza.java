package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ESTADO_LIMPIEZA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoLimpieza {

  @Id
  @Column(name = "ID_ESTADO_LIMPIEZA")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

}
