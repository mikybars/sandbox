package com.inditex.rrhh.icmclcwb.config.ptr.presencia;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.ptr.presencia.service")
public class PtrPresenciaClientPropertiesConfig {

  private Map<String, PtrPropertiesDto> presenciasService = new HashMap<>();

  private Map<String, PtrPropertiesDto> horasService = new HashMap<>();

  private String version;

  @Bean(name = "presenciasProperties")
  public Map<String, PtrPropertiesDto> ptrPresenciasProperties() {
    return presenciasService;
  }

  @Bean(name = "presenciasVersion")
  public String ptrPresenciasVersion() {
    return version;
  }

}
