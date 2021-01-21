package com.inditex.rrhh.icmclcwb.config.app.data;

// @Configuration
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
// @AmigaEnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", basePackages
// = {
// "com.inditex.rrhh.icmclcwb.model.primary" })
public class DataSourcePrimaryConfig {

    // @Bean(name = "primaryDataSource")
    // @Primary
    // @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.primary")
    // public DataSource primaryDataSource(final DataSourceBuilder dataSourceBuilder) {
    // return dataSourceBuilder.build(DataSourceType.XA);
    // }
    //
    // @Bean(name = "primaryEntityManagerFactory")
    // @Primary
    // public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
    // final EntityManagerFactoryBuilder entityManagerFactoryBuilder,
    // final JpaProperties jpaProperties,
    // @Qualifier("primaryDataSource") final DataSource dataSource) {
    // return entityManagerFactoryBuilder.dataSource(dataSource)
    // .persistenceUnit("primaryPersistenceUnit")
    // .packages("com.inditex.rrhh.icmclcwb.model.primary")
    // .properties(jpaProperties.getProperties())
    // .jta(true)
    // .build();
    // }
    //
    // @Bean(name = "primaryJdbcTemplate")
    // @Primary
    // public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") final DataSource
    // dataSource) {
    // return new JdbcTemplate(dataSource);
    // }
    //
    // @Bean(name = "primaryNamedParameterJdbcTemplate")
    // @Primary
    // public NamedParameterJdbcTemplate primaryNamedParameterJdbcTemplate(
    // @Qualifier("primaryJdbcTemplate") final JdbcTemplate jdbcTemplate) {
    // return new NamedParameterJdbcTemplate(jdbcTemplate);
    // }

}
