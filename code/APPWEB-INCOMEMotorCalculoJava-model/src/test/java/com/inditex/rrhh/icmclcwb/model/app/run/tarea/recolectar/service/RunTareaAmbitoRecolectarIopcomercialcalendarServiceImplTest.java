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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.IopcomercialcalendarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarAsyncService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaAmbitoRecolectarIopcomercialcalendarServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private IOPComercialCalendarService IOPComercialCalendarService;

  @Mock
  private IOPComercialCalendarAsyncService IOPComercialCalendarAsyncService;

  @Mock
  private TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Mock
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Mock
  @Qualifier("iopcomercialcalendarProperties")
  private Map<String, IopcomercialcalendarPropertiesDto> iopcomercialcalendarProperties;

  @Spy
  @InjectMocks
  RunTareaAmbitoRecolectarIopcomercialcalendarServiceImpl runTareaAmbitoRecolectarIopcomercialcalendarServiceImpl;

  RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  TareaAmbitoDto tareaAmbito = Instancio.create(TareaAmbitoDto.class);

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void horarioComercialFestivoByRunTareaAndTareaAmbito(
      final List<IdEmpresaDto> idEmpresaDtoList,
      final List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList,
      final IopcomercialcalendarPropertiesDto iopcomercialcalendarPropertiesDto,
      final HorarioComercialFestivosRequestDto request,
      final CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> cfHorarioComercialFestivos,
      final ResponseDto<HorarioComercialFestivoDocDto> data,
      final CompletableFuture<Void> cfSave) {

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {

      final ResponseDto<HorarioComercialFestivoDocDto> spiedData = Mockito.spy(data);

      utilities.when(() -> AsyncUtils.get(cfHorarioComercialFestivos))
          .thenReturn(spiedData);

      doReturn(true).when(this.tareaPersonaEstructuraService).calcularFestivos(this.runTarea.getTarea());

      doReturn(idEmpresaDtoList).when(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());
      final List<String> empresasAmbito = idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList());

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
              this.tareaAmbito.getCclIdOrigen(), empresasAmbito);
      doReturn(iopcomercialcalendarPropertiesDto).when(this.iopcomercialcalendarProperties)
          .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO);
      final List<IdLocalizacionLocalDto> iter =
          StreamUtils.partition(idLocalizacionLocalDtoList, iopcomercialcalendarPropertiesDto.getMaxFilterSize())
              .stream().findFirst().orElse(null);

      doReturn(request).when(this.tareaMapper).mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoDtoToHorarioComercialFestivosRequestDto(
          this.runTarea.getTrabajo(), this.runTarea.getTarea(), this.tareaAmbito);
      // Acondicionamiento de request
      request.setIdTienda(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));

      doReturn(cfHorarioComercialFestivos).when(this.IOPComercialCalendarAsyncService).horarioComercialFestivos(request);

      doReturn(cfSave).when(this.tareaLocalizacionFestivoAsyncService).save(data.getData(), this.runTarea.getTarea());

      this.runTareaAmbitoRecolectarIopcomercialcalendarServiceImpl
          .horarioComercialFestivoByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbito);

      verify(this.runTareaAmbitoRecolectarIopcomercialcalendarServiceImpl, times(1))
          .horarioComercialFestivoByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbito);
    }
  }

  @Test
  void horarioComercialFestivoByRunTareaAndTareaAmbitoExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaPersonaEstructuraService).calcularFestivos(this.runTarea.getTarea());

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoRecolectarIopcomercialcalendarServiceImpl
          .horarioComercialFestivoByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbito);
    });
  }

}
