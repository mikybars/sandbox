package com.inditex.rrhh.icmclcwb.config.app.data.query;

import static com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPropertiesLoader.loadBean;

import java.io.IOException;

import com.inditex.rrhh.icmclcwb.model.app.annotation.NuevoMotor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
@NuevoMotor
@RequiredArgsConstructor
public class QueryPrimaryPsqlConfig {

  private static final String RESOURCE_COMMON_PSQL = "classpath*:/query/primary/*-psql.xml";

  private static final String RESOURCE_CALCULO_PSQL = "classpath*:/query/primary/calculo/*-psql.xml";

  private static final String RESOURCE_LIMPIEZA_PSQL = "classpath*:/query/primary/limpieza/*-psql.xml";

  private static final String RESOURCE_COMIS = "classpath*:/query/comis/*.xml";

  private static final String RESOURCE_PIPE_PSQL = "classpath*:/query/pipe/*-psql.xml";

  private static final String RESOURCE_PTR = "classpath*:/query/ptr/*.xml";

  private static final String RESOURCE_META4 = "classpath*:/query/meta4/*.xml";

  private static final String RESOURCE_SIMULACION_PSQL = "classpath*:/query/primary/simulacion/*-psql.xml";

  private final QueryPrimaryEnvars envars;

  @Bean(name = "primaryQuery")
  public PropertiesFactoryBean primaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_COMMON_PSQL,
        envars.proceso().precision(), envars.proceso().decimal(), envars.proceso().cast(), envars.proceso().round());
  }

  @Bean(name = "calculoPrimaryQuery")
  public PropertiesFactoryBean calculoPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_CALCULO_PSQL,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

  @Bean(name = "limpiezaPrimaryQuery")
  public PropertiesFactoryBean limpiezaPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_LIMPIEZA_PSQL,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

  @Bean(name = "comisPrimaryQuery")
  public PropertiesFactoryBean comisPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_COMIS,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

  @Bean(name = "pipePrimaryQuery")
  public PropertiesFactoryBean pipePrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_PIPE_PSQL,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

  @Bean(name = "ptrPrimaryQuery")
  public PropertiesFactoryBean ptrPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_PTR,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

  @Bean(name = "meta4PrimaryQuery")
  public PropertiesFactoryBean meta4PrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_META4,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

  @Bean(name = "simulacionPrimaryQuery")
  public PropertiesFactoryBean simulacionPrimaryQuery(final ResourceLoader resourceLoader) throws IOException {
    return loadBean(resourceLoader, RESOURCE_SIMULACION_PSQL,
        envars.calculo().precision(), envars.calculo().decimal(), envars.calculo().cast(), envars.calculo().round());
  }

}
