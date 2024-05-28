package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarMotivosDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class RunTareaAmbitoValidarMotivosDesplazamientoServiceImpl
    implements RunTareaAmbitoValidarMotivosDesplazamientoService {

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Autowired
  private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeAsyncService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<IdMotivoDesplazamientoDto> motivos;
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<List<IdMotivoDesplazamientoDto>> cfMotivoDesplazamiento = this.comisAsyncService
          .findMotivoDesplazamiento(runTareaDto, tareaAmbito);
      AsyncUtils.exceptionally(cfMotivoDesplazamiento, cf);

      final CompletableFuture<MotivosDesplazamientoResponseDto> cfMotivosDesplazamientoMeta4 = this.meta4IcmWsCalcIncomeAsyncService
          .getMotivosDesplazamiento(MotivosDesplazamientoRequestDto
              .builder()
              .items(Arrays.asList(
                  MotivosDesplazamientoRequestItemDto
                      .builder()
                      .idOrigen(tareaAmbito.getCclIdOrigen())
                      .build()))
              .build());
      AsyncUtils.exceptionally(cfMotivosDesplazamientoMeta4, cf);

      AsyncUtils.waitAllOfIsOk(cf, cf);

      final List<IdMotivoDesplazamientoDto> motivosSil = AsyncUtils.get(cfMotivoDesplazamiento);
      final MotivosDesplazamientoResponseDto motivosmeta4 = AsyncUtils.get(cfMotivosDesplazamientoMeta4);

      this.primaryTemporaryTableRepositoryCustom.createTempMotivoDesplazamientoComis();
      this.primaryTemporaryTableRepositoryCustom.createTempMotivoDesplazamientoMeta4();

      this.primaryTemporaryTableRepositoryCustom.insertTempMotivoDesplazamientoComis(motivosSil);
      this.primaryTemporaryTableRepositoryCustom.insertTempMotivoDesplazamientoMeta4(
          this.validacionMapper
              .motivosDesplazamientoItemDtoToIdMotivoDesplazamientoDto(motivosmeta4.getItems()));

      motivos = this.primaryTemporaryTableRepositoryCustom
          .validateTempMotivoDesplazamiento();

      this.primaryTemporaryTableRepositoryCustom.deleteTempMotivoDesplazamientoComis();
      this.primaryTemporaryTableRepositoryCustom.deleteTempMotivoDesplazamientoMeta4();

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.idMotivoDesplazamientoDtoToValidacionDto(tareaAmbito, tareaFaseAccion, motivos);
  }

}
