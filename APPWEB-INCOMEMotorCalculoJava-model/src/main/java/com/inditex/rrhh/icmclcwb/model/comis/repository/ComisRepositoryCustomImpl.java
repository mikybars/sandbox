package com.inditex.rrhh.icmclcwb.model.comis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

@Repository
public class ComisRepositoryCustomImpl
        extends JdbcBatchComisRepositoryAbstract<Integer>
        implements ComisRepositoryCustom {

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findPresenciasOrigenAndFecha']}")
    private String sqlFindPresenciasOrigenAndFechaQuery;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findMotivosDesplazamiento']}")
    private String sqlFindMotivosDesplazamiento;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findFechasIncidencias']}")
    private String sqlFindFechasIncidencias;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findFechasDesplazamiento']}")
    private String sqlFindFechasDesplazamiento;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesHistorico']}")
    private String sqlFindCondicionesHistorico;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesDesplazamiento']}")
    private String sqlFindCondicionesDesplazamiento;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesResalta']}")
    private String sqlFindCondicionesResalta;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findBajasIt']}")
    private String sqlFindBajasIt;

    @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCarencia']}")
    private String sqlFindCarencia;

    @Override
    public PresenciaOrigenDto findPresenciasOrigenAndFecha(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_FIN,
                TimeUtils.toDate(tarea.getFechaFinPeriodo()));

        return this.queryForObject(this.sqlFindPresenciasOrigenAndFechaQuery, map,
                (rs, rowNum) -> PresenciaOrigenDto
                    .builder()
                    .horasSeccion1(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_1))
                    .horasSeccion2(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_2))
                    .horasSeccion3(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_3))
                    .horasSeccion4(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_4))
                    .build());
    }

    @Override
    public List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_ID_ORGANIZATION,
                tarea.getIdOrganization());
        return this.query(this.sqlFindMotivosDesplazamiento, map,
                (rs, rowNum) -> IdMotivoDesplazamientoDto
                    .builder()
                    .idMotivoDesplazamiento(rs.getInt(SqlComisConstants.SQL_RESULT_ID_MOTIVO_DESPLAZAMIENTO))
                    .build());
    }


    @Override
    public List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_FIN,
                TimeUtils.toDate(tarea.getFechaFinPeriodo()));

        return this.query(this.sqlFindFechasIncidencias, map,
                (rs, rowNum) -> IdPersonaLocalFechaIncidenciaDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaInicio(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
                    .fechaFin(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
                    .build());
    }

    @Override
    public List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();

        return this.query(this.sqlFindFechasDesplazamiento, map,
                (rs, rowNum) -> IdPersonaLocalFechaIncidenciaDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaInicio(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
                    .fechaFin(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
                    .build());
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
                TimeUtils.toDate(tarea.getFechaFinPeriodo()));

        return this.query(this.sqlFindCondicionesHistorico, map,
                (rs, rowNum) -> IdPersonaLocalCondicionesDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
                    .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
                    .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
                    .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
                    .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
                    .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
                    .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
                    .build());
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
                TimeUtils.toDate(tarea.getFechaFinPeriodo()));

        return this.query(this.sqlFindCondicionesDesplazamiento, map,
                (rs, rowNum) -> IdPersonaLocalCondicionesDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
                    .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
                    .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
                    .cclIdCodOrigenDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
                    .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
                    .idTipoOpcionCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
                    .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
                    .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
                    .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
                    .build());
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findCondicionesResalta(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
                TimeUtils.toDate(tarea.getFechaFinPeriodo()));

        return this.query(this.sqlFindCondicionesResalta, map,
                (rs, rowNum) -> IdPersonaLocalCondicionesDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
                    .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
                    .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
                    .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
                    .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
                    .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
                    .build());
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findBajasIt(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
                TimeUtils.toDate(tarea.getFechaFinPeriodo()));

        return this.query(this.sqlFindBajasIt, map,
                (rs, rowNum) -> IdPersonaLocalCondicionesDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
                    .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
                    .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
                    .build());
    }

    @Override
    public List<IdPersonaLocalCarenciaDto> findCarencia(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();

        return this.query(this.sqlFindCarencia, map,
                (rs, rowNum) -> IdPersonaLocalCarenciaDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
                    .fechaAlta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_ALTA).toLocalDate())
                    .fechaInicioCalculo(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO_CALCULO).toLocalDate())
                    .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
                    .build());
    }

}
