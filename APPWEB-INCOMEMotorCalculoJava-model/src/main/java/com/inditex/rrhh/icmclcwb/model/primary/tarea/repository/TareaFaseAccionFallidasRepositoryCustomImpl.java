package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2022. Inditex
 */

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionFallidas;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaFaseAccionFallidasRepositoryCustomImpl
    implements TareaFaseAccionFallidasRepositoryCustom {

  @Autowired
  @Qualifier("primaryJdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  @Value("#{primaryQuery['TareaFaseAccionFallidasRepositoryCustom.save']}")
  private String sqlSave;

  /**
   * Guarda en TAREA_FASE_ACCION_FALLIDAS.
   */
  @Override
  public void save(@NotNull TareaFaseAccionFallidas src) {
    this.jdbcTemplate.batchUpdate(this.sqlSave,
        new BatchPreparedStatementSetter() {
          @Override
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setLong(1, src.getPk().getTareaFaseAccion().getId());
            ps.setInt(2, src.getTipoFallidas().getId());
            ps.setString(3, src.getFallidas());
          }

          @Override
          public int getBatchSize() {
            return 1;
          }
        });
  }
}
