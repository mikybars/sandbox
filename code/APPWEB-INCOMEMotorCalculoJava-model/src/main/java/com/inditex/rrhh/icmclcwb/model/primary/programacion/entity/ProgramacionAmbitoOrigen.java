package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

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
@Table(name = "PROGRAMACION_AMBITO_ORIGEN")
@Data
public class ProgramacionAmbitoOrigen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO_ORIGEN")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_PROGRAMACION_AMBITO", nullable = false)
  private ProgramacionAmbito programacionAmbito;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", length = 48, nullable = false)
  private String cclIdOrigen;

}
