package com.inditex.rrhh.icmclcwb.config.iopcomercialcalendar;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.IopcomercialcalendarPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.iopcomercialcalendar.service")
public class IopcomercialcalendarClientPropertiesConfig {

  private Map<String, IopcomercialcalendarPropertiesDto> iopcomercialcalendarService = new HashMap<>();

  @Bean(name = "iopcomercialcalendarProperties")
  public Map<String, IopcomercialcalendarPropertiesDto> iopcomercialcalendarProperties() {
    return this.iopcomercialcalendarService;
  }

}
