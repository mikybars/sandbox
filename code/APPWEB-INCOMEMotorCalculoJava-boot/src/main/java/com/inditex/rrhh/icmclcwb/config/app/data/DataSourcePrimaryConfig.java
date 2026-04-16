package com.inditex.rrhh.icmclcwb.config.app.data;

import com.inditex.amigafwk.data.core.jdbc.annotation.AmigaJdbcDatasource;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@ConditionalOnBooleanProperty(prefix = "app.envars.primary", name = "use-psql", havingValue = false, matchIfMissing = true)
public class DataSourcePrimaryConfig {

  @Primary
  @AmigaJdbcDatasource(value = "primary", beanName = "primaryDataSource")
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
        .persistenceUnit("primaryPersistenceUnit")
        .packages("com.inditex.rrhh.icmclcwb.model.primary")
        .properties(jpaProperties.getProperties())
        .jta(false)
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
