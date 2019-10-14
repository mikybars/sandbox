package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class LimpiezaRepositoryCustomImpl implements LimpiezaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
    
    @Override
    public void limpieza(@NotNull @Valid final TareaDto tarea) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaCalculo, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAgrupacionCadena, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAgrupacionConfiguracion, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAgrupacionPresencia, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAgrupacionVenta, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAmbitoGlobalLocalizacion, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaAmbitoGlobalPersona, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionAbierta, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionCalcular, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionComisionHistorico, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionFestivo, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionHistorico, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionOnlineHistorico, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionPersonaPresencia, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionPersonaVenta, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionPresencia, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaLocalizacionVenta, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaPersonaCoeficiente, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaEstructura, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaEstructuraDesplazamiento, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaEstructuraPolitica, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaPersonaHistorico, arg);
        namedParameterJdbcTemplate.update(sqlLimpiezaTareaTipoHora, arg);
    }

    @Override
    public void consolidar(@NotNull @Valid final TareaDto tarea) {
        // TODO [COMUN] Una vez se borre todo correctamente, se registra que la tarea ya ha sido limpiada
    }

}
