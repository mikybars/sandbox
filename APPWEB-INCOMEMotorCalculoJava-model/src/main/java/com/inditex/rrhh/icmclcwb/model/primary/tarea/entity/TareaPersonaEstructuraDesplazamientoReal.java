package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO_REAL")
@Data
public class TareaPersonaEstructuraDesplazamientoReal {

  @EmbeddedId
  private TareaPersonaEstructuraDesplazamientoRealPk pk;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

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

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false, length = 18)
  private String stdIdHr;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

}
