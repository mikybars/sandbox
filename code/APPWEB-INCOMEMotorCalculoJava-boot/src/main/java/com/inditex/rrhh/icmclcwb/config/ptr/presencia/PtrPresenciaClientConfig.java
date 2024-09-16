package com.inditex.rrhh.icmclcwb.config.ptr.presencia;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PtrPresenciaClientConfig {

  @AmigaRestClient(value = "ptr-presencia", beanName = "ptrPresenciaClient")
  public RestClient ptrPresenciaClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
