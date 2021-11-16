package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERIODO_LOCALIZACION")
@Data
public class PeriodoLocalizacion {

  @EmbeddedId
  private PeriodoLocalizacionPk pk;

}
