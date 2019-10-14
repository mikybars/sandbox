package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

@Repository
public class TareaLocalizacionPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresencia>
        implements TareaLocalizacionPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.tarea-localizacion-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio']}")
    private String sqlUpdateActivoVacio;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.compensar']}")
    private String sqlCompensar;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciasDesplazamientoOrigen']}")
    private String sqlIncluirPresenciasDesplazamientoOrigen;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciasDesplazamientoDestino']}")
    private String sqlIncluirPresenciasDesplazamientoDestino;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizar']}")
    private String sqlTotalizar;
    
    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerce']}")
    private String sqlTotalizarEcommerce;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.compensarEcommerce']}")
    private String sqlCompensarEcommerce;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciaDesplazamientoOrigenEcommerce']}")
    private String sqlIncluirMinutosEcommerceDesplazamientoOrigen;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciaDesplazamientoDestinoEcommerce']}")
    private String sqlIncluirMinutosEcommerceDesplazamientoDestino;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void updateActivoVacio(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlUpdateActivoVacio, parameters);
    }

    @Override
    public void compensar(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        namedParameterJdbcTemplate.update(sqlCompensar, parameters);
    }

    @Override
    public void totalizar(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

        namedParameterJdbcTemplate.update(sqlTotalizar, parameters);
    }
    
    @Override
    public void totalizarEcommerce(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlTotalizarEcommerce, parameters);
    }

    @Override
    public void compensarEcommerce(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        namedParameterJdbcTemplate.update(sqlCompensarEcommerce, parameters);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getPk().getFecha());
        pstmt.setString(2, entity.getCclIdCodOrigen());
        pstmt.setString(3, entity.getCclIdSeccion());
        pstmt.setDouble(4, entity.getMinutos());
        pstmt.setDouble(5, entity.getTipoDato().getId());
        pstmt.setBoolean(6, entity.getActivo());
        pstmt.setLong(7, entity.getTarea().getId());
        pstmt.setString(8, entity.getCclIdCadena());
    }

}
