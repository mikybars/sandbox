package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarRecuperarFranciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarRecuperarFranciaServiceImpl implements RunTareaAmbitoValidarRecuperarFranciaService {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private ComisRepositoryCustom comisRepositoryCustom;

  @Autowired
  private PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  @Qualifier("carenciaProperties")
  private PrevalidarPropertiesDto carenciaProperties;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final TareaDto tarea = runTareaDto.getTarea();
    final List<IdPersonaLocalDto> personas;
    try {
      personas = this.comisRepositoryCustom
          .validateTempComisRecuperarFrancia(runTareaDto.getTarea());
      final LiquidacionRequestDto request = new LiquidacionRequestDto();
      final List<LiquidacionFilterParametersDto> filterParameters = personas
          .stream()
          .map(
              f -> LiquidacionFilterParametersDto.builder()
                  .idOrigen(tareaAmbito.getCclIdOrigen())
                  .idEmpresa(tarea.getStdIdLegEnt())
                  .idEmpleado(f.getIdPersonaLocal())
                  .orEmpleado(f.getStdOrHrPeriod())
                  .fechainicio(tarea.getFechaInicioPeriodo())
                  .fechaFin(tarea.getFechaFinPeriodo())
                  .build())
          .collect(Collectors.toList());
      final LiquidacionFilterDto filter = LiquidacionFilterDto.builder()
          .items(filterParameters)
          .build();
      request.setData(filter);

      if (!personas.isEmpty()) {
        this.meta4IcmWsCalcIncomeService.liquidacion(request);
      }

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }
}
