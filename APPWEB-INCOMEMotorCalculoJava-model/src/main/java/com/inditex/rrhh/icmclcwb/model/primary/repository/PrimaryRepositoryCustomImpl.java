package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class PrimaryRepositoryCustomImpl implements PrimaryRepositoryCustom {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean load(List<Resource> resource) throws Exception {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resource.forEach(item -> resourceDatabasePopulator.addScripts(item));
        resourceDatabasePopulator.execute(jdbcTemplate.getDataSource());
        return Boolean.TRUE;
    }

}
