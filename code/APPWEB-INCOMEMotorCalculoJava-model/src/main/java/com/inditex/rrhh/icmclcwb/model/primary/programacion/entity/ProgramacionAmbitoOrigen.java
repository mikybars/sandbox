package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_AMBITO_ORIGEN")
@Data
public class ProgramacionAmbitoOrigen extends ProgramacionCommonFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO_ORIGEN")
  private Long id;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", length = 48, nullable = false)
  private String cclIdOrigen;

}
