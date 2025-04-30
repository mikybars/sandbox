package com.inditex.rrhh.icmclcwb.config.incomemeta;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclcwb.rest.client.api.EmpleadosApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.PeriodoApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.PresupuestosApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiendaApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiposventachallengeApi;
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

  @Bean(name = "externosIncomeMetaApiClient")
  public ExternosApi externosIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new ExternosApi(apiClient);
  }

  @Bean(name = "empleadosIncomeMetaApiClient")
  public EmpleadosApi empleadosIcomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new EmpleadosApi(apiClient);
  }

  @Bean(name = "tiposventachallengeIncomeMetaApiClient")
  public TiposventachallengeApi tiposventachallengeIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new TiposventachallengeApi(apiClient);
  }

  @Bean(name = "tiendaIncomeMetaApiClient")
  public TiendaApi tiendaIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new TiendaApi(apiClient);
  }

  @Bean(name = "presupuestosIncomeMetaApiClient")
  public PresupuestosApi presupuestosIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new PresupuestosApi(apiClient);
  }

  @Bean(name = "periodoIncomeMetaApiClient")
  public PeriodoApi periodoIncomeMetaApiClient(@Qualifier("incomeMetaApiClient") final ApiClient apiClient) {
    return new PeriodoApi(apiClient);
  }

}
