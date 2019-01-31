package com.inditex.rrhh.icmclcwb.config.app.trabajo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.CalculoPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.calculo.service")
public class CalculoServicePropertiesConfig {
      
    CalculoPropertiesDto getGTAlgoritmoProperties;            

    @Bean(name = "calculoGTPropertiesDto")
    public CalculoPropertiesDto getGTAlgoritmoProperties() {
    	return getGTAlgoritmoProperties;
    }
}