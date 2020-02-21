package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
//import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;
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

    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaCalculo']}")
    private String sqlLimpiezaTareaCalculo;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionCadena']}")
    private String sqlLimpiezaTareaAgrupacionCadena;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionConfiguracion']}")
    private String sqlLimpiezaTareaAgrupacionConfiguracion;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionPresencia']}")
    private String sqlLimpiezaTareaAgrupacionPresencia;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionVenta']}")
    private String sqlLimpiezaTareaAgrupacionVenta;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacion']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacion;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersona']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLozalizacionPersonaDesplazamiento']}")
    private String sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersonaPresencia']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersonaPresenciaManual']}")
    private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalPersona']}")
    private String sqlLimpiezaTareaAmbitoGlobalPersona;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionAbierta']}")
    private String sqlLimpiezaTareaLocalizacionAbierta;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionCalcular']}")
    private String sqlLimpiezaTareaLocalizacionCalcular;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionComisionHistorico']}")
    private String sqlLimpiezaTareaLocalizacionComisionHistorico;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionFestivo']}")
    private String sqlLimpiezaTareaLocalizacionFestivo;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionHistorico']}")
    private String sqlLimpiezaTareaLocalizacionHistorico;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionOnlineHistorico']}")
    private String sqlLimpiezaTareaLocalizacionOnlineHistorico;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPersonaPresencia']}")
    private String sqlLimpiezaTareaLocalizacionPersonaPresencia;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPersonaVenta']}")
    private String sqlLimpiezaTareaLocalizacionPersonaVenta;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPresencia']}")
    private String sqlLimpiezaTareaLocalizacionPresencia;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionVenta']}")
    private String sqlLimpiezaTareaLocalizacionVenta;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaCoeficiente']}")
    private String sqlLimpiezaTareaPersonaCoeficiente;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructura']}")
    private String sqlLimpiezaTareaEstructura;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructuraDesplazamiento']}")
    private String sqlLimpiezaTareaEstructuraDesplazamiento;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructuraPolitica']}")
    private String sqlLimpiezaTareaEstructuraPolitica;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaHistorico']}")
    private String sqlLimpiezaTareaPersonaHistorico;
    
    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaTipoHora']}")
    private String sqlLimpiezaTareaTipoHora;

    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tareaConfiguracion']}")
    private String sqlLimpiezaTareaConfiguracion;
    
    @Value("${app.envars.limpieza.batch-size.default:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Override
    public void limpieza(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito) {
        
        List<MapSqlParameterSource> cclIdCodOrigenBatchArgs = getParametersLocal(tarea, ambito);
        List<MapSqlParameterSource> stdIdWorkLocatBatchArgs = getParametersMeta4(tarea, ambito);
        List<MapSqlParameterSource> idTareaBatchArgs = getParametersTarea(tarea);
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionCadena,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionConfiguracion,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionPresencia,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAgrupacionVenta,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacion,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaAmbitoGlobalPersona,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionAbierta,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionCalcular,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionComisionHistorico,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionFestivo,
                iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionHistorico,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionOnlineHistorico,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
            
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionPersonaPresencia,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionPersonaVenta,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionPresencia,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaLocalizacionVenta,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaPersonaCoeficiente,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaEstructura,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaEstructuraDesplazamiento,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaEstructuraPolitica,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaPersonaHistorico,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
        
        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaTipoHora,
                idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));

        namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaConfiguracion,
            idTareaBatchArgs.toArray(new MapSqlParameterSource[idTareaBatchArgs.size()]));
        
        for (List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, batchSize)) {
            namedParameterJdbcTemplate.batchUpdate(sqlLimpiezaTareaCalculo,
                    iter.toArray(new MapSqlParameterSource[iter.size()]));
        }
    }

    @Override
    public void consolidar(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TrabajoDto trabajo) {
        tareaLimpiezaRepositoryCustom.mergeLimpieza(tarea, trabajo);
    }
    
    private List<MapSqlParameterSource> getParametersLocal(final TareaDto tarea, TareaAmbitoDto ambito) {
        List<String> tiendas = tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(tarea.getId(), ambito.getCclIdOrigen()).stream().map(e -> e.getId()).collect(Collectors.toList());
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        
        tiendas.forEach(tienda -> {
            Map<String, Object> map = new HashMap<>();
            if (tarea != null) {
                map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            }
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, tienda);
            MapSqlParameterSource arg = new MapSqlParameterSource();
            map.forEach((paramName, value) -> arg.addValue(paramName, value));
            batchArgs.add(arg);
        });
        return batchArgs;
    }
    
    private List<MapSqlParameterSource> getParametersMeta4(final TareaDto tarea, TareaAmbitoDto ambito) {
        List<String> tiendas = tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(tarea.getId(), ambito.getCclIdOrigen()).stream().map(e -> e.getId()).collect(Collectors.toList());
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        
        tiendas.forEach(tienda -> {
            Map<String, Object> map = new HashMap<>();
            if (tarea != null) {
                map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            }
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_ID_WORK_LOCAT, tienda);
            MapSqlParameterSource arg = new MapSqlParameterSource();
            map.forEach((paramName, value) -> arg.addValue(paramName, value));
            batchArgs.add(arg);
        });
        return batchArgs;
    }
    
    private List<MapSqlParameterSource> getParametersTarea(final TareaDto tarea) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        MapSqlParameterSource arg = new MapSqlParameterSource();
        map.forEach((paramName, value) -> arg.addValue(paramName, value));
        batchArgs.add(arg);
        return batchArgs;
    }



}
