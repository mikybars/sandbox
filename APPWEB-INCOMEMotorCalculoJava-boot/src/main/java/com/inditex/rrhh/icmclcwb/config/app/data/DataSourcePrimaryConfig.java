package com.inditex.rrhh.icmclcwb.config.app.data;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceType;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", basePackages = {
        "com.inditex.rrhh.icmclcwb.model.primary" })
public class DataSourcePrimaryConfig {

    @Value("#{${amiga.data.hibernate.primary.properties}}")
    private Map<String, String> hibernateProperties;

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.primary")
    public DataSource primaryDataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Bean(name = "primaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder emBuilder,
            DataSourceBuilder dsBuilder) {
        return emBuilder.dataSource(primaryDataSource(dsBuilder)).persistenceUnit("primaryPersistenceUnit")
                .packages("com.inditex.rrhh.icmclcwb.model.primary.entity").properties(hibernateProperties).jta(true)
                .build();
    }

    @Bean(name = "primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") final DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean(name = "primaryNamedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate primaryNamedParameterJdbcTemplate(
            @Qualifier("primaryJdbcTemplate") final JdbcTemplate jdbcTemplate) {
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }

}