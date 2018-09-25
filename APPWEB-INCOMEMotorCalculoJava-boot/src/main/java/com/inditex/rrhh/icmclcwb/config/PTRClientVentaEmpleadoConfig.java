package com.inditex.rrhh.icmclcwb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.common.rest.client.builder.RestClientBuilder;

@Configuration
public class PTRClientVentaEmpleadoConfig {

	@Bean(name = "ptrClientVentaEmpleado")
	@ConfigurationProperties(prefix = "amiga.common.rest.client.ptrClientVentaEmpleado")
	public RestClient testRestClient(final RestClientBuilder builder) {
		return builder.build();
	}

}