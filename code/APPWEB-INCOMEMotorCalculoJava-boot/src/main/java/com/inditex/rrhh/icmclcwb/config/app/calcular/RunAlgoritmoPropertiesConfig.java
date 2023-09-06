package com.inditex.rrhh.icmclcwb.config.app.calcular;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea.calcular")
public class RunAlgoritmoPropertiesConfig {

  private RunAlgoritmoPropertiesDto algoritmo;

  @Bean(name = "runAlgoritmoProperties")
  public RunAlgoritmoPropertiesDto config() {
    return this.algoritmo;
  }

}
