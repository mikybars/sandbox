package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

@Repository
public class TareaLocalizacionPersonaPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaPresencia>
        implements TareaLocalizacionPersonaPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoVacio']}")
    private String sqlUpdateActivoVacio;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.compensar']}")
    private String sqlCompensar;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresencia']}")
    private String sqlIndicadorPresencia;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamiento']}")
    private String sqlIndicadorPresenciaDesplazamiento;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamientoBase']}")
    private String sqlIndicadorPresenciaDesplazamientoBase;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion']}")
    private String sqlIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.procesarPresenciasHorasFijas']}")
    private String sqlProcesarPresenciasHorasFijas;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.procesarPresenciasHorasFijasDesplazamientos']}")
    private String sqlProcesarPresenciasHorasFijasDesplazamientos;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVenta']}")
    private String sqlIndicadorPersonaPorVenta;

    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVentaSimplificada']}")
    private String sqlIndicadorPersonaPorVentaSimplificada;
      
    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public void indicadorPresencia(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
                TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        update(sqlIndicadorPresencia, parameters);
    }
    
    @Override
    public void indicadorPresenciaDesplazamiento(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(), TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
                TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId(), TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        update(sqlIndicadorPresenciaDesplazamiento, parameters);
    }
    
    @Override
    public void indicadorPresenciaDesplazamientoBase(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(), TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
                TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId(), TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        update(sqlIndicadorPresenciaDesplazamientoBase, parameters);
    }
    
    @Override
    public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        update(sqlIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion, parameters);
    }
    
    @Override
    public void updateActivoVacio(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_PERSONA_TIPOHORA.getId());
        update(sqlUpdateActivoVacio, parameters);
    }

    @Override
    public void updateActivo(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        update(sqlUpdateActivo, parameters);
    }

    @Override
    public void compensar(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
                tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());

        update(sqlCompensar, parameters);
    }

    @Override
    public void presenciasHorasFijas(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.HORAS_FIJAS.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

        update(sqlProcesarPresenciasHorasFijas, parameters);
    }

    @Override
    public void presenciasHorasFijasDesplazamiento(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.HORAS_FIJAS.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

        update(sqlProcesarPresenciasHorasFijasDesplazamientos, parameters);
    }
    
    @Override
    public void indicadorPersonaPorVenta(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA, TipoGrupoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());

        update(sqlIndicadorPersonaPorVenta, parameters);
    }

    @Override
    public void indicadorPersonaPorVentaSimplificada(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA_SIMPLIFICADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA, TipoGrupoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION.getId());

        update(sqlIndicadorPersonaPorVentaSimplificada, parameters);
    }

    @Override
    public List<TareaLocalizacionPersonaPresencia> save(final List<TareaLocalizacionPersonaPresencia> src) {
        return saveNamedJdbcBatchList(src, sqlSave, batchSize);
    }

    @Deprecated
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaPresencia entity) throws SQLException {
        pstmt.setString(1, entity.getCclIdCodOrigen());
        pstmt.setString(2, entity.getCclIdOrigen());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setString(4, entity.getStdIdLegEnt());
        pstmt.setString(5, entity.getCclIdSeccion());
        pstmt.setObject(6, entity.getFecha());
        pstmt.setLong(7, entity.getMinutos());
        pstmt.setInt(8, entity.getCodTipoHora());
        pstmt.setBoolean(9, entity.getActivo());
        pstmt.setLong(10, entity.getTipoDato().getId());
        pstmt.setLong(11, entity.getTarea().getId());
        pstmt.setString(12, entity.getCclIdCadena());
        pstmt.setObject(13, entity.getPk().getFechaInicioPeriodo());
    }

}
