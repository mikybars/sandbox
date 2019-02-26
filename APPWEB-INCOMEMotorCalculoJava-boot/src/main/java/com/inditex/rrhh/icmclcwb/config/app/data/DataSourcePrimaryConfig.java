package com.inditex.rrhh.icmclcwb.config.app.data;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceType;
import com.inditex.aqsw.framework.data.jpa.annotations.AmigaEnableJpaRepositories;

@Configuration
@AmigaEnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", basePackages = {
        "com.inditex.rrhh.icmclcwb.model.primary" })
public class DataSourcePrimaryConfig {

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.primary")
    public DataSource primaryDataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Bean(name = "primaryJpaProperties")
    @Primary
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.primary")
    public Map<String, String> primaryJpaProperties(final JpaProperties jpaProperties,
            @Value("#{${amiga.data.hibernate.primary.properties}}") final Map<String, String> hibernateProperties) {
        Map<String, String> result = new HashMap<>();
        result.putAll(jpaProperties.getProperties());
        result.putAll(hibernateProperties);
        return result;
    }

    @Bean(name = "primaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            final EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("primaryJpaProperties") final Map<String, String> primaryJpaProperties,
            @Qualifier("primaryDataSource") final DataSource dataSource) {
        return entityManagerFactoryBuilder.dataSource(dataSource).persistenceUnit("primaryPersistenceUnit")
                .packages("com.inditex.rrhh.icmclcwb.model.primary").properties(primaryJpaProperties).jta(true).build();
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