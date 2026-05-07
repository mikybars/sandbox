package com.inditex.rrhh.icmclcwb.config.app.data;

import com.inditex.amigafwk.data.core.jdbc.annotation.AmigaJdbcDatasource;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;
import com.inditex.rrhh.icmclcwb.model.app.annotation.NuevoMotor;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@NuevoMotor
public class DataSourcePrimaryPsqlConfig {

  @Primary
  @AmigaJdbcDatasource(value = "primary-psql", beanName = "primaryDataSource")
  public DataSource primaryDataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @Bean(name = "primaryEntityManagerFactory")
  @Primary
  public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
      final EntityManagerFactoryBuilder entityManagerFactoryBuilder,
      final JpaProperties jpaProperties,
      @Qualifier("primaryDataSource") final DataSource dataSource) {
    return entityManagerFactoryBuilder.dataSource(dataSource)
        .properties(jpaProperties.getProperties())
        .persistenceUnit("primaryPersistenceUnit")
        .jta(false)
        .packages("com.inditex.rrhh.icmclcwb.model.primary")
        .build();
  }

  @Bean(name = "primaryJdbcTemplate")
  @Primary
  public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") final DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean(name = "primaryNamedParameterJdbcTemplate")
  @Primary
  public NamedParameterJdbcTemplate primaryNamedParameterJdbcTemplate(
      @Qualifier("primaryJdbcTemplate") final JdbcTemplate jdbcTemplate) {
    return new NamedParameterJdbcTemplate(jdbcTemplate);
  }
}
