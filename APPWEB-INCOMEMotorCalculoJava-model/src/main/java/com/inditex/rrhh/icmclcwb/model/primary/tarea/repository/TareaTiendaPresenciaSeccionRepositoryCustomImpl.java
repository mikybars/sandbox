package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaPresenciaSeccion;

@Repository
public class TareaTiendaPresenciaSeccionRepositoryCustomImpl        
extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaPresenciaSeccion>
 implements TareaTiendaPresenciaSeccionRepositoryCustom {

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;
    
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("pscfTareaTiendaPresenciaSeccionRepositorySave")
    private PreparedStatementCreatorFactory pscfSave;

    @Autowired
    @Qualifier("primaryQuery")
    private Properties query;
    
    @Auditoria
    @Override
    public void save(@NotNull final TareaDto tareaDto) {
        jdbcTemplate.update(pscfSave.newPreparedStatementCreator(Arrays.asList(tareaDto.getId())));
    }
    
    @Override
    public List<TareaTiendaPresenciaSeccion> save(final List<TareaTiendaPresenciaSeccion> src) {
        return saveJdbcBatchList(src, query.getProperty("TareaTiendaPresenciaSeccionRepositoryCustom.save"),
                presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxBatchSize());
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaPresenciaSeccion entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setDouble(3, entity.getMinutos1() != null ? entity.getMinutos1() : 0);
        pstmt.setDouble(4, entity.getMinutos2() != null ? entity.getMinutos2() : 0);
        pstmt.setDouble(5, entity.getMinutos3() != null ? entity.getMinutos3() : 0);
        pstmt.setDouble(6, entity.getTipoMinutosPresencia().getId());
        pstmt.setLong(7, entity.getTarea().getId());        
    }

}
