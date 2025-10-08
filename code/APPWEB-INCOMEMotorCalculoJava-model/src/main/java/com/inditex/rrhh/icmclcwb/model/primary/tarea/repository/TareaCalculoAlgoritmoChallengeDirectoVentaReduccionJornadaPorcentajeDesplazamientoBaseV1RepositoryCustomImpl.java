package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl
    extends AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom
    implements TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom {

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery["
      + "'TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['"
      + "TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  /**
   * Implementación común del metodo ids() heredado en las 3 clases hijas.
   *
   * @param algoritmo el algoritmo para el cual buscar personas
   * @param tarea la tarea asociada
   * @return lista de personas locales para el algoritmo
   */
  @Override
  public final List<IdPersonaLocalDto> ids(AlgoritmoDTO algoritmo, TareaDto tarea) {
    return this.tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
  }

  /**
   * Implementación específica para desplazamiento base: Agrega el parámetro específico de indicador de desplazamiento base. El resto de
   * lógica está en la clase padre.
   */
  @Override
  protected void addSpecificMapValues(Map<String, Object> map, AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    // Parámetros de tipo de dato de venta por localización y sección
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        ids.stream().map(IdTipoDatoDto::getId).toList());

    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
  }
}
