package com.inditex.rrhh.icmclcwb.config.calculoincome;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.OrigenesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasOnlineApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.invoker.ApiClient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the calculo-income REST client.
 */
@Configuration
public class CalculoIncomeClientConfig {

  @AmigaRestClient(value = "calculo-income", beanName = "calculoIncomeClient")
  public RestClient calculoIncomeClient(final RestClientBuilder builder) {
    return builder.build();
  }

  @Bean(name = "calculoIncomeApiClient")
  public ApiClient calculoIncomeApiClient(@Qualifier("calculoIncomeClient") final RestClient restClient) {
    return new ApiClient(restClient).setBasePath(restClient.getBaseUrl());
  }

  @Bean(name = "tiendasOnlineCalculoIncomeApiClient")
  public TiendasOnlineApi tiendasOnlineCalculoIncomeApiClient(@Qualifier("calculoIncomeApiClient") final ApiClient apiClient) {
    return new TiendasOnlineApi(apiClient);
  }

  @Bean(name = "origenesCalculoIncomeApiClient")
  public OrigenesApi origenesCalculoIncomeApiClient(@Qualifier("calculoIncomeApiClient") final ApiClient apiClient) {
    return new OrigenesApi(apiClient);
  }

}
