package com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity;

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
