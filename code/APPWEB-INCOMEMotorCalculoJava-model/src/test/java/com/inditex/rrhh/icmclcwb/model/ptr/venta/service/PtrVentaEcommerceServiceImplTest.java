package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PtrVentaEcommerceServiceImplTest {
    @Mock
    private RestClient ptrVentaClient;

    @Mock
    private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

    @InjectMocks
    private PtrVentaEcommerceServiceImpl ptrVentaEcommerceService;

    @BeforeEach
    public void setup() {
        final PtrPropertiesDto properties = new PtrPropertiesDto();
        properties.setEndpoint("");
        when(this.ventaEcommerceProperties.get(any(String.class))).thenReturn(properties);
    }

    private <T extends Object> ResponseEntity<T> mockResponse(final T body) {
        final ResponseEntity<T> response = mock(ResponseEntity.class);
        when(response.getStatusCode()).thenReturn(HttpStatus.OK);
        when(response.getBody()).thenReturn(body);
        return response;
    }

 /* @Test
  void ventaOnlineiPodTest() {
    final PtrVentaOnlineIpodResponseDto result = PtrVentaOnlineIpodResponseDto
        .builder()
        .ventaOnlineiPod(new ArrayList<>())
        .build();
    final ResponseEntity<PtrVentaOnlineIpodResponseDto> response = this.mockResponse(result);

    when(this.ptrVentaClient.postForEntity(any(String.class), any(PtrVentaOnlineIpodRequestDto.class),
        eq(PtrVentaOnlineIpodResponseDto.class))).thenReturn(response);

    assertEquals(result, this.ptrVentaEcommerceService.ventaOnlineiPod(new PtrVentaOnlineIpodRequestDto()));
  }*/
}
