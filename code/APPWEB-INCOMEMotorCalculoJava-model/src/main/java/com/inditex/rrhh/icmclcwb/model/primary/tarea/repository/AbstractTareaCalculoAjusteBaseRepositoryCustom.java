package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractTareaCalculoAjusteBaseRepositoryCustom
    implements TareaCalculoAjusteBaseRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  private TareaAmbitoService tareaAmbitoService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  protected abstract String getSqlAjustarBase();

  protected abstract Map<String, Object> getMapValues(AlgoritmoAjusteDto algoritmoAjuste, TareaDto tarea,
      IdPersonaLocalDto persona);

  protected abstract String getSqlAjustar();

  @Override
  public String getSqlAjustar(final AlgoritmoAjusteDto algoritmoAjuste) {
    String sql = this.getSqlAjustarBase();
    if (sql != null) {
      sql = SqlParamsUtils.replaceValues(sql, this.getMapValues(algoritmoAjuste, null, null));
    }
    return StringUtils.normalizeSpace(sql);
  }

  @Override
  public void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tareaDto) {
    if (this.getSqlAjustar() != null) {
      final MapSqlParameterSource params = new MapSqlParameterSource();
      SistemaDestinoResponseDto sistemaDestino = SistemaDestinoResponseDto.builder()
          .idSistemaDestino(
              SistemaDestinoEnum.NONE.getIdMeta4())
          .build();
      final List<TareaAmbitoDto> byTarea = this.tareaAmbitoService.findByTarea(tareaDto);
      final String cclIdOrigen = CollectionUtils.isNotEmpty(byTarea) ? byTarea.get(0).getCclIdOrigen() : null;
      if (StringUtils.isNotBlank(cclIdOrigen)) {
        sistemaDestino = this.meta4IcmWsCalcIncomeService
            .getSistemaDestino(SistemaDestinoRequestDto.builder().cclIdOrigen(cclIdOrigen).build());
      }
      params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
      params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
      params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.BAJA_IT.getId());
      params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO, sistemaDestino.getIdSistemaDestino());
      params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL,
          SistemaDestinoEnum.SOLUCION_GLOBAL.getIdMeta4());
      this.namedParameterJdbcTemplate.update(this.getSqlAjustar(), params);
    }
  }

}
