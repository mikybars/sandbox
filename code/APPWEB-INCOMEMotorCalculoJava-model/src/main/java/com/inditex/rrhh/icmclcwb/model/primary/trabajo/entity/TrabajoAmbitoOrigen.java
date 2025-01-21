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
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TRABAJO_AMBITO_ORIGEN")
@Data
public class TrabajoAmbitoOrigen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TRABAJO_AMBITO_ORIGEN")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TRABAJO", nullable = false)
  private Trabajo trabajo;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 24)
  private String cclIdOrigen;

}
