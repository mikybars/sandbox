package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Repository
public class TrabajoTiendaPresenciaSeccionRepositoryImpl implements TrabajoTiendaPresenciaSeccionRepository {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("pscfTrabajoTiendaPresenciaSeccionRepositorySave")
    private PreparedStatementCreatorFactory pscfSave;

    @AuditoriaTrabajo
    @Override
    public void save(@NotNull final TrabajoDto trabajoDto) {
        jdbcTemplate.update(pscfSave.newPreparedStatementCreator(Arrays.asList(trabajoDto.getId())));
    }

}
