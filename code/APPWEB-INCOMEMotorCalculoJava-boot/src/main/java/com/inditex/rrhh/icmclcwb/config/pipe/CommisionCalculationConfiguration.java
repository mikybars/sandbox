package com.inditex.rrhh.icmclcwb.config.pipe;

import com.inditex.aqsw.pipe.TracingResolverSessionId;
import com.inditex.aqsw.pipe.v1.MetadataBuilder;
import com.inditex.aqsw.pipe.v1.MetadataBuilderImpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class CommisionCalculationConfiguration {
  public static final String MESSAGE_METADATA_DOMAIN = "rhcompensa";

  public static final String MESSAGE_METADATA_VERSION = "1";

  @Bean
  public MetadataBuilder metadataBuilder(
      @Qualifier("amigaTracingResolverSessionId") final TracingResolverSessionId amigaTracingResolverSessionId) {
    return new MetadataBuilderImpl(MESSAGE_METADATA_DOMAIN, MESSAGE_METADATA_VERSION,
        amigaTracingResolverSessionId);
  }
}
