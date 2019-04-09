package com.inditex.rrhh.icmclcwb.config.app.data.pscf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class PscfTareaTiendaVentaRespositoryConfig {

    @Bean(name = "pscfTareaTiendaVentaRepositoryProcesar")
    public PreparedStatementCreatorFactory pscfTareaTiendaVentaRepositoryProcesar(
            @Value("#{primaryQuery['RunTareaProcesarService.procesarVentaTienda']}" ) final String sql) {
        return new PreparedStatementCreatorFactory(sql);
    }
    
}
