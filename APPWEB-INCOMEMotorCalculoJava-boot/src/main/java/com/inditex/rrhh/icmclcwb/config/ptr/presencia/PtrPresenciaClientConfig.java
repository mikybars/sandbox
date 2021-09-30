package com.inditex.rrhh.icmclcwb.config.ptr.presencia;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.common.rest.client.builder.RestClientBuilder;

@Configuration
public class PtrPresenciaClientConfig {

    @Bean(name = "ptrPresenciaClient")
    @ConfigurationProperties(prefix = "amiga.common.rest.client.ptr-presencia")
    public RestClient ptrPresenciaClient(final RestClientBuilder builder) {
        return builder.build();
    }

}
