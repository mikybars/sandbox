package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
public class TareaCalculoAjusteVacacionesRepositoryCustomImpl
    extends AbstractTareaCalculoAjusteBaseRepositoryCustom
    implements TareaCalculoAjusteVacacionesRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.insert']} #{primaryQuery['TareaCalculoAjusteRepositoryCustom.vacaciones']}")
  @Getter
  private String sqlAjustar;

  @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.vacaciones']}")
  @Getter
  private String sqlAjustarBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public List<IdPersonaLocalDto> ids(final TareaDto tarea) {
    return this.tareaCalculoPersonaService.findByTareaAndIdEstadoAndIdTipoPolitica(tarea,
        TipoPoliticaEnum.VACACIONES.getIdMeta4());
  }

  @Override
  protected Map<String, Object> getMapValues(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
      final IdPersonaLocalDto persona) {
    final Map<String, Object> map = new HashMap<>();
    if (tarea != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    }
    if (persona != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    }
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

    return map;
  }

}
