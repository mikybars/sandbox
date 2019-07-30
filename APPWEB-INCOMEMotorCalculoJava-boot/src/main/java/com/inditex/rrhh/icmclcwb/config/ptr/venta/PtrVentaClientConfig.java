package com.inditex.rrhh.icmclcwb.config.ptr.venta;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.common.rest.client.builder.RestClientBuilder;

@Configuration
public class PtrVentaClientConfig {

	@Bean(name = "ptrVentaClient")
	@ConfigurationProperties(prefix = "amiga.common.rest.client.ptr-venta")
	public RestClient ptrVentaClient(final RestClientBuilder builder) {
		return builder.build();
	}

}