package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
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

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarEmpleadosPorVenta']}")
    private String sqlTotalizarEmpleadosPorVenta;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.compensarEcommerce']}")
    private String sqlCompensarEcommerce;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciaDesplazamientoOrigenEcommerce']}")
    private String sqlIncluirMinutosEcommerceDesplazamientoOrigen;

    @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciaDesplazamientoDestinoEcommerce']}")
    private String sqlIncluirMinutosEcommerceDesplazamientoDestino;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public List<TareaLocalizacionPresencia> save(final List<TareaLocalizacionPresencia> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public void updateActivoVacio(@NotNull final RunTareaDto runTareaDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.namedParameterJdbcTemplate.update(this.sqlUpdateActivoVacio, parameters);
    }

    @Override
    public void compensar(@NotNull final RunTareaDto runTareaDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
                TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        this.namedParameterJdbcTemplate.update(this.sqlCompensar, parameters);
    }

    @Override
    public void totalizar(@NotNull final RunTareaDto runTareaDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
                TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

        this.namedParameterJdbcTemplate.update(this.sqlTotalizar, parameters);
    }

    @Override
    public void totalizarEcommerce(@NotNull final RunTareaDto runTareaDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
                TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.namedParameterJdbcTemplate.update(this.sqlTotalizarEcommerce, parameters);
    }

    @Override
    public void totalizarEmpleadosPorVenta(@NotNull final RunTareaDto runTareaDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
                TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_EMPLEADOS_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_VENTA,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.namedParameterJdbcTemplate.update(this.sqlTotalizarEmpleadosPorVenta, parameters);
    }

    @Override
    public void compensarEcommerce(@NotNull final RunTareaDto runTareaDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
                TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE,
                SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        this.namedParameterJdbcTemplate.update(this.sqlCompensarEcommerce, parameters);
    }

}
