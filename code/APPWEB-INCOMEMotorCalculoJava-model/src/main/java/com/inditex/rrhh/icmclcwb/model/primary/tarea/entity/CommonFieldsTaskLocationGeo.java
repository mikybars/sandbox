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
public class CommonFieldsTaskLocationGeo extends CommonFieldsTaskLocation {

  @NotBlank
  @Column(name = "STD_ID_COUNTRY", nullable = false, length = 8)
  private String stdIdCountry;

  @NotBlank
  @Column(name = "STD_ID_SUB_GEO_DIV", length = 16)
  private String stdIdSubGeoDiv;

}
