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
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_PERSONA_HISTORICO")
@Data
public class TareaPersonaHistorico {

  @EmbeddedId
  private TareaPersonaHistoricoPk pk;

  @NonNull
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

  @NonNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NonNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NonNull
  @Column(name = "FECHA_INICIO_SECCION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioSeccion;

  @NonNull
  @Column(name = "FECHA_FIN_SECCION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinSeccion;

  @NonNull
  @Column(name = "FECHA_INICIO_LOCALIZACION", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioLocalizacion;

  @NonNull
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
