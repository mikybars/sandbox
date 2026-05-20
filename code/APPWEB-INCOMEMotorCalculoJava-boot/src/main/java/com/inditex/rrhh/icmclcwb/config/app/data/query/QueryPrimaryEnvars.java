package com.inditex.rrhh.icmclcwb.config.app.data.query;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.envars")
public record QueryPrimaryEnvars(CalculoEnvars calculo, ProcesoEnvars proceso) {

  public record CalculoEnvars(boolean cast, boolean round, String precision, String decimal) {
  }

  public record ProcesoEnvars(boolean cast, boolean round, String precision, String decimal) {
  }

}
