package com.inditex.rrhh.icmclcwb.config.app.calcular;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.AlgoritmoPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea.calcular.algoritmo")
public class AlgoritmoPropertiesConfig {

    private AlgoritmoPropertiesDto config;
    
    @Bean(name = "algoritmoProperties")
    public AlgoritmoPropertiesDto config() {
        return config;
    }
    
}