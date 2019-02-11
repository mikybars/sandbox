package com.inditex.rrhh.icmclcwb.config.app.trabajo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.AlgoritmoPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.trabajo.calcular.algoritmo")
public class AlgoritmoPropertiesConfig {
      
    private AlgoritmoPropertiesDto getConfig;

    @Bean(name = "algoritmoProperties")
    public AlgoritmoPropertiesDto getConfig() {
    	return getConfig;
    }
}