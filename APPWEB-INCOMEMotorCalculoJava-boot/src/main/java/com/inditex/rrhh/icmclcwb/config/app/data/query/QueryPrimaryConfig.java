package com.inditex.rrhh.icmclcwb.config.app.data.query;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

@Configuration
public class QueryPrimaryConfig {

    @Bean(name = "primaryQuery")
    public PropertiesFactoryBean primaryQuery(ResourceLoader resourceLoader) throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                .getResources("classpath*:/query/primary/*.xml");
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        return bean;
    }

}
