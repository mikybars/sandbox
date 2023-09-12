package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_AUSENCIA")
@Data
public class TipoAusencia {

  @Id
  @Column(name = "ID_TIPO_AUSENCIA")
  private Integer id;

  @NotBlank
  @Column(name = "ICM_TP_ABSENCE", nullable = false, length = 48)
  private String icmTpAbsence;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

}
