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
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;

import javax.validation.Valid;
import org.slf4j.Logger;
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
  private ComisService comisService;

  @Autowired
  private PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  @Qualifier("carenciaProperties")
  private PrevalidarPropertiesDto carenciaProperties;

  @Autowired
  private Logger log;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final TareaDto tarea = runTareaDto.getTarea();
    final List<IdPersonaLocalDto> idPersonaLocalComis;
    List<IdPersonaLocalDto> persona = new ArrayList<>();
    LiquidacionResponseDto liquidacion = new LiquidacionResponseDto();

    try {
      idPersonaLocalComis = this.comisService
          .validateTempComisRecuperarFrancia(runTareaDto, tareaAmbito);

      if (!idPersonaLocalComis.isEmpty()) {
        persona =
            this.periodoCalculoPersonaRepositoryCustom.findEmpleadosValidarRecuperar(runTareaDto, tareaAmbito,
                idPersonaLocalComis.stream().map(e -> e.getIdPersonaLocal()).collect(
                    Collectors.toList()));
      }

      if (!persona.isEmpty()) {
        final LiquidacionRequestDto request = new LiquidacionRequestDto();

        final List<LiquidacionFilterParametersDto> filterParameters = persona
            .stream()
            .map(
                f -> LiquidacionFilterParametersDto.builder()
                    .idOrigen(tareaAmbito.getCclIdOrigen())
                    .idEmpresa(tarea.getStdIdLegEnt())
                    .idEmpleado(f.getIdPersonaLocal())
                    .orEmpleado(f.getStdOrHrPeriod())
                    .fechaFin(tarea.getFechaFinPeriodo())
                    .build())
            .collect(Collectors.toList());
        final LiquidacionFilterDto filter = LiquidacionFilterDto.builder()
            .items(filterParameters)
            .build();
        request.setData(filter);
        liquidacion = this.meta4IcmWsCalcIncomeService.liquidacion(request);

        liquidacion.getData().stream().filter(e -> e.getResultado().equals("KO"))
            .forEach(e -> e.getAvisos().getAvisos().stream().forEach(f -> {
              this.log.warn("Aviso: Registro afectado:" + f.getRegistroAfectado());
            }));

        liquidacion.getData().stream().filter(e -> e.getResultado().equals("KO"))
            .forEach(e -> e.getErrores().getErrores().stream().forEach(f -> {
              this.log.warn("Error: Registro afectado:" + f.getRegistroAfectado());
            }));
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
