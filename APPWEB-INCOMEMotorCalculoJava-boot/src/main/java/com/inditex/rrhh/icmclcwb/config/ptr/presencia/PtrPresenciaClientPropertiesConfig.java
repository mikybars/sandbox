package com.inditex.rrhh.icmclcwb.config.ptr.presencia;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.ptr.presencia.service")
public class PtrPresenciaClientPropertiesConfig {

    PtrPropertiesDto getPresenciasTotalTiendaSeccion;

    PtrPropertiesDto getPresenciasDetalle;
    
    PtrPropertiesDto getTiposHoras;

    @Bean(name = "presenciasTotalTiendaSeccionDto")
    public PtrPropertiesDto getPresenciasTotalTiendaSeccion() {
        return getPresenciasTotalTiendaSeccion;
    }

    @Bean(name = "presenciasDetalleDto")
    public PtrPropertiesDto getPresenciasDetalle() {
        return getPresenciasDetalle;
    }

    @Bean(name = "tiposHorasDto")
    public PtrPropertiesDto getTiposHoras() {
    	return getTiposHoras;
    }
}