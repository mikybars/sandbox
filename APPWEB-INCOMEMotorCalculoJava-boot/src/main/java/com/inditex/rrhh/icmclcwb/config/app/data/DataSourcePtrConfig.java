package com.inditex.rrhh.icmclcwb.config.app.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceType;

@Configuration
public class DataSourcePtrConfig {

    @Bean(name = "ptrDataSource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.ptr")
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
