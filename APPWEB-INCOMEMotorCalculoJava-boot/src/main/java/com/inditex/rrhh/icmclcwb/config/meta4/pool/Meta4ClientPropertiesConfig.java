package com.inditex.rrhh.icmclcwb.config.meta4.pool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.meta4")
public class Meta4ClientPropertiesConfig {

    private Meta4ClientConfigProperties config;

    @Bean(name = "meta4ClientConfigProperties")
    public Meta4ClientConfigProperties meta4ClientConfigProperties() {
        return config;
    }

}
