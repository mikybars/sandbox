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
@Table(name = "PROGRAMACION_AMBITO_LOCALIZACION")
@Data
public class ProgramacionAmbitoLocalizacion extends ProgramacionCommonFieldsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO_LOCALIZACION")
  private Long id;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", length = 48, nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", length = 48, nullable = false)
  private String stdIdWorkLocat;

}
