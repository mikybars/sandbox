package com.inditex.rrhh.icmclcwb.config.app.data;

import com.inditex.rrhh.icmclcwb.model.comis.repository.ClientDatabaseContextHolder;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ClientDataSourceRouter extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    return ClientDatabaseContextHolder.getClientDatabase();
  }

}
