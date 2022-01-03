package com.inditex.rrhh.icmclcwb.config.app.recolectar;

import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea")
public class RecolectarPropertiesConfig {

  private RecolectarPropertiesDto recolectar;

  @Bean(name = "recolectarProperties")
  public RecolectarPropertiesDto recolectar() {
    return recolectar;
  }

}
