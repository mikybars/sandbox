package com.inditex.rrhh.icmclcwb.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.dto.PaginationConfigPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.meta4.service")
public class PaginationConfig {

    private List<PaginationConfigPropertiesDto> page;
    
	@Bean(name = "paginationProperties")
	public List<PaginationConfigPropertiesDto> getPaginationConfigPropertiesDto() {
		return page;
	}

}
