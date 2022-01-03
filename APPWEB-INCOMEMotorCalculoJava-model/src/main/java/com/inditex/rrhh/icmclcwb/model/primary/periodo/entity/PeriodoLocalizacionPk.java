package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class PeriodoLocalizacionPk implements Serializable {

  private static final long serialVersionUID = 1754334020811320122L;

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
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

}
