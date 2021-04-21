package com.inditex.rrhh.icmclcwb;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;

import com.inditex.aqsw.framework.amiga.service.AmigaBootServiceApplication;

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
