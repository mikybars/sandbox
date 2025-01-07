package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

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
public class CommonFieldsTaskEntity extends CommonFieldsTask {

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

}
