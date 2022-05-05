package com.inditex.rrhh.icmclcwb.config.ventaintegra;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.venta-integra.service")
public class VentaIntegraClientPropertiesConfig {

  private Map<String, VentaIntegraPropertiesDto> ventaIntegraService = new HashMap<>();

  @Bean(name = "ventaIntegraProperties")
  public Map<String, VentaIntegraPropertiesDto> ventaIntegraProperties() {
    return ventaIntegraService;
  }

}
