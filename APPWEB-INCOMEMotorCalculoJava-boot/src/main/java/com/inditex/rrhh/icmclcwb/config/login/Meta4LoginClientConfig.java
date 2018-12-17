package com.inditex.rrhh.icmclcwb.config.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientAbstract;

@Configuration
public class Meta4LoginClientConfig extends Meta4ClientAbstract<LoginService> {

    @Value("${app.envars.meta4.login.server}")
    @Override
    protected void setServer(String server) {
        super.server = server;
    }

    @Bean(name = "meta4LoginClientFactory")
    @Override
    protected Meta4ClientAbstract<LoginService> factory() {
        return this;
    }

}
