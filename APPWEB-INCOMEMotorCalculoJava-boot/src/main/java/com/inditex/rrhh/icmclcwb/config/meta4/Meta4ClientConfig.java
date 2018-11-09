package com.inditex.rrhh.icmclcwb.config.meta4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.meta4.service")
public class Meta4ClientConfig {
	
	Meta4PropertiesDto getEmpleadosTienda;
	Meta4PropertiesDto getValoresCondiciones;

	@Bean(name = "getEmpleadosTiendaDto")
	public Meta4PropertiesDto getEmpleadosTiendaPageDto() {
		return getEmpleadosTienda;	
	}

	@Bean(name = "getValoresCondicionesDto")
	public Meta4PropertiesDto getValoresCondicionesPageDto() {
		return getValoresCondiciones;	
	}
}
