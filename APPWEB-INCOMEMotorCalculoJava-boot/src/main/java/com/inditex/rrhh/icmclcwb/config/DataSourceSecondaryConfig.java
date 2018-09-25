package com.inditex.rrhh.icmclcwb.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceType;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "secondaryEntityManagerFactory", basePackages = {
				"com.inditex.rrhh.icmclcwb.model.secondary" })
public class DataSourceSecondaryConfig {

	@Value("#{${amiga.data.hibernate.secondary.properties}}")
	Map<String, String> hibernateProperties;

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.secondary")
	public DataSource secondaryDataSource(final DataSourceBuilder dataSourceBuilder) {
		return dataSourceBuilder.build(DataSourceType.NONXA);
	}

	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder emBuilder,
					DataSourceBuilder dsBuilder) {
		return emBuilder.dataSource(secondaryDataSource(dsBuilder)).persistenceUnit("secondaryPersistenceUnit")
						.packages("com.inditex.rrhh.icmclcwb.model.secondary.entity").properties(hibernateProperties)
						.jta(true).build();
	}

}