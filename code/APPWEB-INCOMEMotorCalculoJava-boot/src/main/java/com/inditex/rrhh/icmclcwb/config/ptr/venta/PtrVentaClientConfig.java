package com.inditex.rrhh.icmclcwb.config.ptr.venta;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PtrVentaClientConfig {

  @AmigaRestClient(value = "ptr-venta", beanName = "ptrVentaClient")
  public RestClient ptrVentaClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
