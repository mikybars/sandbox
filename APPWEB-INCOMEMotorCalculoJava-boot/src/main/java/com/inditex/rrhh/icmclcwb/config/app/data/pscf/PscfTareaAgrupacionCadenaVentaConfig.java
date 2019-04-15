package com.inditex.rrhh.icmclcwb.config.app.data.pscf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class PscfTareaAgrupacionCadenaVentaConfig {

    @Bean(name = "pscfTareaAgrupacionCadenvaVentaRepositoryProcesar")
    public PreparedStatementCreatorFactory pscfTareaAgrupacionCadenaVentaRepositoryProcesar(
            @Value("#{primaryQuery['RunTareaProcesarService.procesarVentaAgrupacionCadena']}" ) final String sql) {
        return new PreparedStatementCreatorFactory(sql);
    }
    
}
