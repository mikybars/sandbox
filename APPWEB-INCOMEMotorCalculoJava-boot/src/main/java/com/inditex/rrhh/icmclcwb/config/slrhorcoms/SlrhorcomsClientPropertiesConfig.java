package com.inditex.rrhh.icmclcwb.config.slrhorcoms;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.slrhorcoms.service")
public class SlrhorcomsClientPropertiesConfig {

  private Map<String, SlrhorcomsPropertiesDto> slrhorcomsService = new HashMap<>();

  @Bean(name = "slrhorcomsProperties")
  public Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties() {
    return this.slrhorcomsService;
  }

}
