package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialAsyncService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaAmbitoRecolectarSlrhorcomsServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private SlrHorarioComercialService slrHorarioComercialService;

  @Mock
  private SlrHorarioComercialAsyncService slrHorarioComercialAsyncService;

  @Mock
  private TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Mock
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Mock
  @Qualifier("slrhorcomsProperties")
  private Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

  @Spy
  @InjectMocks
  RunTareaAmbitoRecolectarSlrhorcomsServiceImpl runTareaAmbitoRecolectarSlrhorcomsServiceImpl;

  @Random
  RunTareaDto runTarea;

  @Random
  TareaAmbitoDto tareaAmbito;

  @Test
  void horarioComercialFestivoByRunTareaAndTareaAmbito(@Random(type = IdEmpresaDto.class, size = 1) List<IdEmpresaDto> idEmpresaDtoList,
      @Random(type = IdLocalizacionLocalDto.class, size = 1) List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList,
      @Random SlrhorcomsPropertiesDto slrhorcomsPropertiesDto,
      @Random HorarioComercialFestivosRequestDto request,
      @Random CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> cfHorarioComercialFestivos,
      @Random ResponseDto<HorarioComercialFestivoDocDto> data,
      @Random CompletableFuture<Void> cfSave) {

    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {

      ResponseDto<HorarioComercialFestivoDocDto> spiedData = Mockito.spy(data);
      Mockito.when(spiedData.isHasNext()).thenReturn(false);

      utilities.when(() -> AsyncUtils.get(cfHorarioComercialFestivos))
          .thenReturn(spiedData);

      doReturn(true).when(this.tareaPersonaEstructuraService).calcularFestivos(this.runTarea.getTarea());

      doReturn(idEmpresaDtoList).when(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());
      List<String> empresasAmbito = idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList());

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
              this.tareaAmbito.getCclIdOrigen(), empresasAmbito);
      doReturn(slrhorcomsPropertiesDto).when(this.slrhorcomsProperties)
          .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO);
      List<IdLocalizacionLocalDto> iter =
          StreamUtils.partition(idLocalizacionLocalDtoList, slrhorcomsPropertiesDto.getMaxFilterSize())
              .stream().findFirst().orElse(null);

      doReturn(request).when(this.tareaMapper).mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoDtoToHorarioComercialFestivosRequestDto(
          this.runTarea.getTrabajo(), this.runTarea.getTarea(), this.tareaAmbito);
      // Acondicionamiento de request
      request.setRows(slrhorcomsPropertiesDto.getRows());
      request.setIdTienda(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));
      request.setStart(0);

      doReturn(cfHorarioComercialFestivos).when(this.slrHorarioComercialAsyncService).horarioComercialFestivos(request);

      doReturn(cfSave).when(this.tareaLocalizacionFestivoAsyncService).save(data.getDocs(), this.runTarea.getTarea());

      this.runTareaAmbitoRecolectarSlrhorcomsServiceImpl
          .horarioComercialFestivoByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbito);

      verify(this.runTareaAmbitoRecolectarSlrhorcomsServiceImpl, times(1))
          .horarioComercialFestivoByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbito);
    }
  }

  @Test
  void horarioComercialFestivoByRunTareaAndTareaAmbitoExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaPersonaEstructuraService).calcularFestivos(this.runTarea.getTarea());

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoRecolectarSlrhorcomsServiceImpl
          .horarioComercialFestivoByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbito);
    });
  }

}
