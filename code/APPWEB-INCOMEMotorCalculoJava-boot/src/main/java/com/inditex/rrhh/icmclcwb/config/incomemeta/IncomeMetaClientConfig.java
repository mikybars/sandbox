package com.inditex.rrhh.icmclcwb.config.incomemeta;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclcwb.rest.client.api.ConfiguracionApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.EmpleadoApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiendaApi;
import com.inditex.rrhh.icmclcwb.rest.client.invoker.ApiClient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IncomeMetaClientConfig {

  @AmigaRestClient(value = "incomemeta", beanName = "incomeMetaClient")
  public RestClient incomeMetaClient(final RestClientBuilder builder) {
    return builder.build();
  }

  @Bean(name = "incomeMetaApiClient")
  public ApiClient incomeMetaApiClient(@Qualifier("incomeMetaClient") final RestClient restClient) {
    return new ApiClient(restClient).setBasePath(restClient.getBaseUrl());
  }

  @Bean(name = "empleadoIncomeMetaApiClient")
  public EmpleadoApi empleadoIcomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new EmpleadoApi(apiClient);
  }

  @Bean(name = "tiendaIncomeMetaApiClient")
  public TiendaApi tiendaIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new TiendaApi(apiClient);
  }

  @Bean(name = "configuracionIncomeMetaApiClient")
  public ConfiguracionApi configuracionIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new ConfiguracionApi(apiClient);
  }

}
