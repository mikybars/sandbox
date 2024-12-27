package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_PERSONA_COEFICIENTE")
@Data
public class TareaPersonaCoeficiente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_PERSONA_COEFICIENTE")
  private Long id;

  @NonNull
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

  @NonNull
  @Column(name = "FECHA_INICIO_PARCIAL", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPar;

  @NonNull
  @Column(name = "FECHA_FIN_PARCIAL", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinPar;

  @NonNull
  @Column(name = "FECHA_INICIO_COMPLETA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioCom;

  @NonNull
  @Column(name = "FECHA_FIN_COMPLETA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFinCom;

  @NonNull
  @Column(name = "COEFICIENTE", nullable = false, precision = 23, scale = 8)
  private BigDecimal coeficiente;

}
