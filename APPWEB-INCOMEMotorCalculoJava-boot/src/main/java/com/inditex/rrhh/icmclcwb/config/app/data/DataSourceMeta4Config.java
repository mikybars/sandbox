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
public class DataSourceMeta4Config {

    @Bean(name = "meta4Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.meta4")
    public DataSource meta4DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Bean(name = "meta4JdbcTemplate")
    public JdbcTemplate meta4JdbcTemplate(@Qualifier("meta4Datasource") final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "meta4NamedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate meta4NamedParameterJdbcTemplate(
            @Qualifier("meta4JdbcTemplate") final JdbcTemplate jdbcTemplate) {
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }

}
