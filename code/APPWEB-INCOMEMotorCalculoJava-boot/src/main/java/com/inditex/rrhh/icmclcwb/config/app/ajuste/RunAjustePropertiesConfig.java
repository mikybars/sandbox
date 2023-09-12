package com.inditex.rrhh.icmclcwb.config.app.ajuste;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea.ajustar")
public class RunAjustePropertiesConfig {

  private RunAjustePropertiesDto algoritmo;

  @Bean(name = "runAjusteProperties")
  public RunAjustePropertiesDto config() {
    return algoritmo;
  }

}
