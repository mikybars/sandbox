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
@Table(name = "PROGRAMACION_AMBITO_EMPRESA")
@Data
public class ProgramacionAmbitoEmpresa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO_EMPRESA")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_PROGRAMACION_AMBITO", nullable = false)
  private ProgramacionAmbito programacionAmbito;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", length = 48, nullable = false)
  private String stdIdLegEnt;

}
