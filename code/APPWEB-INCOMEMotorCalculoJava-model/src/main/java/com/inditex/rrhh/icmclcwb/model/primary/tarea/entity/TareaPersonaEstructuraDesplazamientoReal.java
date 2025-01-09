package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO_REAL")
@Data
public class TareaPersonaEstructuraDesplazamientoReal extends CommonFieldsTaskOrigin {

  @EmbeddedId
  private TareaPersonaEstructuraDesplazamientoRealPk pk;

  @NotBlank
  @Column(name = "ICM_ID_ESTRUCTURA_AMBITO", nullable = false, length = 48)
  private String icmIdEstructuraAmbito;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION", nullable = false, length = 48)
  private String icmIdEstrComision;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION_PADRE", nullable = false, length = 48)
  private String icmIdEstrComisionPadre;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION_BASE", nullable = false, length = 48)
  private String icmIdEstrComisionBase;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false, length = 18)
  private String stdIdHr;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

}
