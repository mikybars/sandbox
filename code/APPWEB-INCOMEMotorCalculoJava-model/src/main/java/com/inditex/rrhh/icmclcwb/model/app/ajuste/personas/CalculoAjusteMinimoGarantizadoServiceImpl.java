package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteMinimoGarantizadoService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculoAjusteMinimoGarantizadoServiceImpl extends AbstractCalculoAjusteBaseService implements
    CalculoAjusteMinimoGarantizadoService {

  private final PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  private final TareaCalculoAjusteMinimoGarantizadoRepositoryCustom tareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

  @Override
  protected void precondiciones(final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMaximoMinimoGarantizado();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMaximoMinimoGarantizado();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaximoMinimoGarantizado();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.MINIMO_GARANTIZADO);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjuste(
        Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES, TipoPoliticaEnum.BAJA_IT));
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoMinimoGarantizado();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempDatosMaximoMinimoGarantizado();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMininimoGarantizado();
  }

  @Override
  protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tareaDto) {
    this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom.ajustar(algoritmoAjuste, tareaDto);
  }

  @Override
  protected void postcondiciones() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMaximoMinimoGarantizado();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoMinimoGarantizado();
  }

}
