package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ReglaEmpleadoExternoMeta4Service;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoValidarExternosMeta4ServiceImplTest {

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private TareaPersonaExternaMapper tareaPersonaExternaMapper;

  @Mock
  private TareaPersonaExternaRepositoryCustom tareaPersonaExternaRepositoryCustom;

  @Mock
  private IncomeMetaService incomeMetaService;

  @Mock
  private ReglaEmpleadoExternoMeta4Service reglaEmpleadoExternoMeta4Service;

  @Mock
  private ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper;

  @InjectMocks
  private RunTareaAmbitoValidarExternosMeta4ServiceImpl runTareaAmbitoValidarExternosMeta4ServiceImpl;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void executeWithValidReglas() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setStdIdLegEnt("101");
    tareaDto.setFechaInicioPeriodo(LocalDate.of(2024, 11, 1));
    tareaDto.setFechaFinPeriodo(LocalDate.of(2024, 11, 30));
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(19L);
    final RunTareaDto runTareaDto = RunTareaDto.builder().tarea(tareaDto).trabajo(trabajoDTO).build();
    final TareaAmbitoDto tareaAmbitoDto = TareaAmbitoDto.builder().cclIdOrigen("11").build();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final ExternosRequestDTO externosRequestDTO = new ExternosRequestDTO();
    final EmpleadoExternoDTO empleadoExternoDTO = new EmpleadoExternoDTO();
    empleadoExternoDTO.setIdPersonaLocal("1234");
    empleadoExternoDTO.setFechaDesde(LocalDate.of(2024, 11, 1));
    empleadoExternoDTO.fechaHasta(LocalDate.of(2024, 11, 30));

    final List<ReglaEmpleadoExternoMeta4RequestDto> reglas = new ArrayList<>();
    reglas.add(new ReglaEmpleadoExternoMeta4RequestDto());
    final List<EmpleadoExternoDTO> excluidosMeta4 = new ArrayList<>();
    excluidosMeta4.add(empleadoExternoDTO);
    final ValidacionDto validacionDto = new ValidacionDto();

    when(this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(any(), any())).thenReturn(reglas);
    when(this.reglaEmpleadoExternoMeta4Mapper.reglaEmpleadoExternoMeta4RequestDtotoExternosRequestDto(any()))
        .thenReturn(externosRequestDTO);
    when(this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(any())).thenReturn(excluidosMeta4);
    when(this.validacionMapper.booleanToValidacionDto(any(), any(), anyBoolean())).thenReturn(validacionDto);

    final ValidacionDto result =
        this.runTareaAmbitoValidarExternosMeta4ServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    assertEquals(validacionDto, result);
  }

  @Test
  void executeWithNoReglas() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setStdIdLegEnt("101");
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(19L);
    final RunTareaDto runTareaDto = RunTareaDto.builder().tarea(tareaDto).trabajo(trabajo).build();
    final TareaAmbitoDto tareaAmbitoDto = TareaAmbitoDto.builder().cclIdOrigen("11").build();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final ValidacionDto validacionDto = new ValidacionDto();

    when(this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(anyString(), anyString()))
        .thenReturn(null);
    when(this.validacionMapper.booleanToValidacionDto(any(), any(), anyBoolean())).thenReturn(validacionDto);

    final ValidacionDto result =
        this.runTareaAmbitoValidarExternosMeta4ServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    assertEquals(validacionDto, result);
  }
}
