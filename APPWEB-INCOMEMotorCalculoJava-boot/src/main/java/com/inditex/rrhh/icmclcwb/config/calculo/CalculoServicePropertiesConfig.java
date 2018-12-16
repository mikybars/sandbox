package com.inditex.rrhh.icmclcwb.config.calculo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.dto.CalculoPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.calculo.service")
public class CalculoServicePropertiesConfig {
      
    CalculoPropertiesDto gTAlgortimo;            

    @Bean
    public CalculoPropertiesDto gTAlgoritmoProperties() {
    	return gTAlgortimo;
    }
}