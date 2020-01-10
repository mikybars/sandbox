package com.inditex.rrhh.icmclcwb.config.app.postprocesar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.postprocesar.properties.dto.RunAjustePropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea.ajuste")
public class RunAjustePropertiesConfig {

    private RunAjustePropertiesDto config;
    
    @Bean(name = "runAjusteProperties")
    public RunAjustePropertiesDto config() {
        return config;
    }
    
}