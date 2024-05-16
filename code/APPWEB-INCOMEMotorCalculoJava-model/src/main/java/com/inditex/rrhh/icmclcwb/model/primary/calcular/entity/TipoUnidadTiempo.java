package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_UNIDAD_TIEMPO")
@Data
public class TipoUnidadTiempo {

  @Id
  @Column(name = "ID_TIPO_UNIDAD_TIEMPO")
  private Integer id;

  @NotBlank
  @Column(name = "ICM_ID_UNIDAD_TIEMPO", nullable = false, length = 48)
  private String icmIdUnidadTiempo;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

}
