package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class PeriodoPersonaPk implements Serializable {

  private static final long serialVersionUID = -3551259312147219294L;

  @NotBlank
  @Column(name = "ICM_ID_PERIODO", nullable = false, length = 19)
  private Long icmIdPeriodo;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

}
