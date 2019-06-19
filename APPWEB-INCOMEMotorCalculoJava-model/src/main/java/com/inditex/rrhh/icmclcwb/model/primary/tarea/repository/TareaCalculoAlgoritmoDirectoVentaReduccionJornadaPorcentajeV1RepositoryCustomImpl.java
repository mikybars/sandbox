package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustomImpl
        implements TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;
    
    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    public void calcular(AlgoritmoDto algoritmo, TareaDto tarea, List<TareaCalculoPersonaDto> personas) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        personas.forEach(persona -> {
            MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PERSONA, persona.getIdPersona());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_OR_PERSONA, persona.getOrPersona());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA, Arrays.asList(TipoDatoEnum.MINUTOS_INDIVIDUAL.getId(), TipoDatoEnum.MINUTOS_INDIVIDUAL_MANUAL.getId()));
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA, Arrays.asList(TipoDatoEnum.MINUTOS_TOTALES.getId(), TipoDatoEnum.MINUTOS_TOTALES_COMPENSADO.getId()));
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION, Arrays.asList(
                    TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                    TipoDatoEnum.IMPORTE_VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId(),
                    TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId()));
            batchArgs.add(arg);
        });
        namedParameterJdbcTemplate.batchUpdate(sqlCalcular,
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        return StringUtils.normalizeSpace(sqlCalcularBase);
    }

}
