package com.inditex.rrhh.icmclcwb.config.app.data;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

@Configuration
public class JdbcQueriesConfig {

    @Bean(name="primaryXmlQueries")
    public static PropertiesFactoryBean primaryXmlQueries(ResourceLoader resourceLoader) throws IOException {
        PropertiesFactoryBean  bean = new PropertiesFactoryBean ();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:/primary-xml-queries/*.xml");
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        return bean;
    }
    
    @Bean(name="secondaryXmlQueries")
    public static PropertiesFactoryBean secondaryXmlQueries(ResourceLoader resourceLoader) throws IOException {
        PropertiesFactoryBean  bean = new PropertiesFactoryBean ();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:/secondary-xml-queries/*.xml");
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        return bean;
    }
}
