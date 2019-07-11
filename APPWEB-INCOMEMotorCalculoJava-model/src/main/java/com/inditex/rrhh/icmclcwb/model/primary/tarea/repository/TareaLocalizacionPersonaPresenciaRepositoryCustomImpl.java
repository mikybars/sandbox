package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

@Repository
public class TareaLocalizacionPersonaPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaPresencia>
        implements TareaLocalizacionPersonaPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.compensar']}")
    private String sqlCompensar;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public void updateActivo(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR, 0);
        List<IdTipoDatoDto> tiposDatoPresencia =
            tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
            tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, 0);

        namedParameterJdbcTemplate.update(sqlUpdateActivo, parameters);
    }

    @Override
    public void compensar(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR, 0);
        List<IdTipoDatoDto> tiposDatoPresencia =
            tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
            tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
            TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

        namedParameterJdbcTemplate.update(sqlCompensar, parameters);
    }

    @Override
    public List<TareaLocalizacionPersonaPresencia> save(final List<TareaLocalizacionPersonaPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaPresencia entity) throws SQLException {
        pstmt.setString(1, entity.getIdLocalizacion());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setString(5, entity.getIdSeccion());
        pstmt.setObject(6, entity.getFecha());
        pstmt.setLong(7, entity.getMinutos());
        pstmt.setString(8, entity.getIdTipoHora());
        pstmt.setBoolean(9, entity.getActivo());
        pstmt.setLong(10, entity.getTipoDato().getId());
        pstmt.setLong(11, entity.getTarea().getId());
        pstmt.setString(12, entity.getIdCadena());
    }

}
