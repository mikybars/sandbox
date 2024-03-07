package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class ReglaEmpleadoExternoMeta4Pk implements Serializable {

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "PUESTO", nullable = false)
  private Integer puesto;

}
