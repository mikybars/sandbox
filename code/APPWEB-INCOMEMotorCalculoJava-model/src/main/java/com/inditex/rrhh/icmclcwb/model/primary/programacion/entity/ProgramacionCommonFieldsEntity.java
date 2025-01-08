package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacionCommonFieldsEntity extends ProgramacionCommonFields {

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", length = 48, nullable = false)
  private String stdIdLegEnt;

}
