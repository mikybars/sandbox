/**
 *
 */
package com.inditex.rrhh.icmclcwb.config.app.data;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author mdelrio
 *
 */
public class ClientDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ClientDatabaseContextHolder.getClientDatabase();
    }

}
