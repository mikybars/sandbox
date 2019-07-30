package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;

@Repository
public class TareaLocalizacionOnlineHistoricoRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionOnlineHistorico>
        implements TareaLocalizacionOnlineHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.tarea-localizacion-online-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionOnlineHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionOnlineHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
    private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;

    @Override
    public List<TareaLocalizacionOnlineHistorico> save(List<TareaLocalizacionOnlineHistorico> tiendas) {
        return saveJdbcBatchList(tiendas, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionOnlineHistorico entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdLocalizacionMeta4());
        pstmt.setString(4, entity.getIdPais());
        pstmt.setString(5, entity.getIdEmpresa());
        pstmt.setString(6, entity.getIdCadena());
        pstmt.setObject(7, entity.getFechaInicio());
        pstmt.setObject(8, entity.getFechaInicio());
    }

}
