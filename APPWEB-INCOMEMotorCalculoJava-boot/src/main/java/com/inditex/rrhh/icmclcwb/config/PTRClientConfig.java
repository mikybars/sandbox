 package com.inditex.rrhh.icmclcwb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="app.envars.ptr.service")
public class PTRClientConfig {

	PtrPropertiesDto ptrClientVenta1;
	
	@Bean(name = "ptrClientVentaDto")
	public PtrPropertiesDto getPtrClientVenta() {
		return ptrClientVenta1;	
	}

}
