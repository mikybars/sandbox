package com.inditex.rrhh.icmclcwb.config.app.data;

import com.inditex.amigafwk.data.core.jdbc.annotation.AmigaJdbcDatasource;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;
import com.inditex.rrhh.icmclcwb.model.app.annotation.AntiguoMotor;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@AntiguoMotor
public class DataSourcePtrConfig {

  @AmigaJdbcDatasource(value = "ptr", beanName = "ptrDataSource")
  public DataSource ptrDataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @Bean(name = "ptrJdbcTemplate")
  public JdbcTemplate ptrJdbcTemplate(@Qualifier("ptrDataSource") final DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean(name = "ptrNamedParameterJdbcTemplate")
  public NamedParameterJdbcTemplate ptrNamedParameterJdbcTemplate(
      @Qualifier("ptrJdbcTemplate") final JdbcTemplate jdbcTemplate) {
    return new NamedParameterJdbcTemplate(jdbcTemplate);
  }

}
