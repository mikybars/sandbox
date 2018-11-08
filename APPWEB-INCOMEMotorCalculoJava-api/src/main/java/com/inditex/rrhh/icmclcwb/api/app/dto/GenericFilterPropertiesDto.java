package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

@Data
public class GenericFilterPropertiesDto {
	
	private Integer maxPageSize; 
	private Integer maxPersistenceSize;
	private Integer maxQuerySize;
	private Integer retryAttempts;
	
}
