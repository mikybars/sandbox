package com.inditex.rrhh.icmclcwb.config.ventaintegra;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.venta-integra.service")
public class VentaIntegraClientPropertiesConfig {

  private VentaIntegraPropertiesDto ventaIntegraService;

  @Bean(name = "ventaIntegraProperties")
  public VentaIntegraPropertiesDto ventaIntegraProperties() {
    return this.ventaIntegraService;
  }

}
