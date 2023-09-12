package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoGlobalTiendaRepositoryCustom
    implements TareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['"
      + "TareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}"
      + "#{calculoPrimaryQuery['PersonasPorVentaNoVendedores.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['"
      + "TareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}"
      + "#{calculoPrimaryQuery['PersonasPorVentaNoVendedores.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  @Override
  protected Map<String, Object> getMapValues(final AlgoritmoDTO algoritmo, final TareaDto tarea, final IdPersonaLocalDto persona) {
    final Map<String, Object> map = super.getMapValues(algoritmo, tarea, persona);
    final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    final List<IdTipoDatoDto> tiposDatoVentaFisica = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.GLOBAL_SECCION.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        tiposDatoVentaFisica.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    map.put(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPO_HORA_DESPLAZAMIENTO.getId());

    return map;
  }

}
