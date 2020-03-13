package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepositoryCustom;

@Repository
public class LimpiezaRepositoryCustomImpl implements LimpiezaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionHistoricoRepositoryCustom tareaLocalizacionHistoricoRepositoryCustom;

    // Consultas de obtencion de personas
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaCalculo']}")
    private String sqlPersonasTareaCalculo;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaCalculoAjuste']}")
    private String sqlPersonasTareaCalculoAjuste;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersona']}")
    private String sqlPersonasTareaAmbitoGlobalLocalizacionPersona;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersonaDesplazamiento']}")
    private String sqlPersonasTareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersonaPresencia']}")
    private String sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresencia;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersonaPresenciaManual']}")
    private String sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalPersona']}")
    private String sqlPersonasTareaAmbitoGlobalPersona;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaLocalizacionPersonaPresencia']}")
    private String sqlPersonasTareaLocalizacionPersonaPresencia;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaLocalizacionPersonaVenta']}")
    private String sqlPersonasTareaLocalizacionPersonaVenta;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaPersonaCoeficiente']}")
    private String sqlPersonasTareaPersonaCoeficiente;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaEstructura']}")
    private String sqlPersonasTareaEstructura;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaEstructuraPolitica']}")
    private String sqlPersonasTareaEstructuraPolitica;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaPersonaHistorico']}")
    private String sqlPersonasTareaPersonaHistorico;

    // Consultas de limpieza
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaCalculo']}")
    private String sqlLimpiezaTareaCalculo;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaCalculoAjuste']}")
    private String sqlLimpiezaTareaCalculoAjuste;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionCadena']}")
    private String sqlLimpiezaTareaAgrupacionCadena;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionConfiguracion']}")
    private String sqlLimpiezaTareaAgrupacionConfiguracion;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionPresencia']}")
    private String sqlLimpiezaTareaAgrupacionPresencia;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionVenta']}")
    private String sqlLimpiezaTareaAgrupacionVenta;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacion']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacion;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersona']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLozalizacionPersonaDesplazamiento']}")
    private String sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersonaPresencia']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersonaPresenciaManual']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalPersona']}")
    private String sqlLimpiezaTareaAmbitoGlobalPersona;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionAbierta']}")
    private String sqlLimpiezaTareaLocalizacionAbierta;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionCalcular']}")
    private String sqlLimpiezaTareaLocalizacionCalcular;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionComisionHistorico']}")
    private String sqlLimpiezaTareaLocalizacionComisionHistorico;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionFestivo']}")
    private String sqlLimpiezaTareaLocalizacionFestivo;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionHistorico']}")
    private String sqlLimpiezaTareaLocalizacionHistorico;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionOnlineHistorico']}")
    private String sqlLimpiezaTareaLocalizacionOnlineHistorico;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPersonaPresencia']}")
    private String sqlLimpiezaTareaLocalizacionPersonaPresencia;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPersonaVenta']}")
    private String sqlLimpiezaTareaLocalizacionPersonaVenta;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPresencia']}")
    private String sqlLimpiezaTareaLocalizacionPresencia;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionVenta']}")
    private String sqlLimpiezaTareaLocalizacionVenta;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaCoeficiente']}")
    private String sqlLimpiezaTareaPersonaCoeficiente;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructura']}")
    private String sqlLimpiezaTareaEstructura;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructuraDesplazamiento']}")
    private String sqlLimpiezaTareaEstructuraDesplazamiento;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructuraPolitica']}")
    private String sqlLimpiezaTareaEstructuraPolitica;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaHistorico']}")
    private String sqlLimpiezaTareaPersonaHistorico;
    
    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaTipoHora']}")
    private String sqlLimpiezaTareaTipoHora;

    @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaConfiguracion']}")
    private String sqlLimpiezaTareaConfiguracion;
    
    @Value("${app.envars.limpieza.batch-size.default:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Override
    public void limpieza(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito) {
        
        List<MapSqlParameterSource> cclIdCodOrigenBatchArgs = getParametersLocal(tarea, ambito);
        List<MapSqlParameterSource> stdIdWorkLocatBatchArgs = getParametersMeta4(tarea, ambito);
        List<MapSqlParameterSource> idTareaBatchArgs = getParametersTarea(tarea);

        List<MapSqlParameterSource> parametersPersonaTareaCalculo = getParametersPersonaLocalStdOrPeriod(tarea, sqlPersonasTareaCalculo);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaCalculo, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaCalculo,
                    iter.toArray(new MapSqlParameterSource[0]));
        }

        List<MapSqlParameterSource> parametersPersonaTareaCalculoAjuste = getParametersPersonaLocalStdOrPeriod(tarea, sqlPersonasTareaCalculoAjuste);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaCalculoAjuste, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaCalculoAjuste,
                iter.toArray(new MapSqlParameterSource[0]));
        }
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionCadena,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionConfiguracion,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionPresencia,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionVenta,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
        
        limpiezaTareaAmbitoLocalizacion(stdIdWorkLocatBatchArgs);

        limpiezaTareaGlobalLocalizacionPersona(tarea);

        limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);

        limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);

        limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);

        limpiezaTareaAmbitoGlobalPersona(tarea);


        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionAbierta,
                iter.toArray(new MapSqlParameterSource[0]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionCalcular,
                iter.toArray(new MapSqlParameterSource[0]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionComisionHistorico,
                iter.toArray(new MapSqlParameterSource[0]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionFestivo,
                iter.toArray(new MapSqlParameterSource[0]));
        }

        limpiezaTareaLocalizacionHistorico(tarea);
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionOnlineHistorico,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

        List<MapSqlParameterSource> parametersPersonaTareaLocalizaconPersonaPresencia =
            getParametersPersonaLocal(tarea, sqlPersonasTareaLocalizacionPersonaPresencia);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaLocalizaconPersonaPresencia, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionPersonaPresencia,
                    iter.toArray(new MapSqlParameterSource[0]));
        }

        List<MapSqlParameterSource> parametersPersonaTareaLocalizaconPersonaVenta =
            getParametersPersonaLocal(tarea, sqlPersonasTareaLocalizacionPersonaVenta);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaLocalizaconPersonaVenta, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionPersonaVenta,
                    iter.toArray(new MapSqlParameterSource[0]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionPresencia,
                    iter.toArray(new MapSqlParameterSource[0]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionVenta,
                    iter.toArray(new MapSqlParameterSource[0]));
        }

        List<MapSqlParameterSource> parametersPersonaTareaPersonaCoeficiente =
            getParametersPersonaLocalStdOrPeriod(tarea, sqlPersonasTareaPersonaCoeficiente);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaPersonaCoeficiente, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaPersonaCoeficiente,
                iter.toArray(new MapSqlParameterSource[0]));
        }

        List<MapSqlParameterSource> parametersPersonaTareaEstructura = getParametersPersonaLocalStdOrPeriod(tarea, sqlPersonasTareaEstructura);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaEstructura, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaEstructura,
                iter.toArray(new MapSqlParameterSource[0]));
        }

        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaEstructuraDesplazamiento,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

        List<MapSqlParameterSource> parametersPersonaTareaEstructuraPolitica =
            getParametersPersonaLocalStdOrPeriod(tarea, sqlPersonasTareaEstructuraPolitica);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaEstructuraPolitica, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaEstructuraPolitica,
                iter.toArray(new MapSqlParameterSource[0]));
        }

        limpiezaTareaPersonaHistorico(tarea);

        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaTipoHora,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaConfiguracion,
            idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
        
    }


    @Override
    public void limpiezaTareaPersonaHistorico(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> parametersPersonaTareaPersonaHistorico =
            getParametersPersonaLocalStdOrPeriod(tarea, sqlPersonasTareaPersonaHistorico);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaPersonaHistorico, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaPersonaHistorico,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void limpiezaTareaLocalizacionHistorico(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> idTareaBatchArgs = getParametersTarea(tarea);
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionHistorico,
            idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
    }

    @Override
    public void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersona =
            getParametersPersonaLocal(tarea, sqlPersonasTareaAmbitoGlobalLocalizacionPersona);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersona, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento =
            getParametersPersonaLocal(tarea, sqlPersonasTareaAmbitoGlobalLocalizacionPersonaDesplazamiento);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresencia =
            getParametersPersonaLocal(tarea, sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresencia);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresencia, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito) {
        List<MapSqlParameterSource> stdIdWorkLocatBatchArgs = getParametersMeta4(tarea, ambito);
        limpiezaTareaAmbitoLocalizacion(stdIdWorkLocatBatchArgs);
    }

    private void limpiezaTareaAmbitoLocalizacion(List<MapSqlParameterSource> stdIdWorkLocatBatchArgs) {
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacion,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual =
            getParametersPersonaLocal(tarea, sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresenciaManual);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid TareaDto tarea) {
        List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalPersona =
            getParametersPersonaLocal(tarea, sqlPersonasTareaAmbitoGlobalPersona);
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaAmbitoGlobalPersona, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalPersona,
                iter.toArray(new MapSqlParameterSource[0]));
        }
    }

    @Override
    public void consolidar(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TrabajoDto trabajo) {
        tareaLimpiezaRepositoryCustom.mergeLimpieza(tarea, trabajo);
    }
    
    private List<MapSqlParameterSource> getParametersLocal(final TareaDto tarea, TareaAmbitoDto ambito) {
        List<String> tiendas = tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(tarea.getId(),
            ambito.getCclIdOrigen()).stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList());
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        
        tiendas.forEach(tienda -> {
            Map<String, Object> map = new HashMap<>();
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, tienda);
            MapSqlParameterSource arg = new MapSqlParameterSource();
            map.forEach(arg::addValue);
            batchArgs.add(arg);
        });
        return batchArgs;
    }
    
    private List<MapSqlParameterSource> getParametersMeta4(final TareaDto tarea, TareaAmbitoDto ambito) {
        List<String> tiendas = tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(tarea.getId(),
            ambito.getCclIdOrigen()).stream().map(IdLocalizacionDto::getId).collect(Collectors.toList());
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        
        tiendas.forEach(tienda -> {
            Map<String, Object> map = new HashMap<>();
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_ID_WORK_LOCAT, tienda);
            MapSqlParameterSource arg = new MapSqlParameterSource();
            map.forEach(arg::addValue);
            batchArgs.add(arg);
        });
        return batchArgs;
    }
    
    private List<MapSqlParameterSource> getParametersTarea(final TareaDto tarea) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        }
        MapSqlParameterSource arg = new MapSqlParameterSource();
        map.forEach(arg::addValue);
        batchArgs.add(arg);
        return batchArgs;
    }

    private List<MapSqlParameterSource> getParametersPersonaLocal(final TareaDto tarea, String sql) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        List<IdPersonaLocalDto> personas = findIdPersonaByIdTarea(tarea, sql);
        personas.forEach(persona -> {
            Map<String, Object> map = new HashMap<>();
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
            map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
            MapSqlParameterSource arg = new MapSqlParameterSource();
            map.forEach(arg::addValue);
            batchArgs.add(arg);
        });
        return batchArgs;
    }

    private List<MapSqlParameterSource> getParametersPersonaLocalStdOrPeriod(final TareaDto tarea, String sql) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        List<IdPersonaLocalDto> personas = findIdPersonaStdOrPeriodByIdTarea(tarea, sql);
        personas.forEach(persona -> {
            Map<String, Object> map = new HashMap<>();
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
            map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
            MapSqlParameterSource arg = new MapSqlParameterSource();
            map.forEach(arg::addValue);
            batchArgs.add(arg);
        });
        return batchArgs;
    }

    private List<IdPersonaLocalDto> findIdPersonaByIdTarea(final TareaDto tarea, String sql) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        return namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) ->
            IdPersonaLocalDto
                .builder()
                .idPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
            .build());
    }

    private List<IdPersonaLocalDto> findIdPersonaStdOrPeriodByIdTarea(final TareaDto tarea, String sql) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        return namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) ->
            IdPersonaLocalDto
                .builder()
                .idPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
                .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
                .build());
    }

}
