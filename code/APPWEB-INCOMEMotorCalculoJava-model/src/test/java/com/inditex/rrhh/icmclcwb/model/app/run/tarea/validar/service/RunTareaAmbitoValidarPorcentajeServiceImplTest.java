package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPorcentajeService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;

import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaAmbitoValidarPorcentajeServiceImplTest {

  @InjectMocks
  private RunTareaAmbitoValidarPorcentajeServiceImpl service;

  @Mock
  private TareaCalculoPorcentajeService tareaCalculoPorcentajeService;

  @Mock
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  @Mock
  private ValidacionMapper validacionMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void execute_ok() {
    // Arrange
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    tareaDto.setStdIdLegEnt("LEG");
    runTareaDto.setTarea(tareaDto);

    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tareaAmbito.setIdTarea(1L);
    tareaAmbito.setCclIdOrigen("ORIGEN");

    final TareaFaseAccionDto tareaFaseAccion = new TareaFaseAccionDto();
    tareaFaseAccion.setId(2L);

    final IdPersonaLocalDto persona = new IdPersonaLocalDto();
    persona.setIdPersonaLocal("123");
    final List<IdPersonaLocalDto> personas = Instancio.createList(IdPersonaLocalDto.class);

    when(this.tareaCalculoPorcentajeService.findPersonaPorcetaje0(1L)).thenReturn(personas);
    when(this.validacionMapper.idPersonaLocalDtoTovalidacionDto(any(), any(), any(), any(), any()))
        .thenReturn(new ValidacionDto());
    when(this.validacionMapper.booleanToValidacionDto(any(), any(), anyBoolean()))
        .thenReturn(new ValidacionDto());

    // Act
    final ValidacionDto result = this.service.execute(runTareaDto, tareaAmbito, tareaFaseAccion);

    // Assert
    assertNotNull(result);
    verify(this.tareaCalculoPorcentajeService).findPersonaPorcetaje0(1L);
    verify(this.tareaFaseAccionFallidasService).save(anyList());
    verify(this.validacionMapper).idPersonaLocalDtoTovalidacionDto(any(), any(), any(), any(), any());
    verify(this.validacionMapper).booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }

  @Test
  void executeHandlesExceptionTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final TareaDto tareaDto = new TareaDto();
    final TrabajoDTO trabajoDTO = new TrabajoDTO();

    tareaAmbitoDto.setIdTarea(1L);
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDTO);
    tareaDto.setStdIdLegEnt("8");
    tareaAmbitoDto.setIdTarea(1L);
    tareaAmbitoDto.setCclIdOrigen("11");
    trabajoDTO.setId(1L);

    when(this.tareaCalculoPorcentajeService.findPersonaPorcetaje0(1L)).thenThrow(new RuntimeException("Test exception"));
    when(this.validacionMapper.idPersonaLocalDtoTovalidacionDto(tareaAmbitoDto, tareaFaseAccionDto, List.of(),
        PrevalidarPropertiesDto.builder().build(), tareaDto))
            .thenReturn(new ValidacionDto());

    this.service.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaCalculoPorcentajeService, timeout(1000).times(1))
        .findPersonaPorcetaje0(1L);
    verify(this.validacionMapper, timeout(1000).times(1))
        .booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto, true);
  }
}
