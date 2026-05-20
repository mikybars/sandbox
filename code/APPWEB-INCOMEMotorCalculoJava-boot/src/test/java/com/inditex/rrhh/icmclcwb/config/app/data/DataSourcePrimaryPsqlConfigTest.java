package com.inditex.rrhh.icmclcwb.config.app.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;

import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@ExtendWith(MockitoExtension.class)
class DataSourcePrimaryPsqlConfigTest {

  private DataSourcePrimaryPsqlConfig config;

  @BeforeEach
  void beforeEach() {
    config = new DataSourcePrimaryPsqlConfig();
  }

  @Nested
  class PrimaryDataSource {

    @Mock
    private DataSourceBuilder dataSourceBuilder;

    @Mock
    private DataSource expectedDataSource;

    @Test
    void whenBuiltExpectNonXaDatasource() {
      when(dataSourceBuilder.build(DataSourceType.NONXA)).thenReturn(expectedDataSource);

      final DataSource result = config.primaryDataSource(dataSourceBuilder);

      assertThat(result).isSameAs(expectedDataSource);
      verify(dataSourceBuilder).build(DataSourceType.NONXA);
    }
  }

  @Nested
  class PrimaryEntityManagerFactory {

    @Mock
    private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Mock
    private EntityManagerFactoryBuilder.Builder builder;

    @Mock
    private JpaProperties jpaProperties;

    @Mock
    private DataSource dataSource;

    @Mock
    private LocalContainerEntityManagerFactoryBean factoryBean;

    @Test
    void whenBuiltExpectCorrectConfiguration() {
      final Map<String, String> jpaProps = Map.of("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
      when(jpaProperties.getProperties()).thenReturn(jpaProps);
      when(entityManagerFactoryBuilder.dataSource(dataSource)).thenReturn(builder);
      when(builder.properties(jpaProps)).thenReturn(builder);
      when(builder.persistenceUnit("primaryPersistenceUnit")).thenReturn(builder);
      when(builder.jta(false)).thenReturn(builder);
      when(builder.packages("com.inditex.rrhh.icmclcwb.model.primary")).thenReturn(builder);
      when(builder.build()).thenReturn(factoryBean);

      final LocalContainerEntityManagerFactoryBean result =
          config.primaryEntityManagerFactory(entityManagerFactoryBuilder, jpaProperties, dataSource);

      assertThat(result).isSameAs(factoryBean);
      verify(entityManagerFactoryBuilder).dataSource(dataSource);
      verify(builder).persistenceUnit("primaryPersistenceUnit");
      verify(builder).packages("com.inditex.rrhh.icmclcwb.model.primary");
      verify(builder).jta(false);
    }
  }

  @Nested
  class PrimaryJdbcTemplate {

    @Mock
    private DataSource dataSource;

    @Test
    void whenBuiltExpectJdbcTemplateWithPrimaryDataSource() {
      final JdbcTemplate result = config.primaryJdbcTemplate(dataSource);

      assertThat(result).isNotNull();
      assertThat(result.getDataSource()).isSameAs(dataSource);
    }
  }

  @Nested
  class PrimaryNamedParameterJdbcTemplate {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    void whenBuiltExpectNamedParameterJdbcTemplate() {
      final NamedParameterJdbcTemplate result = config.primaryNamedParameterJdbcTemplate(jdbcTemplate);

      assertThat(result).isNotNull();
      assertThat(result.getJdbcOperations()).isSameAs(jdbcTemplate);
    }
  }
}
