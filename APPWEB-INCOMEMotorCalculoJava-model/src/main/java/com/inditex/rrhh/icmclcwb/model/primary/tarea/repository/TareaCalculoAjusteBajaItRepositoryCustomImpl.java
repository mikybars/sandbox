package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAjusteBajaItRepositoryCustomImpl
    extends AbstractTareaCalculoAjusteBaseRepositoryCustom
    implements TareaCalculoAjusteBajaItRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.insert']} #{primaryQuery['TareaCalculoAjusteRepositoryCustom.bajaIt']}")
  @Getter
  private String sqlAjustar;

  @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.bajaIt']} ")
  @Getter
  private String sqlAjustarBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private TareaAmbitoService tareaAmbitoService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Override
  public List<IdPersonaLocalDto> ids(final TareaDto tarea) {
    return this.tareaCalculoPersonaService.findByTareaAndIdEstadoAndIdTipoPolitica(tarea,
        TipoPoliticaEnum.BAJA_IT.getIdMeta4());
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

    SistemaDestinoResponseDto sistemaDestino = SistemaDestinoResponseDto.builder()
        .idSistemaDestino(
            SistemaDestinoEnum.NONE.getIdMeta4())
        .build();
    final List<TareaAmbitoDto> byTarea = this.tareaAmbitoService.findByTarea(tarea);
    final String cclIdOrigen = CollectionUtils.isNotEmpty(byTarea) ? byTarea.get(0).getCclIdOrigen() : null;
    if (StringUtils.isNotBlank(cclIdOrigen)) {
      sistemaDestino = this.meta4IcmWsCalcIncomeService
          .getSistemaDestino(SistemaDestinoRequestDto.builder().cclIdOrigen(cclIdOrigen).build());
    }

    map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.BAJA_IT.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO, sistemaDestino);
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL,
        SistemaDestinoEnum.SOLUCION_GLOBAL.getIdMeta4());
    return map;
  }

}
