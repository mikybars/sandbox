package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_COEFICIENTE")
@Data
public class TareaPersonaCoeficiente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_PERSONA_COEFICIENTE")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false, length = 18)
  private String stdIdHr;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotNull
  @Column(name = "FECHA_INICIO_PARCIAL", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPar;

  @NotNull
  @Column(name = "FECHA_FIN_PARCIAL", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinPar;

  @NotNull
  @Column(name = "FECHA_INICIO_COMPLETA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioCom;

  @NotNull
  @Column(name = "FECHA_FIN_COMPLETA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinCom;

  @NotNull
  @Column(name = "COEFICIENTE", nullable = false, precision = 23, scale = 8)
  private BigDecimal coeficiente;

}
