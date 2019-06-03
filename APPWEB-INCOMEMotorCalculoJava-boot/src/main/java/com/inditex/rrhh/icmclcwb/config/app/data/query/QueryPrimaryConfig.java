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

    @Value("${app.envars.calculo.cast}")
    private boolean castCalculo;

    @Value("AS ${app.envars.calculo.precision})")
    private String precisionCalculo;

    @Value("${app.envars.proceso.cast}")
    private boolean castProceso;

    @Value("${app.envars.proceso.precision}")
    private String precisionProceso;

    private static final String RESOURCE_COMMON = "classpath*:/query/primary/*.xml";
    private static final String RESOURCE_CALCULO = "classpath*:/query/primary/calculo/*.xml";
    private static final String CAST_REPLACE_INICIO = "/*(*/";
    private static final String CAST_REPLACE_FIN = "/*)*/";
    private static final String CAST_RESULT_INICIO = "CAST(";
    private static final String CAST_RESULT_FIN = "AS ${precision})";
    private static final String CAST_VAR_PRECISION = "${precision}";

    @Bean(name = "primaryQuery")
    public PropertiesFactoryBean primaryQuery(final ResourceLoader resourceLoader) throws IOException {
        return loadBean(resourceLoader, RESOURCE_COMMON, precisionProceso, castProceso);
    }

    @Bean(name = "calculoPrimaryQuery")
    public PropertiesFactoryBean calculoPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
        return loadBean(resourceLoader, RESOURCE_CALCULO, precisionCalculo, castCalculo);
    }

    private PropertiesFactoryBean loadBean(final ResourceLoader resourceLoader, final String resource,
            final String precision, final boolean cast) throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(resource);
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        bean.afterPropertiesSet();
        Properties props = bean.getObject();
        String castInicio = StringUtils.EMPTY;
        String castFin = StringUtils.EMPTY;
        if (cast) {
            castInicio = CAST_RESULT_INICIO;
            castFin = CAST_RESULT_FIN.replace(CAST_VAR_PRECISION, precision);
        }
        for (Object key : props.keySet()) {
            String prop = (String) props.get(key);
            prop = prop.replace(CAST_REPLACE_INICIO, castInicio);
            prop = prop.replace(CAST_REPLACE_FIN, castFin);
            props.put(key, prop);
        }
        bean.setLocalOverride(true);
        bean.setProperties(props);
        bean.afterPropertiesSet();
        return bean;
    }

}
