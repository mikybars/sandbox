package com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity;

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
@Table(name = "TRABAJO_AMBITO_LOCALIZACION")
@Data
public class TrabajoAmbitoLocalizacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TRABAJO_AMBITO_LOCALIZACION")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TRABAJO", nullable = false)
  private Trabajo trabajo;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 24)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 24)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 24)
  private String stdIdWorkLocat;

}
