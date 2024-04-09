package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
