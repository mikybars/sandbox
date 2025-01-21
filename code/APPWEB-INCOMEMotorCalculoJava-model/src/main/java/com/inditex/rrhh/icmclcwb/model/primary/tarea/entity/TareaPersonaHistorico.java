package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_HISTORICO")
@Data
public class TareaPersonaHistorico extends CommonFieldsTaskEntity {

  @EmbeddedId
  private TareaPersonaHistoricoPk pk;

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
  @Column(name = "CCL_ID_SECCION", nullable = false)
  private String cclIdSeccion;

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

}
