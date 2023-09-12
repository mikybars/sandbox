package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarTiposHoraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class RunTareaAmbitoValidarTiposHoraServiceImpl implements RunTareaAmbitoValidarTiposHoraService {

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeAsyncService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final TareaDto tarea = runTareaDto.getTarea();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<Integer> values = new ArrayList<>();
    try {
      final CompletableFuture<TiposHoraResponseDto> cfTiposHora = this.meta4IcmWsCalcIncomeAsyncService
          .getTiposHora(TiposHoraRequestDto.builder().idOrigen(tareaAmbito.getCclIdOrigen())
              .idsEmpresa(Collections.singletonList(tarea.getStdIdLegEnt())).build());
      AsyncUtils.exceptionally(cfTiposHora, cf);

      Integer idCatalogo = null;
      if (AppConstants.ID_ORIGEN_SPAIN.equals(tareaAmbito.getCclIdOrigen())) {
        final CatalogoResponseDto response = this.meta4IcmWsCalcIncomeService
            .getCatalogo(CatalogoRequestDto
                .builder()
                .cclIdOrigen(tareaAmbito.getCclIdOrigen())
                .items(Arrays
                    .asList(CatalogoRequestItemDto
                        .builder()
                        .stdIdLegEnt(runTareaDto.getTarea().getStdIdLegEnt())
                        .build()))
                .build());
        if ((response != null)
            && CollectionUtils.isNotEmpty(response.getItems())
            && StringUtils.isNotBlank(response.getItems().get(0).getIdCatalogo())) {
          idCatalogo = Integer.parseInt(response.getItems().get(0).getIdCatalogo());
        } else {
          throw new IcmclcwbException("No se ha podido recuperar el id de catalogo para realizar la validacion");
        }
      }

      final CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfTiposHoraPtr = this.ptrPresenciaAsyncService
          .tiposHoras(PtrPresenciaTiposHorasRequestDto.builder().origen(Integer.valueOf(tareaAmbito.getCclIdOrigen()))
              .idCatalogoAplicacion(idCatalogo).build());
      AsyncUtils.exceptionally(cfTiposHoraPtr, cf);

      AsyncUtils.waitAllOfIsOk(cf, cf);

      final PtrPresenciaTiposHorasResponseDto tiposHoraPtr = AsyncUtils.get(cfTiposHoraPtr);
      final TiposHoraResponseDto tiposHoraMeta4 = AsyncUtils.get(cfTiposHora);

      final List<Integer> tiposHoraPtrPlain = tiposHoraPtr.getTiposHoras().stream().map(e -> e.getTipoHora()).collect(Collectors.toList());
      final List<Integer> tiposHoraMeta4Plain =
          tiposHoraMeta4.getItems().stream().map(e -> Integer.valueOf(e.getIdTipoHora())).collect(Collectors.toList());

      final List<Integer> diff1 = new ArrayList<>(tiposHoraPtrPlain);
      diff1.removeAll(tiposHoraMeta4Plain);

      final List<Integer> diff2 = new ArrayList<>(tiposHoraMeta4Plain);
      diff2.removeAll(tiposHoraPtrPlain);

      values.addAll(diff1);
      values.addAll(diff2);

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, values.size() == 0);
  }
}
