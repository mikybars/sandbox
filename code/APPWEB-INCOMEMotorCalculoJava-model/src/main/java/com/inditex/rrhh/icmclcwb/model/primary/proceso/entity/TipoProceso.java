package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TIPO_PROCESO")
@Data
public class TipoProceso {

  @Id
  @Column(name = "ID_TIPO_PROCESO")
  private Integer id;

  @Column(name = "NOMBRE", nullable = false, length = 128)
  private String nombre;

}
