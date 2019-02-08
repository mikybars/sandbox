package com.inditex.rrhh.icmclcwb.config.ptr.venta;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.ptr.venta")
public class PtrVentaClientPropertiesConfig {

    Map<String, PtrPropertiesDto> service = new HashMap<>();
    
    @Bean(name = "ptrProps")
    public Map<String, PtrPropertiesDto> getPtrProps() {
        return service;
    }

}