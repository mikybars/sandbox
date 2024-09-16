package com.inditex.rrhh.icmclcwb.model.primary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_AMBITO")
@Data
public class TipoAmbito {

  @Id
  @Column(name = "ID_TIPO_AMBITO")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = 32, nullable = false)
  private String nombre;

}
