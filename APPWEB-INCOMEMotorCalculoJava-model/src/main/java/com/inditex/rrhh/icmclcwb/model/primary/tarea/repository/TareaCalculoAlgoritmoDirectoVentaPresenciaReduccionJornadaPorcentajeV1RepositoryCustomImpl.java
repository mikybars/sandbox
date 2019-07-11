package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
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
import java.util.stream.Collectors;

@Repository
public class TareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeV1RepositoryCustomImpl
        extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
        implements TareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeV1RepositoryCustom {

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Getter
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
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
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_PERSONA, persona.getIdPersona());
            map.put(SqlPrimaryConstants.SQL_PARAM_OR_PERSONA, persona.getOrPersona());
        }
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
                Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId()));
        List<IdTipoDatoDto> ids = tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
                ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        map.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, 1);
        map.put(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, 0);
        map.put(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, 1);
        map.put(SqlPrimaryConstants.SQL_PARAM_CALCULA, 1);
        return map;
    }

}
