package com.inditex.rrhh.icmclcwb.config.ventaintegra;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.dto.VentaIntegraPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.venta-integra.venta-integra")
public class VentaIntegraClientPropertiesConfig {

  private Map<String, VentaIntegraPropertiesDto> ventaIntegra = new HashMap<>();

  @Bean(name = "ventaIntegraProperties")
  public Map<String, VentaIntegraPropertiesDto> ventaIntegraProperties() {
    return ventaIntegra;
  }

}
