package com.inditex.rrhh.icmclcwb.config.app.postprocesar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.postprocesar.properties.dto.RunPostProcesarPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea.post-procesar")
public class RunPostProcesarPropertiesConfig {

    private RunPostProcesarPropertiesDto config;
    
    @Bean(name = "runPostProcesarProperties")
    public RunPostProcesarPropertiesDto config() {
        return config;
    }
    
}