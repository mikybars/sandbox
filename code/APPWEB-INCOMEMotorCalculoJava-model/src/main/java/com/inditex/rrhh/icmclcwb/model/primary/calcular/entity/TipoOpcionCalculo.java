package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_OPCION_CALCULO")
@Data
public class TipoOpcionCalculo {

  @Id
  @Column(name = "ID_TIPO_OPCION_CALCULO")
  private Integer id;

  @NotBlank
  @Column(name = "ICM_ID_TP_OP_CALC")
  private String idMeta4;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

}
