package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ESTADO_PROCESO")
@Data
public class EstadoProceso {

  @Id
  @Column(name = "ID_ESTADO_PROCESO")
  private Integer id;

  @Column(name = "NOMBRE", nullable = false, length = 128)
  private String nombre;

}
