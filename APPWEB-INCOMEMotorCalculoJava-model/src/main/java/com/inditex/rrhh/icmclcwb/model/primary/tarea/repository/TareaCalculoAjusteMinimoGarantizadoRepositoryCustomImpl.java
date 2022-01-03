package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl
    extends AbstractTareaCalculoAjusteBaseRepositoryCustom
    implements TareaCalculoAjusteMinimoGarantizadoRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.insert']} "
      + "#{primaryQuery['TareaCalculoAjusteRepositoryCustom.minGarantizado']}")
  @Getter
  private String sqlAjustar;

  @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.minGarantizado']}")
  @Getter
  private String sqlAjustarBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public List<IdPersonaLocalDto> ids(TareaDto tarea) {
    return tareaCalculoPersonaService.findByTareaAndIdEstadoAndIdTipoPolitica(tarea,
        TipoPoliticaEnum.MINIMO_GARANTIZADO.getIdMeta4());
  }

  @Override
  protected Map<String, Object> getMapValues(AlgoritmoAjusteDto algoritmoAjuste, TareaDto tarea,
      IdPersonaLocalDto persona) {
    Map<String, Object> map = new HashMap<>();
    if (tarea != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    }
    if (persona != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    }
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.MINIMO_GARANTIZADO.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
        Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4(),
            TipoPoliticaEnum.VACACIONES.getIdMeta4(),
            TipoPoliticaEnum.BAJA_IT.getIdMeta4()));
    map.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

    return map;
  }

}
