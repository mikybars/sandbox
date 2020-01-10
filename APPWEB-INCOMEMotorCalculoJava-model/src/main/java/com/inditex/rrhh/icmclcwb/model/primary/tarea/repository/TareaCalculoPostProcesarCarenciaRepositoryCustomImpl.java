package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import lombok.Getter;

@Repository
public class TareaCalculoPostProcesarCarenciaRepositoryCustomImpl
        extends AbstractTareaCalculoPostProcesarBaseRepositoryCustom
        implements TareaCalculoPostProcesarCarenciaRepositoryCustom {

    @Value("#{primaryQuery['TareaCalculoPostProcesarRepositoryCustom.insert']} #{primaryQuery['TareaCalculoPostProcesarRepositoryCustom.carencia']} #{primaryQuery['TareaCalculoPostProcesarRepositoryCustom.where']}")
    @Getter
    private String sqlPostProcesar;

    @Value("#{primaryQuery['TareaCalculoPostProcesarRepositoryCustom.carencia']} #{primaryQuery['TareaCalculoPostProcesarRepositoryCustom.where']}")
    @Getter
    private String sqlPostProcesarBase;
    
    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public List<TareaCalculoPersonaDto> ids(TareaDto tarea) {
        return tareaCalculoPersonaService.findByTareaAndIdEstadoAndIdTipoPolitica(tarea, TipoPoliticaEnum.CARENCIA.getIdMeta4());
    }

    @Override
    protected Map<String, Object> getMapValues(TareaDto tarea, TareaCalculoPersonaDto persona) {
        Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        if (persona != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getCclIdPerson());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
        }
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.CARENCIA.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

        return map;
    }

}
