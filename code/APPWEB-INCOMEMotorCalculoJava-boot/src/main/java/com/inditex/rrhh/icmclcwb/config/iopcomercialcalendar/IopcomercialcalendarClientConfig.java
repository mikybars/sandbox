package com.inditex.rrhh.icmclcwb.config.iopcomercialcalendar;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.common.rest.client.annotation.AmigaRestClient;
import com.inditex.amigafwk.common.rest.client.builder.RestClientBuilder;

import org.springframework.context.annotation.Configuration;

@Configuration
public class IopcomercialcalendarClientConfig {
  @AmigaRestClient(value = "iopcomercialcalendar", beanName = "iopcomercialcalendarClient")
  public RestClient iopcomercialcalendarClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
