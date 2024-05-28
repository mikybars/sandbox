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
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_AMBITO")
@Data
public class ProgramacionAmbito {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_PROGRAMACION", nullable = false)
  private Programacion programacion;

  @NotBlank
  @Column(name = "ID_ORGANIZATION", length = 48, nullable = false)
  private String idOrganization;

}
