package com.inditex.rrhh.icmclcwb.config.slrhorcoms;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SlrhorcomsClientConfig {

  @AmigaRestClient(value = "slrhorcoms", beanName = "slrhorcomsClient")
  public RestClient slrhorcomsClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
