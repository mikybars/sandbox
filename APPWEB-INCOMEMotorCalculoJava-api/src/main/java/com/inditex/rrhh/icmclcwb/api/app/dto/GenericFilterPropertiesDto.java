package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

@Data
public abstract class GenericFilterPropertiesDto {

  private Integer maxPageSize;

  private Integer maxPersistenceSize;

}
