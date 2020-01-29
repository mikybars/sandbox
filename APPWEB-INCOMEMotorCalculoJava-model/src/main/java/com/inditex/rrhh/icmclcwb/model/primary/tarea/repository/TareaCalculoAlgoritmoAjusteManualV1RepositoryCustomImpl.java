package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import lombok.Getter;

@Repository
public class TareaCalculoAlgoritmoAjusteManualV1RepositoryCustomImpl extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
        implements TareaCalculoAlgoritmoAjusteManualV1RepositoryCustom {

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoAjusteManualV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoAjusteManualV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcularBase;
    
    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;
    
    @Autowired
    private TipoDatoService tipoDatoService;
    
    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, TareaCalculoPersonaDto persona) {
        Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        if (persona != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getCclIdPerson());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
        }
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        map.put(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        return map;
        
    }

}
