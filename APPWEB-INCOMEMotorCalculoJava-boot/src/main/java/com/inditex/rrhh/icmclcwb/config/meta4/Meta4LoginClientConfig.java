package com.inditex.rrhh.icmclcwb.config.meta4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

@Configuration
public class Meta4LoginClientConfig extends Meta4ClientConfigAbstract<LoginService> {

    @Bean(name = "meta4LoginClient")
    @Override
    public LoginService init() {
        return super.build(LoginService.class);
    }

    @Value("${app.envars.meta4.login.server}")
    @Override
    protected void setServer(String server) {
        super.server = server;
    }

}