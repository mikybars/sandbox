package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_AMBITO_LOCALIZACION")
@Data
public class ProgramacionAmbitoLocalizacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO_LOCALIZACION")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_PROGRAMACION_AMBITO", nullable = false)
  private ProgramacionAmbito programacionAmbito;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", length = 48, nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", length = 48, nullable = false)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", length = 48, nullable = false)
  private String stdIdWorkLocat;

}
