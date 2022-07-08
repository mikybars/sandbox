package com.inditex.rrhh.icmclcwb.config.ventaintegra;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.common.rest.client.builder.RestClientBuilder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VentaIntegraClientConfig {

  @Bean(name = "ventaIntegraClient")
  @ConfigurationProperties(prefix = "amiga.common.rest.client.venta-integra")
  public RestClient ventaIntegraClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
