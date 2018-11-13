package com.inditex.rrhh.icmclcwb.config.ptr;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;

import lombok.Data;


@Data
@Configuration
@ConfigurationProperties(prefix="app.envars.ptr.presencia.service")
public class PTRClientPresenciaPropertiesConfig {
	
	PtrPropertiesDto getPresenciasTotalTiendaSeccion;
	
	@Bean(name = "presenciasTotalTiendaSeccionDto")
	public PtrPropertiesDto getPresenciasTotalTiendaSeccion() {
		return getPresenciasTotalTiendaSeccion;	
	}
}
