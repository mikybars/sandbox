package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_AMBITO_EMPRESA")
@Data
public class ProgramacionAmbitoEmpresa extends ProgramacionCommonFieldsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROGRAMACION_AMBITO_EMPRESA")
  private Long id;

}
