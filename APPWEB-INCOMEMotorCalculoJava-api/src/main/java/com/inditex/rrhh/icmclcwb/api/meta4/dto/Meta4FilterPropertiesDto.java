package com.inditex.rrhh.icmclcwb.api.meta4.dto;

import lombok.Data;

@Data
public class Meta4FilterPropertiesDto {

	private Integer maxPageSize;

	private Integer maxPersistenceSize;

	private Integer maxQuerySize;

	private Integer retryAttempts;

}