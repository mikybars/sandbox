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
@Table(name = "TAREA_PERSONA_HISTORICO")
@Data
public class TareaPersonaHistorico {

  @EmbeddedId
  private TareaPersonaHistoricoPk pk;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false)
  private String stdIdHr;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
  private String cclIdCodOrigen;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false)
  private String stdIdWorkLocat;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false)
  private String cclIdSeccion;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotNull
  @Column(name = "FECHA_INICIO_SECCION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioSeccion;

  @NotNull
  @Column(name = "FECHA_FIN_SECCION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinSeccion;

  @NotNull
  @Column(name = "FECHA_INICIO_LOCALIZACION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioLocalizacion;

  @NotNull
  @Column(name = "FECHA_FIN_LOCALIZACION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinLocalizacion;

  @Column(name = "FECHA_ANTIGUEDAD", nullable = true)
  @Temporal(TemporalType.DATE)
  private Date fechaAntiguedad;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false)
  private String stdIdLegEnt;

}
