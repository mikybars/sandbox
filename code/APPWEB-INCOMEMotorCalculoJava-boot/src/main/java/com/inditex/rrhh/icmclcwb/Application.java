package com.inditex.rrhh.icmclcwb;

import java.util.TimeZone;

import com.inditex.aqsw.framework.amiga.service.AmigaBootServiceApplication;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;

@AmigaBootServiceApplication
public class Application {

  @PostConstruct
  void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
