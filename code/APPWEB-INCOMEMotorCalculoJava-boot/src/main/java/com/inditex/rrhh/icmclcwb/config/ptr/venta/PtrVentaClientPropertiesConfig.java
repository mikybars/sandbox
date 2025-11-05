package com.inditex.rrhh.icmclcwb.config.ptr.venta;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.ptr.venta.service")
public class PtrVentaClientPropertiesConfig {

  private Map<String, PtrPropertiesDto> ventaGeneral = new HashMap<>();

  private Map<String, PtrPropertiesDto> ventaEmpleado = new HashMap<>();

  private Map<String, PtrPropertiesDto> ventaEcommerce = new HashMap<>();

  private Map<String, PtrPropertiesDto> acumuladoVentaImporte = new HashMap<>();

  private String version;

  @Bean(name = "ventaGeneralProperties")
  public Map<String, PtrPropertiesDto> ptrVentaGeneralProperties() {
    return this.ventaGeneral;
  }

  @Bean(name = "ventaEmpleadoProperties")
  public Map<String, PtrPropertiesDto> ptrVentaEmpleadoProperties() {
    return this.ventaEmpleado;
  }

  @Bean(name = "ventaEcommerceProperties")
  public Map<String, PtrPropertiesDto> ptrVentaEcommerceProperties() {
    return this.ventaEcommerce;
  }

  @Bean(name = "acumuladoVentaImporteProperties")
  public Map<String, PtrPropertiesDto> ptrAcumuladoVentaImporteProperties() {
    return this.acumuladoVentaImporte;
  }

  @Bean(name = "ventaVersion")
  public String ptrVentaVersion() {
    return this.version;
  }

}
