package com.inditex.rrhh.icmclcwb.config.app.data;

import java.util.HashMap;
import java.util.Map;

import com.inditex.amigafwk.data.core.jdbc.annotation.AmigaJdbcDatasource;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;
import com.inditex.rrhh.icmclcwb.model.app.annotation.AntiguoMotor;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ClientDatabase;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@AntiguoMotor
public class DataSourceComisConfig {

  @AmigaJdbcDatasource(value = "comis1", beanName = "comis1Datasource")
  public DataSource comis1DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis2", beanName = "comis2Datasource")
  public DataSource comis2DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis3", beanName = "comis3Datasource")
  public DataSource comis3DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis4", beanName = "comis4Datasource")
  public DataSource comis4DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis5", beanName = "comis5Datasource")
  public DataSource comis5DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis6", beanName = "comis6Datasource")
  public DataSource comis6DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis7", beanName = "comis7Datasource")
  public DataSource comis7DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis8", beanName = "comis8Datasource")
  public DataSource comis8DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis9", beanName = "comis9Datasource")
  public DataSource comis9DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis10", beanName = "comis10Datasource")
  public DataSource comis10DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-8", beanName = "comisOrigen11Empresa8Datasource")
  public DataSource comisOrigen11Empresa8Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-20", beanName = "comisOrigen11Empresa20Datasource")
  public DataSource comisOrigen11Empresa20Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-233", beanName = "comisOrigen11Empresa233Datasource")
  public DataSource comisOrigen11Empresa233Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-28", beanName = "comisOrigen11Empresa28Datasource")
  public DataSource comisOrigen11Empresa28Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-33", beanName = "comisOrigen11Empresa33Datasource")
  public DataSource comisOrigen11Empresa33Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-101", beanName = "comisOrigen11Empresa101Datasource")
  public DataSource comisOrigen11Empresa101Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-11", beanName = "comisOrigen11Empresa11Datasource")
  public DataSource comisOrigen11Empresa11Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-2", beanName = "comisOrigen11Empresa2Datasource")
  public DataSource comisOrigen11Empresa2Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-30", beanName = "comisOrigen11Empresa30Datasource")
  public DataSource comisOrigen11Empresa30Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis11-25", beanName = "comisOrigen11Empresa25Datasource")
  public DataSource comisOrigen11Empresa25Datasource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis18", beanName = "comis18Datasource")
  public DataSource comis18DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis28", beanName = "comis28Datasource")
  public DataSource comis28DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis30", beanName = "comis30Datasource")
  public DataSource comis30DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis32", beanName = "comis32Datasource")
  public DataSource comis32DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis38", beanName = "comis38Datasource")
  public DataSource comis38DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis39", beanName = "comis39Datasource")
  public DataSource comis39DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis52", beanName = "comis52Datasource")
  public DataSource comis52DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis60", beanName = "comis60Datasource")
  public DataSource comis60DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis61", beanName = "comis61Datasource")
  public DataSource comis61DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis63", beanName = "comis63Datasource")
  public DataSource comis63DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis64", beanName = "comis64Datasource")
  public DataSource comis64DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis66", beanName = "comis66Datasource")
  public DataSource comis66DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis68", beanName = "comis68Datasource")
  public DataSource comis68DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis70", beanName = "comis70Datasource")
  public DataSource comis70DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis72", beanName = "comis72Datasource")
  public DataSource comis72DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis73", beanName = "comis73Datasource")
  public DataSource comis73DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis75", beanName = "comis75Datasource")
  public DataSource comis75DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis79", beanName = "comis79Datasource")
  public DataSource comis79DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis91", beanName = "comis91Datasource")
  public DataSource comis91DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis92", beanName = "comis92Datasource")
  public DataSource comis92DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis93", beanName = "comis93Datasource")
  public DataSource comis93DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis95", beanName = "comis95Datasource")
  public DataSource comis95DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis96", beanName = "comis96Datasource")
  public DataSource comis96DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis97", beanName = "comis97Datasource")
  public DataSource comis97DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis98", beanName = "comis98Datasource")
  public DataSource comis98DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis139", beanName = "comis139Datasource")
  public DataSource comis139DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis388", beanName = "comis388Datasource")
  public DataSource comis388DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis400", beanName = "comis400Datasource")
  public DataSource comis400DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis404", beanName = "comis404Datasource")
  public DataSource comis404DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis412", beanName = "comis412Datasource")
  public DataSource comis412DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis508", beanName = "comis508Datasource")
  public DataSource comis508DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis512", beanName = "comis512Datasource")
  public DataSource comis512DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis524", beanName = "comis524Datasource")
  public DataSource comis524DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis528", beanName = "comis528Datasource")
  public DataSource comis528DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis664", beanName = "comis664Datasource")
  public DataSource comis664DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis720", beanName = "comis720Datasource")
  public DataSource comis720DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis728", beanName = "comis728Datasource")
  public DataSource comis728DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis732", beanName = "comis732Datasource")
  public DataSource comis732DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis736", beanName = "comis736Datasource")
  public DataSource comis736DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis740", beanName = "comis740Datasource")
  public DataSource comis740DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis743", beanName = "comis743Datasource")
  public DataSource comis743DataSource(final DataSourceBuilder dataSourceBuilder) {
    return dataSourceBuilder.build(DataSourceType.NONXA);
  }

  @AmigaJdbcDatasource(value = "comis800", beanName = "comis800Datasource")
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
      @Lazy @Qualifier("comisOrigen11Empresa8Datasource") final DataSource comisOrigen11Empresa8Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa20Datasource") final DataSource comisOrigen11Empresa20Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa233Datasource") final DataSource comisOrigen11Empresa233Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa28Datasource") final DataSource comisOrigen11Empresa28Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa33Datasource") final DataSource comisOrigen11Empresa33Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa101Datasource") final DataSource comisOrigen11Empresa101Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa11Datasource") final DataSource comisOrigen11Empresa11Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa2Datasource") final DataSource comisOrigen11Empresa2Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa30Datasource") final DataSource comisOrigen11Empresa30Datasource,
      @Lazy @Qualifier("comisOrigen11Empresa25Datasource") final DataSource comisOrigen11Empresa25Datasource,
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
      @Lazy @Qualifier("comis70Datasource") final DataSource comis70Datasource,
      @Lazy @Qualifier("comis72Datasource") final DataSource comis72Datasource,
      @Lazy @Qualifier("comis73Datasource") final DataSource comis73Datasource,
      @Lazy @Qualifier("comis75Datasource") final DataSource comis75Datasource,
      @Lazy @Qualifier("comis79Datasource") final DataSource comis79Datasource,
      @Lazy @Qualifier("comis91Datasource") final DataSource comis91Datasource,
      @Lazy @Qualifier("comis92Datasource") final DataSource comis92Datasource,
      @Lazy @Qualifier("comis93Datasource") final DataSource comis93Datasource,
      @Lazy @Qualifier("comis95Datasource") final DataSource comis95Datasource,
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
    targetDataSources.put(ClientDatabase.COMIS1, comis1Datasource);
    targetDataSources.put(ClientDatabase.COMIS2, comis2Datasource);
    targetDataSources.put(ClientDatabase.COMIS3, comis3Datasource);
    targetDataSources.put(ClientDatabase.COMIS4, comis4Datasource);
    targetDataSources.put(ClientDatabase.COMIS5, comis5Datasource);
    targetDataSources.put(ClientDatabase.COMIS6, comis6Datasource);
    targetDataSources.put(ClientDatabase.COMIS7, comis7Datasource);
    targetDataSources.put(ClientDatabase.COMIS8, comis8Datasource);
    targetDataSources.put(ClientDatabase.COMIS9, comis9Datasource);
    targetDataSources.put(ClientDatabase.COMIS10, comis10Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_8, comisOrigen11Empresa8Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_20, comisOrigen11Empresa20Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_233, comisOrigen11Empresa233Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_28, comisOrigen11Empresa28Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_33, comisOrigen11Empresa33Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_101, comisOrigen11Empresa101Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_11, comisOrigen11Empresa11Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_2, comisOrigen11Empresa2Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_30, comisOrigen11Empresa30Datasource);
    targetDataSources.put(ClientDatabase.COMIS11_25, comisOrigen11Empresa25Datasource);
    targetDataSources.put(ClientDatabase.COMIS18, comis18Datasource);
    targetDataSources.put(ClientDatabase.COMIS28, comis28Datasource);
    targetDataSources.put(ClientDatabase.COMIS30, comis30Datasource);
    targetDataSources.put(ClientDatabase.COMIS32, comis32Datasource);
    targetDataSources.put(ClientDatabase.COMIS38, comis38Datasource);
    targetDataSources.put(ClientDatabase.COMIS39, comis39Datasource);
    targetDataSources.put(ClientDatabase.COMIS52, comis52Datasource);
    targetDataSources.put(ClientDatabase.COMIS60, comis60Datasource);
    targetDataSources.put(ClientDatabase.COMIS61, comis61Datasource);
    targetDataSources.put(ClientDatabase.COMIS63, comis63Datasource);
    targetDataSources.put(ClientDatabase.COMIS64, comis64Datasource);
    targetDataSources.put(ClientDatabase.COMIS66, comis66Datasource);
    targetDataSources.put(ClientDatabase.COMIS68, comis68Datasource);
    targetDataSources.put(ClientDatabase.COMIS70, comis70Datasource);
    targetDataSources.put(ClientDatabase.COMIS72, comis72Datasource);
    targetDataSources.put(ClientDatabase.COMIS73, comis73Datasource);
    targetDataSources.put(ClientDatabase.COMIS75, comis75Datasource);
    targetDataSources.put(ClientDatabase.COMIS79, comis79Datasource);
    targetDataSources.put(ClientDatabase.COMIS91, comis91Datasource);
    targetDataSources.put(ClientDatabase.COMIS92, comis92Datasource);
    targetDataSources.put(ClientDatabase.COMIS93, comis93Datasource);
    targetDataSources.put(ClientDatabase.COMIS95, comis95Datasource);
    targetDataSources.put(ClientDatabase.COMIS96, comis96Datasource);
    targetDataSources.put(ClientDatabase.COMIS97, comis97Datasource);
    targetDataSources.put(ClientDatabase.COMIS98, comis98Datasource);
    targetDataSources.put(ClientDatabase.COMIS139, comis139Datasource);
    targetDataSources.put(ClientDatabase.COMIS388, comis388Datasource);
    targetDataSources.put(ClientDatabase.COMIS400, comis400Datasource);
    targetDataSources.put(ClientDatabase.COMIS404, comis404Datasource);
    targetDataSources.put(ClientDatabase.COMIS412, comis412Datasource);
    targetDataSources.put(ClientDatabase.COMIS508, comis508Datasource);
    targetDataSources.put(ClientDatabase.COMIS512, comis512Datasource);
    targetDataSources.put(ClientDatabase.COMIS524, comis524Datasource);
    targetDataSources.put(ClientDatabase.COMIS528, comis528Datasource);
    targetDataSources.put(ClientDatabase.COMIS664, comis664Datasource);
    targetDataSources.put(ClientDatabase.COMIS720, comis720Datasource);
    targetDataSources.put(ClientDatabase.COMIS728, comis728Datasource);
    targetDataSources.put(ClientDatabase.COMIS732, comis732Datasource);
    targetDataSources.put(ClientDatabase.COMIS736, comis736Datasource);
    targetDataSources.put(ClientDatabase.COMIS740, comis740Datasource);
    targetDataSources.put(ClientDatabase.COMIS743, comis743Datasource);
    targetDataSources.put(ClientDatabase.COMIS800, comis800Datasource);

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
