package com.inditex.rrhh.icmclcwb.config.app.prevalidar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.prevalidacion")
public class PrevalidarPropertiesConfig {
    
    private PrevalidarPropertiesDto baja;
    
    private PrevalidarPropertiesDto carencia;
    
    private PrevalidarPropertiesDto motivos;
    
    private PrevalidarPropertiesDto fechas;
    
    private PrevalidarPropertiesDto presencia;
    
    private PrevalidarPropertiesDto resalta;
    
    private PrevalidarPropertiesDto desplazamiento;
    
    private PrevalidarPropertiesDto historico;

    @Bean(name = "bajaProperties")
    public PrevalidarPropertiesDto baja() {
        return baja;
    }
    
    @Bean(name = "motivosProperties")
    public PrevalidarPropertiesDto motivos() {
        return motivos;
    }
    
    @Bean(name = "carenciaProperties")
    public PrevalidarPropertiesDto carencia() {
        return carencia;
    }
    
    @Bean(name = "fechasProperties")
    public PrevalidarPropertiesDto fechas() {
        return fechas;
    }
    
    @Bean(name = "presenciaProperties")
    public PrevalidarPropertiesDto presencia() {
        return presencia;
    }
    
    @Bean(name = "resaltaProperties")
    public PrevalidarPropertiesDto resalta() {
        return resalta;
    }
    
    @Bean(name = "desplazamientoProperties")
    public PrevalidarPropertiesDto desplazamiento() {
        return desplazamiento;
    }
    
    @Bean(name = "historicoProperties")
    public PrevalidarPropertiesDto historico() {
        return historico;
    }

}
