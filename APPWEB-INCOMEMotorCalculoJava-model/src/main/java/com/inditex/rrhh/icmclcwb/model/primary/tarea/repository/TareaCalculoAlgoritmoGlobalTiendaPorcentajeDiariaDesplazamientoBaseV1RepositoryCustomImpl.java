package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoGlobalTiendaRepositoryCustom
    implements TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDiariaPresenciaRepository.calcular.where']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDesplazamientoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDiariaPresenciaRepository.calcular.where']}"
      + " #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDesplazamientoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  @Override
  protected Map<String, Object> getMapValues(
      final AlgoritmoDTO algoritmo, final TareaDto tarea, final IdPersonaLocalDto persona) {
    final Map<String, Object> map = super.getMapValues(algoritmo, tarea, persona);
    map.put(SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
            .getId());
    return map;
  }

}
