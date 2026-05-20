package com.inditex.rrhh.icmclcwb;

import java.util.TimeZone;

import com.inditex.amigafwk.amiga.service.AmigaBootServiceApplication;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@AmigaBootServiceApplication
@ConfigurationPropertiesScan
public class Application {

  @PostConstruct
  void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
