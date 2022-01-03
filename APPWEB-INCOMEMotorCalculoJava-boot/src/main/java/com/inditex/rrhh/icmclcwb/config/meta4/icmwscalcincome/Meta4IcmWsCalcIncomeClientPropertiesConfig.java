package com.inditex.rrhh.icmclcwb.config.meta4.icmwscalcincome;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.meta4.icmwscalcincome")
public class Meta4IcmWsCalcIncomeClientPropertiesConfig {

  private Map<String, Meta4PropertiesDto> service = new HashMap<>();

  @Bean(name = "meta4Properties")
  public Map<String, Meta4PropertiesDto> meta4Properties() {
    return service;
  }

}
