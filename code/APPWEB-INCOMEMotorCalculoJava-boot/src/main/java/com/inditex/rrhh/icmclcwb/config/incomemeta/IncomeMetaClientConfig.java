package com.inditex.rrhh.icmclcwb.config.incomemeta;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.invoker.ApiClient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IncomeMetaClientConfig {

  @Bean(name = "incomeMetaClient")
  @ConfigurationProperties(prefix = "amiga.common.rest.client.incomemeta")
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

}
