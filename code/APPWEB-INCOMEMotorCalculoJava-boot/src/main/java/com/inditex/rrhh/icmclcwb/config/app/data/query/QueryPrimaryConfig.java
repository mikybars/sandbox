package com.inditex.rrhh.icmclcwb.config.app.data.query;

import java.io.IOException;
import java.util.Map.Entry;
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

  private static final String RESOURCE_COMMON = "classpath*:/query/primary/*.xml";

  private static final String RESOURCE_CALCULO = "classpath*:/query/primary/calculo/*.xml";

  private static final String RESOURCE_LIMPIEZA = "classpath*:/query/primary/limpieza/*.xml";

  private static final String RESOURCE_COMIS = "classpath*:/query/comis/*.xml";

  private static final String RESOURCE_PIPE = "classpath*:/query/pipe/*.xml";

  private static final String RESOURCE_PTR = "classpath*:/query/ptr/*.xml";

  private static final String RESOURCE_META4 = "classpath*:/query/meta4/*.xml";

  private static final String CAST_REPLACE_INICIO = "/*(*/";

  private static final String CAST_REPLACE_FIN = "/*)*/";

  private static final String CAST_REPLACE_ROUND_INICIO = "/*R(*/";

  private static final String CAST_REPLACE_ROUND_FIN = "/*)R*/";

  private static final String CAST_RESULT_INICIO = "CAST(";

  private static final String CAST_RESULT_ROUND_INICIO = "ROUND(";

  private static final String CAST_RESULT_ROUND_FIN = ", ${decimal} )";

  private static final String CAST_RESULT_FIN = " AS ${precision})";

  private static final String CAST_VAR_PRECISION = "${precision}";

  private static final String CAST_VAR_DECIMAL = "${decimal}";

  @Value("${app.envars.calculo.cast}")
  private boolean castCalculo;

  @Value("${app.envars.calculo.round}")
  private boolean roundCalculo;

  @Value("${app.envars.calculo.precision}")
  private String precisionCalculo;

  @Value("${app.envars.calculo.decimal}")
  private String decimalCalculo;

  @Value("${app.envars.proceso.cast}")
  private boolean castProceso;

  @Value("${app.envars.proceso.round}")
  private boolean roundProceso;

  @Value("${app.envars.proceso.precision}")
  private String precisionProceso;

  @Value("${app.envars.proceso.decimal}")
  private String decimalProceso;

  @Bean(name = "primaryQuery")
  public PropertiesFactoryBean primaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_COMMON, this.precisionProceso, this.decimalProceso, this.castProceso, this.roundProceso);
  }

  @Bean(name = "calculoPrimaryQuery")
  public PropertiesFactoryBean calculoPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_CALCULO, this.precisionCalculo, this.decimalCalculo, this.castCalculo, this.roundCalculo);
  }

  @Bean(name = "limpiezaPrimaryQuery")
  public PropertiesFactoryBean limpiezaPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_LIMPIEZA, this.precisionCalculo, this.decimalCalculo, this.castCalculo,
        this.roundCalculo);
  }

  @Bean(name = "comisPrimaryQuery")
  public PropertiesFactoryBean comisPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_COMIS, this.precisionCalculo, this.decimalCalculo, this.castCalculo, this.roundCalculo);
  }

  @Bean(name = "pipePrimaryQuery")
  public PropertiesFactoryBean pipePrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_PIPE, this.precisionCalculo, this.decimalCalculo, this.castCalculo, this.roundCalculo);
  }

  @Bean(name = "ptrPrimaryQuery")
  public PropertiesFactoryBean ptrPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_PTR, this.precisionCalculo, this.decimalCalculo, this.castCalculo, this.roundCalculo);
  }

  @Bean(name = "meta4PrimaryQuery")
  public PropertiesFactoryBean meta4PrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return this.loadBean(resourceLoader, RESOURCE_META4, this.precisionCalculo, this.decimalCalculo, this.castCalculo, this.roundCalculo);
  }

  private PropertiesFactoryBean loadBean(final ResourceLoader resourceLoader, final String resource,
      final String precision, final String decimal, final boolean cast, final boolean round) throws IOException {
    final PropertiesFactoryBean bean = new PropertiesFactoryBean();
    final Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
        .getResources(resource);
    bean.setLocations(resources);
    bean.setIgnoreResourceNotFound(true);
    bean.afterPropertiesSet();
    final Properties props = bean.getObject();
    String castInicio = StringUtils.EMPTY;
    String castFin = StringUtils.EMPTY;
    String roundInicio = StringUtils.EMPTY;
    String roundFin = StringUtils.EMPTY;

    if (cast) {
      castInicio = CAST_RESULT_INICIO;
      castFin = CAST_RESULT_FIN.replace(CAST_VAR_PRECISION, precision);
    }
    if (round) {
      roundInicio = CAST_RESULT_ROUND_INICIO;
      roundFin = CAST_RESULT_ROUND_FIN.replace(CAST_VAR_DECIMAL, decimal);
    }
    for (final Entry<Object, Object> entry : props.entrySet()) {
      String prop = (String) entry.getValue();
      prop = prop.replace(CAST_REPLACE_INICIO, castInicio);
      prop = prop.replace(CAST_REPLACE_FIN, castFin);
      prop = prop.replace(CAST_REPLACE_ROUND_INICIO, roundInicio);
      prop = prop.replace(CAST_REPLACE_ROUND_FIN, roundFin);
      props.put(entry.getKey(), prop);
    }
    bean.setLocalOverride(true);
    bean.setProperties(props);
    bean.afterPropertiesSet();
    return bean;
  }

}
