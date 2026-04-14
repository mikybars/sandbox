package com.inditex.rrhh.icmclcwb.config.app.data;

import com.inditex.amigafwk.data.core.jdbc.annotation.AmigaJdbcDatasource;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;
import com.inditex.amigafwk.data.jpa.annotations.AmigaEnableJpaRepositories;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@AmigaEnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", basePackages = {
    "com.inditex.rrhh.icmclcwb.model.primary"})
public class DataSourcePrimaryPsqlConfig {

  @Primary
  @AmigaJdbcDatasource(value = "primary-psql", beanName = "primaryDataSource")
  @ConditionalOnBooleanProperty(prefix = "app.envars.primary", name = "use-psql")
  public DataSource primaryDataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

}
