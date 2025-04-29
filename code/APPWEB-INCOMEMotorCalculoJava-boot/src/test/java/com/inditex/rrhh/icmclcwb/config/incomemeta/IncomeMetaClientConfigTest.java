package com.inditex.rrhh.icmclcwb.config.incomemeta;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;
import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.PeriodoApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiendaApi;
import com.inditex.rrhh.icmclcwb.rest.client.api.TiposventachallengeApi;
import com.inditex.rrhh.icmclcwb.rest.client.invoker.ApiClient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class IncomeMetaClientConfigTest {

  @Mock
  private RestClientBuilder restClientBuilder;

  @InjectMocks
  private IncomeMetaClientConfig incomeMetaClientConfig;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void incomeMetaClientTest() {
    final RestClient restClient = mock(RestClient.class);
    when(this.restClientBuilder.build()).thenReturn(restClient);

    final RestClient result = this.incomeMetaClientConfig.incomeMetaClient(this.restClientBuilder);
    assertNotNull(result);
  }

  @Test
  void incomeMetaApiClientTest() {
    final RestClient restClient = mock(RestClient.class);
    final ApiClient apiClient = this.incomeMetaClientConfig.incomeMetaApiClient(restClient);
    assertNotNull(apiClient);
  }

  @Test
  void externosIncomeMetaApiClientTest() {
    final ApiClient apiClient = mock(ApiClient.class);
    final ExternosApi externosApi = this.incomeMetaClientConfig.externosIncomeMetaApiClient(apiClient);
    assertNotNull(externosApi);
  }

  @Test
  void tiposventaChallengeApiTest() {
    final ApiClient apiClient = mock(ApiClient.class);
    final TiposventachallengeApi tiposventachallengeApi = this.incomeMetaClientConfig.tiposventachallengeIncomeMetaApiClient(apiClient);
    assertNotNull(tiposventachallengeApi);
  }

  @Test
  void tiendaApiTest() {
    final ApiClient apiClient = mock(ApiClient.class);
    final TiendaApi tiendaApi = this.incomeMetaClientConfig.tiendaIncomeMetaApiClient(apiClient);
    assertNotNull(tiendaApi);
  }

  @Test
  void periodoApiTest() {
    final ApiClient apiClient = mock(ApiClient.class);
    final PeriodoApi periodoApi = this.incomeMetaClientConfig.periodoIncomeMetaApiClient(apiClient);
    assertNotNull(periodoApi);
  }
}
