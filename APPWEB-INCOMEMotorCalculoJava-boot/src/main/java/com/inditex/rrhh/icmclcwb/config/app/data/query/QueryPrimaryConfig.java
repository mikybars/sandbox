package com.inditex.rrhh.icmclcwb.config.app.data.query;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

@Configuration
public class QueryPrimaryConfig {
    
    @Value("${app.envars.calculo.precision}")
    private String precision;
    
    @Value("${app.envars.calculo.cast}")
    private boolean cast;
    
    private static final String PRECISION_CONSTANT_INICIO = "/*PRECISION_INI*/";
    private static final String PRECISION_CONSTANT_FIN = "/*PRECISION_FIN*/";
    private static final String PRECISION_TYPE = "/*PRECISION*/";
    private static final String CAST_INI = "CAST(";
    private static final String CAST_END = ")";

    @Bean(name = "primaryQuery")
    public PropertiesFactoryBean primaryQuery(ResourceLoader resourceLoader) throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                .getResources("classpath*:/query/primary/*.xml");
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        return bean;
    }
    
    @Bean(name = "calculoPrimaryQuery")
    public PropertiesFactoryBean calculoPrimaryQuery(ResourceLoader resourceLoader) throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                .getResources("classpath*:/query/primary/calculo/*.xml");
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        bean.afterPropertiesSet();
        Properties props = bean.getObject();
        
        for(Object key: props.keySet()){
            String prop = (String) props.get(key);
            if (cast) {
                prop = prop.replace(PRECISION_CONSTANT_INICIO, CAST_INI);
                prop = prop.replace(PRECISION_CONSTANT_FIN, CAST_END);
                prop = prop.replace(PRECISION_TYPE, precision);
            }else {
                prop = prop.replace(PRECISION_CONSTANT_INICIO, StringUtils.EMPTY);
                prop = prop.replace(PRECISION_CONSTANT_FIN, StringUtils.EMPTY);
                prop = prop.replace(PRECISION_TYPE, StringUtils.EMPTY);
            }
            props.put(key, prop);
        }
        
        bean.setLocalOverride(true);
        bean.setProperties(props);
        bean.afterPropertiesSet();

        return bean;
    }

}
