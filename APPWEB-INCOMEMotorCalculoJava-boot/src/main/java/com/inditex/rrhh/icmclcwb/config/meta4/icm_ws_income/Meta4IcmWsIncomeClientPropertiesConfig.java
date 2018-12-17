package com.inditex.rrhh.icmclcwb.config.meta4.icm_ws_income;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.meta4.icm-ws-income.service")
public class Meta4IcmWsIncomeClientPropertiesConfig {
	
	Meta4PropertiesDto getEmpleadosTienda;
	
	Meta4PropertiesDto getValoresCondiciones;
	
	Meta4PropertiesDto getEmpleadosEstructura;
	
	Meta4PropertiesDto getTiendaComisionable;
	
	@Bean(name = "getEmpleadosTiendaDto")
	public Meta4PropertiesDto getEmpleadosTiendaPageDto() {
		return getEmpleadosTienda;	
	}

	@Bean(name = "getValoresCondicionesDto")
	public Meta4PropertiesDto getValoresCondicionesPageDto() {
		return getValoresCondiciones;	
	}
	
	@Bean(name = "getEmpleadosEstructuraDto")
	public Meta4PropertiesDto getEmpleadosEstructuraPageDto() {
		return getEmpleadosEstructura;	
	}
	
	@Bean(name = "getTiendaComisionableDto")
	public Meta4PropertiesDto getTiendaComisionablePageDto() {
		return getTiendaComisionable;	
	}
	
}
