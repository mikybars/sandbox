package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustomImpl
        extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
        implements TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom {

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public List<IdPersonaLocalDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
        Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        if (persona != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
        }
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
        List<IdTipoDatoDto> ids = tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
                ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        map.put(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO,
                TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION,
                algoritmo.getTipoComision().stream().map(TipoComisionDto::getId).collect(Collectors.toList()));
        map.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
                algoritmo.getTipoCalculo().stream().map(TipoCalculoDto::getId).collect(Collectors.toList()));
        map.put(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO, algoritmo.getDesplazamiento()
                ? SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE : SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE, algoritmo.getDesplazamientoBase()
                ? SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE : SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        return map;
    }

}
