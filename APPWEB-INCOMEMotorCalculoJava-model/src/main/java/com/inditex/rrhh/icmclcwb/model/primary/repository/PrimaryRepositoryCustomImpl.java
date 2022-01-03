package com.inditex.rrhh.icmclcwb.model.primary.repository;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class PrimaryRepositoryCustomImpl implements PrimaryRepositoryCustom {

  @Autowired
  @Qualifier("primaryDataSource")
  private DataSource dataSource;

  @Override
  public Boolean load(Resource... resource) {
    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
    resourceDatabasePopulator.addScripts(resource);
    resourceDatabasePopulator.execute(dataSource);
    return Boolean.TRUE;
  }

}
