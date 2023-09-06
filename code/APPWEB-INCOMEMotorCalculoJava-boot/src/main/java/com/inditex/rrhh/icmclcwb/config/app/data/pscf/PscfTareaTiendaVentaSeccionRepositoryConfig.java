package com.inditex.rrhh.icmclcwb.config.app.data.pscf;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class PscfTareaTiendaVentaSeccionRepositoryConfig {

  @Bean(name = "pscfTareaTiendaVentaSeccionRepositorySave")
  public PreparedStatementCreatorFactory pscfTareaTiendaVentaSeccionRepositorySave(
      @Value("#{primaryQuery['TareaTiendaVentaSeccionRepository.save']}") final String sql) {
    return new PreparedStatementCreatorFactory(sql, Types.BIGINT);
  }

}
