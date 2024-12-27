package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_LOCALIZACION_COMISION_HISTORICO")
@Data
public class TareaLocalizacionComisionHistorico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LOCALIZACION_COMISION_HISTORICO")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

  @NonNull
  @Column(name = "FECHA_INICIO", nullable = false)
  private Date fechaInicio;

  @NonNull
  @Column(name = "FECHA_FIN", nullable = false)
  private Date fechaFin;

  @NonNull
  @Column(name = "ES_COMISIONABLE", nullable = false)
  private Boolean comisionable;

}
