package com.inditex.rrhh.icmclcwb.config.app.prevalidar;

import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.prevalidacion")
public class PrevalidarPropertiesConfig {

  private PrevalidarPropertiesDto baja;

  private PrevalidarPropertiesDto carencia;

  private PrevalidarPropertiesDto fechas;

  private PrevalidarPropertiesDto resalta;

  private PrevalidarPropertiesDto desplazamiento;

  private PrevalidarPropertiesDto historico;

  private PrevalidarPropertiesDto primas;

  private PrevalidarPropertiesDto manual;

  private PrevalidarPropertiesDto personas;

  @Bean(name = "bajaProperties")
  public PrevalidarPropertiesDto baja() {
    return this.baja;
  }

  @Bean(name = "carenciaProperties")
  public PrevalidarPropertiesDto carencia() {
    return this.carencia;
  }

  @Bean(name = "fechasProperties")
  public PrevalidarPropertiesDto fechas() {
    return this.fechas;
  }

  @Bean(name = "resaltaProperties")
  public PrevalidarPropertiesDto resalta() {
    return this.resalta;
  }

  @Bean(name = "desplazamientoProperties")
  public PrevalidarPropertiesDto desplazamiento() {
    return this.desplazamiento;
  }

  @Bean(name = "historicoProperties")
  public PrevalidarPropertiesDto historico() {
    return this.historico;
  }

  @Bean(name = "primasProperties")
  public PrevalidarPropertiesDto primas() {
    return this.primas;
  }

  @Bean(name = "comisionManualProperties")
  public PrevalidarPropertiesDto manual() {
    return this.manual;
  }

  @Bean(name = "personasProperties")
  public PrevalidarPropertiesDto personas() {
    return this.personas;
  }

}
