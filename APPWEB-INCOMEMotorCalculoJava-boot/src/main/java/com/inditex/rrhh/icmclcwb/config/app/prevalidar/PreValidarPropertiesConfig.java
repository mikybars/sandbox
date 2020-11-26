package com.inditex.rrhh.icmclcwb.config.app.prevalidar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PreValidarPropertiesDto;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.tarea")
public class PreValidarPropertiesConfig {

    private PreValidarPropertiesDto prevalidar;

    @Bean(name = "preValidarProperties")
    public PreValidarPropertiesDto validar() {
        return prevalidar;
    }

}
