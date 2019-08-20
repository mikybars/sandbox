package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoBaseV1RepositoryCustom {

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoBaseV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeDesplazamientoBaseV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, TareaCalculoPersonaDto persona) {
        //TODO: revisar parámetros de la consulta
        Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        if (persona != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getCclIdPerson());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
        }
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
            Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId()));
        map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
            Arrays.asList(TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId(),
                TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
                TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId()));
        map.put(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        return map;
    }

}
