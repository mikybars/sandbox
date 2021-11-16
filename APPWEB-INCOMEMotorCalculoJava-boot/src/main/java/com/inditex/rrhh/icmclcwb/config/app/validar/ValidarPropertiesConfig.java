package com.inditex.rrhh.icmclcwb.config.app.validar;

import com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto.ValidarPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea")
public class ValidarPropertiesConfig {

  private ValidarPropertiesDto validar;

  @Bean(name = "validarProperties")
  public ValidarPropertiesDto validar() {
    return validar;
  }

}
