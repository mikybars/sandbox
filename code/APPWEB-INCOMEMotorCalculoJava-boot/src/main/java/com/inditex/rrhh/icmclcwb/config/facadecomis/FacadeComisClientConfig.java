package com.inditex.rrhh.icmclcwb.config.facadecomis;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.CarenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.ComisionesManualesApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.CondicionesApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.IncidenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.MotivosDesplazamientoApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.PersonasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.PresenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.ValidacionesApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.invoker.ApiClient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacadeComisClientConfig {

  @AmigaRestClient(value = "incomecomis", beanName = "incomeComisClient")
  public RestClient incomeComisClient(final RestClientBuilder builder) {
    return builder.build();
  }

  @Bean(name = "incomeComisApiClient")
  public ApiClient incomeComisApiClient(@Qualifier("incomeComisClient") final RestClient restClient) {
    return new ApiClient(restClient).setBasePath(restClient.getBaseUrl());
  }

  @Bean(name = "carenciasComisApiClient")
  public CarenciasApi carenciasComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new CarenciasApi(apiClient);
  }

  @Bean(name = "comisionesManualesComisApiClient")
  public ComisionesManualesApi comisionesManualesComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new ComisionesManualesApi(apiClient);
  }

  @Bean(name = "condicionesComisApiClient")
  public CondicionesApi condicionesComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new CondicionesApi(apiClient);
  }

  @Bean(name = "externosComisApiClient")
  public ExternosApi externosComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new ExternosApi(apiClient);
  }

  @Bean(name = "incidenciasComisApiClient")
  public IncidenciasApi incidenciasComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new IncidenciasApi(apiClient);
  }

  @Bean(name = "motivosDesplazamientoComisApiClient")
  public MotivosDesplazamientoApi motivosDesplazamientoComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new MotivosDesplazamientoApi(apiClient);
  }

  @Bean(name = "personasComisApiClient")
  public PersonasApi personasComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new PersonasApi(apiClient);
  }

  @Bean(name = "presenciasComisApiClient")
  public PresenciasApi presenciasComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new PresenciasApi(apiClient);
  }

  @Bean(name = "validacionesComisApiClient")
  public ValidacionesApi validacionesComisApiClient(@Qualifier("incomeComisApiClient") final ApiClient apiClient) {
    return new ValidacionesApi(apiClient);
  }

}
