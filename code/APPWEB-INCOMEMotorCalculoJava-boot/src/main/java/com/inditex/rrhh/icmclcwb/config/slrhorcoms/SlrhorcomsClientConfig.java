package com.inditex.rrhh.icmclcwb.config.slrhorcoms;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.common.rest.client.builder.RestClientBuilder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlrhorcomsClientConfig {

  @Bean(name = "slrhorcomsClient")
  @ConfigurationProperties(prefix = "amiga.common.rest.client.slrhorcoms")
  public RestClient slrhorcomsClient(final RestClientBuilder builder) {
    return builder.build();
  }

}
