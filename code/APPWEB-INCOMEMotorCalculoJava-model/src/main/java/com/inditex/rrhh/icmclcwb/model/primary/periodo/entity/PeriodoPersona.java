package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERIODO_PERSONA")
@Data
public class PeriodoPersona {

  @EmbeddedId
  private PeriodoPersonaPk pk;

}
