package com.inditex.rrhh.icmclcwb.config.ventaintegra;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclcwb.model.app.annotation.AntiguoMotor;

import org.springframework.context.annotation.Configuration;

@Configuration
@AntiguoMotor
public class VentaIntegraClientConfig {

  @AmigaRestClient(value = "venta-integra", beanName = "ventaIntegraClient")
  public RestClient ventaIntegraClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
