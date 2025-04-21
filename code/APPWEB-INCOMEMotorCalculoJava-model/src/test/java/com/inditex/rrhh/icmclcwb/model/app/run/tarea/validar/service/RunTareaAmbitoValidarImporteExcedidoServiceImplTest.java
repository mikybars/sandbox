package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.SincronizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaImporteExcedidoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoValidarImporteExcedidoServiceImplTest {

  @Mock
  private TareaFaseAccionServiceImpl tareaFaseAccionService;

  @Mock
  private TareaImporteExcedidoService tareaImporteExcedidoService;

  @Mock
  private ValidacionMapper validacionMapper;

  @InjectMocks
  private RunTareaAmbitoValidarImporteExcedidoServiceImpl runTareaAmbitoValidarImporteExcedidoServiceImpl;

  @Test
  void executeTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final TareaDto tareaDto = new TareaDto();
    final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> tareaPersonaImporteExcedidoDtoList = List.of(idPersonaLocalDto);
    tareaAmbitoDto.setIdTarea(1L);
    runTareaDto.setTarea(tareaDto);
    tareaDto.setId(1L);

    when(this.tareaImporteExcedidoService.findPersonaImporteExcedidoByIdTarea(1L)).thenReturn(tareaPersonaImporteExcedidoDtoList);
    when(this.validacionMapper.booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto, true))
        .thenReturn(new ValidacionDto());

    this.runTareaAmbitoValidarImporteExcedidoServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaImporteExcedidoService, timeout(1000).times(1))
        .findPersonaImporteExcedidoByIdTarea(1L);
    verify(this.validacionMapper, timeout(1000).times(1))
        .idPersonaLocalDtoTovalidacionDto(tareaAmbitoDto, tareaFaseAccionDto, tareaPersonaImporteExcedidoDtoList,
            PrevalidarPropertiesDto.builder().sincronizacion(SincronizacionDto.builder().activo(false).build()).build(), tareaDto);
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
    tareaDto.setId(1L);
    trabajoDTO.setId(1L);

    when(this.tareaImporteExcedidoService.findPersonaImporteExcedidoByIdTarea(1L))
        .thenThrow(new RuntimeException("Test exception"));
    when(this.validacionMapper.idPersonaLocalDtoTovalidacionDto(tareaAmbitoDto, tareaFaseAccionDto, List.of(),
        PrevalidarPropertiesDto.builder().build(), tareaDto))
            .thenReturn(new ValidacionDto());

    this.runTareaAmbitoValidarImporteExcedidoServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaImporteExcedidoService, timeout(1000).times(1))
        .findPersonaImporteExcedidoByIdTarea(1L);
    verify(this.validacionMapper, timeout(1000).times(1))
        .idPersonaLocalDtoTovalidacionDto(tareaAmbitoDto, tareaFaseAccionDto, List.of(), PrevalidarPropertiesDto.builder().sincronizacion(
            SincronizacionDto.builder().activo(false).build()).build(),
            tareaDto);
  }
}
