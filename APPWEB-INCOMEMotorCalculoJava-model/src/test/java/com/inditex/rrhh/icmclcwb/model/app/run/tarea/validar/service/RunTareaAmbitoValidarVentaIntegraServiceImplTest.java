package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.service.VentaIntegraServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaLocalizacionHistoricoServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaAmbitoValidarVentaIntegraServiceImplTest {

  @Mock
  private TareaLocalizacionHistoricoServiceImpl findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito;

  @Mock
  private VentaIntegraServiceImpl ventaIntegraService;

  @Mock
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionDatoService;

  @Mock
  private TareaFaseAccionServiceImpl tareaFaseAccionService;

  @Mock
  private ValidacionMapper validacionMapper;

  @InjectMocks
  private RunTareaAmbitoValidarVentaIntegraServiceImpl runTareaAmbitoValidarVentaNoIntegraService;

  @Random
  private RunTareaDto runTarea;

  @Random
  private TareaAmbitoDto tareaAmbito;

  @Random
  private TareaFaseAccionDto tareaFaseAccion;

  @BeforeAll
  void setup() {
    this.runTarea.getTarea().setStdIdLegEnt("1");
    this.tareaAmbito.setCclIdOrigen("2");
  }

  @Test
  void executeExceptionTest() {
    doReturn(new ArrayList<IdLocalizacionDto>()).when(this.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito)
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(this.runTarea.getTarea().getId(), this.tareaAmbito.getCclIdOrigen());

    assertThrows(RuntimeException.class,
        () -> this.runTareaAmbitoValidarVentaNoIntegraService.execute(this.runTarea, this.tareaAmbito, this.tareaFaseAccion));

  }

  @Test
  void executeTest() {

    final List<IdLocalizacionDto> tiendas = Arrays.asList(IdLocalizacionDto.builder().id("T1").build(),
        IdLocalizacionDto.builder().id("T2").build(),
        IdLocalizacionDto.builder().id("T3").build(),
        IdLocalizacionDto.builder().id("T4").build());

    doReturn(tiendas).when(this.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito)
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(this.runTarea.getTarea().getId(), this.tareaAmbito.getCclIdOrigen());

    doReturn(Arrays.asList(1)).when(this.ventaIntegraService).getTiendasVentaNoIntegra(Mockito.any(VentaIntegraRequestDto.class));

    doNothing().when(this.tareaFaseAccionDatoService).save(anyList());

    this.runTareaAmbitoValidarVentaNoIntegraService.execute(this.runTarea, this.tareaAmbito, this.tareaFaseAccion);

    verify(this.validacionMapper, timeout(1000).times(1))
        .booleanToValidacionDto(
            Mockito.any(TareaAmbitoDto.class), Mockito.any(TareaFaseAccionDto.class), Mockito.eq(Boolean.TRUE));

  }

}
