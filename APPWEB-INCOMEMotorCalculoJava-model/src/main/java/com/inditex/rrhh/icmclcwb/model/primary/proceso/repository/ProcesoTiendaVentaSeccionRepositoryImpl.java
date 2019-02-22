package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.Arrays;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.ProcesoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

@Repository
public class ProcesoTiendaVentaSeccionRepositoryImpl implements ProcesoTiendaVentaSeccionRepository {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("pscfProcesoTiendaVentaSeccionRepositorySave")
    private PreparedStatementCreatorFactory pscfSave;

    @ProcesoAuditoria
    @Override
    public void save(@NotNull final ProcesoDto procesoDto) {
        jdbcTemplate.update(pscfSave.newPreparedStatementCreator(Arrays.asList(procesoDto.getId())));
    }

}
