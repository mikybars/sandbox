package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoManualDesplazamientoBaseV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoManualDesplazamientoBaseV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoManualDesplazamientoBaseV1Repository.calcular']}"
      + " #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoManualDesplazamientoBaseV1Repository.calcular']}"
      + " #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public List<IdPersonaLocalDto> ids(AlgoritmoDTO algoritmo, TareaDto tarea) {
    return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
  }

  @Override
  protected Map<String, Object> getMapValues(AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    Map<String, Object> map = new HashMap<>();
    if (tarea != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    }
    if (persona != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    }
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    List<IdTipoDatoDto> tiposDatoLocalizacionSeccionPersonaTipoHora = tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        tiposDatoLocalizacionSeccionPersonaTipoHora.stream()
            .map(IdTipoDatoDto::getId)
            .collect(Collectors.toList()));
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    List<IdTipoDatoDto> ids = tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    map.put(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.put(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    map.put(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
            .getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_COMISION, TipoComisionEnum.MANUAL.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION,
        algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
    map.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
        algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
    map.put(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO, algoritmo.getDesplazamiento()
        ? SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE
        : SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE, algoritmo.getDesplazamientoBase()
        ? SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE
        : SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    return map;

  }

}
