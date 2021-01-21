package com.inditex.rrhh.icmclcwb.config.app.data;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.aqsw.framework.data.jdbc.datasources.DataSourceType;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class DataSourceComisConfig {

    @Resource(name = "comis1Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis1")
    public DataSource comis1DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis2Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis2")
    public DataSource comis2DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis3Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis3")
    public DataSource comis3DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis4Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis4")
    public DataSource comis4DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis5Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis5")
    public DataSource comis5DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis6Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis6")
    public DataSource comis6DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis7Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis7")
    public DataSource comis7DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis8Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis8")
    public DataSource comis8DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis9Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis9")
    public DataSource comis9DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis10Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis10")
    public DataSource comis10DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis18Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis18")
    public DataSource comis18DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis28Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis28")
    public DataSource comis28DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis30Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis30")
    public DataSource comis30DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis32Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis32")
    public DataSource comis32DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis38Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis38")
    public DataSource comis38DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis39Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis39")
    public DataSource comis39DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis52Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis52")
    public DataSource comis52DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis60Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis60")
    public DataSource comis60DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis61Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis61")
    public DataSource comis61DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis63Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis63")
    public DataSource comis63DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis64Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis64")
    public DataSource comis64DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis66Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis66")
    public DataSource comis66DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis68Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis68")
    public DataSource comis68DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis72Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis72")
    public DataSource comis72DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis75Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis75")
    public DataSource comis75DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis79Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis79")
    public DataSource comis79DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis92Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis92")
    public DataSource comis92DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis93Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis93")
    public DataSource comis93DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis96Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis96")
    public DataSource comis96DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis97Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis97")
    public DataSource comis97DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis98Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis98")
    public DataSource comis98DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis139Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis139")
    public DataSource comis139DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis388Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis388")
    public DataSource comis388DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis400Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis400")
    public DataSource comis400DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis404Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis404")
    public DataSource comis404DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis412Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis412")
    public DataSource comis412DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis508Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis508")
    public DataSource comis508DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis512Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis512")
    public DataSource comis512DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis524Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis524")
    public DataSource comis524DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis528Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis528")
    public DataSource comis528DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis664Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis664")
    public DataSource comis664DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis720Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis720")
    public DataSource comis720DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis728Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis728")
    public DataSource comis728DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis732Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis732")
    public DataSource comis732DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis736Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis736")
    public DataSource comis736DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis740Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis740")
    public DataSource comis740DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis743Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis743")
    public DataSource comis743DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Resource(name = "comis800Datasource")
    @ConfigurationProperties(prefix = "amiga.data.jdbc.datasource.comis800")
    public DataSource comis800DataSource(final DataSourceBuilder dataSourceBuilder) {
        return dataSourceBuilder.build(DataSourceType.NONXA);
    }

    @Bean(name = "comisDatasource")
    public DataSource dataSourceSql(@Lazy @Qualifier("comis1Datasource") final DataSource comis1Datasource,
            @Lazy @Qualifier("comis2Datasource") final DataSource comis2Datasource,
            @Lazy @Qualifier("comis3Datasource") final DataSource comis3Datasource,
            @Lazy @Qualifier("comis4Datasource") final DataSource comis4Datasource,
            @Lazy @Qualifier("comis5Datasource") final DataSource comis5Datasource,
            @Lazy @Qualifier("comis6Datasource") final DataSource comis6Datasource,
            @Lazy @Qualifier("comis7Datasource") final DataSource comis7Datasource,
            @Lazy @Qualifier("comis8Datasource") final DataSource comis8Datasource,
            @Lazy @Qualifier("comis9Datasource") final DataSource comis9Datasource,
            @Lazy @Qualifier("comis10Datasource") final DataSource comis10Datasource,
            @Lazy @Qualifier("comis18Datasource") final DataSource comis18Datasource,
            @Lazy @Qualifier("comis28Datasource") final DataSource comis28Datasource,
            @Lazy @Qualifier("comis30Datasource") final DataSource comis30Datasource,
            @Lazy @Qualifier("comis32Datasource") final DataSource comis32Datasource,
            @Lazy @Qualifier("comis38Datasource") final DataSource comis38Datasource,
            @Lazy @Qualifier("comis39Datasource") final DataSource comis39Datasource,
            @Lazy @Qualifier("comis52Datasource") final DataSource comis52Datasource,
            @Lazy @Qualifier("comis60Datasource") final DataSource comis60Datasource,
            @Lazy @Qualifier("comis61Datasource") final DataSource comis61Datasource,
            @Lazy @Qualifier("comis63Datasource") final DataSource comis63Datasource,
            @Lazy @Qualifier("comis64Datasource") final DataSource comis64Datasource,
            @Lazy @Qualifier("comis66Datasource") final DataSource comis66Datasource,
            @Lazy @Qualifier("comis68Datasource") final DataSource comis68Datasource,
            @Lazy @Qualifier("comis72Datasource") final DataSource comis72Datasource,
            @Lazy @Qualifier("comis75Datasource") final DataSource comis75Datasource,
            @Lazy @Qualifier("comis79Datasource") final DataSource comis79Datasource,
            @Lazy @Qualifier("comis92Datasource") final DataSource comis92Datasource,
            @Lazy @Qualifier("comis93Datasource") final DataSource comis93Datasource,
            @Lazy @Qualifier("comis96Datasource") final DataSource comis96Datasource,
            @Lazy @Qualifier("comis97Datasource") final DataSource comis97Datasource,
            @Lazy @Qualifier("comis98Datasource") final DataSource comis98Datasource,
            @Lazy @Qualifier("comis139Datasource") final DataSource comis139Datasource,
            @Lazy @Qualifier("comis388Datasource") final DataSource comis388Datasource,
            @Lazy @Qualifier("comis400Datasource") final DataSource comis400Datasource,
            @Lazy @Qualifier("comis404Datasource") final DataSource comis404Datasource,
            @Lazy @Qualifier("comis412Datasource") final DataSource comis412Datasource,
            @Lazy @Qualifier("comis508Datasource") final DataSource comis508Datasource,
            @Lazy @Qualifier("comis512Datasource") final DataSource comis512Datasource,
            @Lazy @Qualifier("comis524Datasource") final DataSource comis524Datasource,
            @Lazy @Qualifier("comis528Datasource") final DataSource comis528Datasource,
            @Lazy @Qualifier("comis664Datasource") final DataSource comis664Datasource,
            @Lazy @Qualifier("comis720Datasource") final DataSource comis720Datasource,
            @Lazy @Qualifier("comis728Datasource") final DataSource comis728Datasource,
            @Lazy @Qualifier("comis732Datasource") final DataSource comis732Datasource,
            @Lazy @Qualifier("comis736Datasource") final DataSource comis736Datasource,
            @Lazy @Qualifier("comis740Datasource") final DataSource comis740Datasource,
            @Lazy @Qualifier("comis743Datasource") final DataSource comis743Datasource,
            @Lazy @Qualifier("comis800Datasource") final DataSource comis800Datasource) {
        final Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("COMIS1", comis1Datasource);
        targetDataSources.put("COMIS2", comis2Datasource);
        targetDataSources.put("COMIS3", comis3Datasource);
        targetDataSources.put("COMIS4", comis4Datasource);
        targetDataSources.put("COMIS5", comis5Datasource);
        targetDataSources.put("COMIS6", comis6Datasource);
        targetDataSources.put("COMIS7", comis7Datasource);
        targetDataSources.put("COMIS8", comis8Datasource);
        targetDataSources.put("COMIS9", comis9Datasource);
        targetDataSources.put("COMIS10", comis10Datasource);
        targetDataSources.put("COMIS18", comis18Datasource);
        targetDataSources.put("COMIS28", comis28Datasource);
        targetDataSources.put("COMIS30", comis30Datasource);
        targetDataSources.put("COMIS32", comis32Datasource);
        targetDataSources.put("COMIS38", comis38Datasource);
        targetDataSources.put("COMIS39", comis39Datasource);
        targetDataSources.put("COMIS52", comis52Datasource);
        targetDataSources.put("COMIS60", comis60Datasource);
        targetDataSources.put("COMIS61", comis61Datasource);
        targetDataSources.put("COMIS63", comis63Datasource);
        targetDataSources.put("COMIS64", comis64Datasource);
        targetDataSources.put("COMIS66", comis66Datasource);
        targetDataSources.put("COMIS68", comis68Datasource);
        targetDataSources.put("COMIS72", comis72Datasource);
        targetDataSources.put("COMIS75", comis75Datasource);
        targetDataSources.put("COMIS79", comis79Datasource);
        targetDataSources.put("COMIS92", comis92Datasource);
        targetDataSources.put("COMIS93", comis93Datasource);
        targetDataSources.put("COMIS96", comis96Datasource);
        targetDataSources.put("COMIS97", comis97Datasource);
        targetDataSources.put("COMIS98", comis98Datasource);
        targetDataSources.put("COMIS139", comis139Datasource);
        targetDataSources.put("COMIS388", comis388Datasource);
        targetDataSources.put("COMIS400", comis400Datasource);
        targetDataSources.put("COMIS404", comis404Datasource);
        targetDataSources.put("COMIS412", comis412Datasource);
        targetDataSources.put("COMIS508", comis508Datasource);
        targetDataSources.put("COMIS512", comis512Datasource);
        targetDataSources.put("COMIS524", comis524Datasource);
        targetDataSources.put("COMIS528", comis528Datasource);
        targetDataSources.put("COMIS664", comis664Datasource);
        targetDataSources.put("COMIS720", comis720Datasource);
        targetDataSources.put("COMIS728", comis728Datasource);
        targetDataSources.put("COMIS732", comis732Datasource);
        targetDataSources.put("COMIS736", comis736Datasource);
        targetDataSources.put("COMIS740", comis740Datasource);
        targetDataSources.put("COMIS743", comis743Datasource);
        targetDataSources.put("COMIS800", comis800Datasource);

        final ClientDataSourceRouter clientRoutingDatasource = new ClientDataSourceRouter();
        clientRoutingDatasource.setTargetDataSources(targetDataSources);
        clientRoutingDatasource.setDefaultTargetDataSource(comis61Datasource);
        return clientRoutingDatasource;
    }

    @Bean(name = "comisJdbcTemplate")
    public JdbcTemplate comisJdbcTemplate(@Qualifier("comisDatasource") final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "comisNamedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate comisNamedParameterJdbcTemplate(
            @Qualifier("comisJdbcTemplate") final JdbcTemplate jdbcTemplate) {
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }

}
