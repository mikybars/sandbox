package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.SincronizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ValidacionMapperDecoratorTest {

  @Mock
  private ValidacionMapper delegate;

  @InjectMocks
  private final ValidacionMapperDecorator validacionMapperDecorator = this.getClassMock();

  private ValidacionMapperDecorator getClassMock() {
    return Mockito.mock(ValidacionMapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void idPersonaLocalDtoTovalidacionDtoWithDataTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setIdTarea(1L);
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    accion.setId(1L);
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);

    final IdPersonaLocalDto persona1 = new IdPersonaLocalDto();
    persona1.setIdPersonaLocal("12345");
    final IdPersonaLocalDto persona2 = new IdPersonaLocalDto();
    persona2.setIdPersonaLocal("67890");
    final List<IdPersonaLocalDto> personas = List.of(persona1, persona2);

    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(false).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    when(this.delegate.idPersonaLocalDtoTovalidacionDto(ambito, accion, personas, properties, tareaDto))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idPersonaLocalDtoTovalidacionDto(ambito, accion, personas, properties, tareaDto);

    assertNotNull(result);
    assertNotNull(result.getIdPersonaLocal());
    assertEquals(2, result.getIdPersonaLocal().size());
    assertEquals("12345", result.getIdPersonaLocal().get(0));
    assertEquals("67890", result.getIdPersonaLocal().get(1));
    verify(this.delegate, times(1)).idPersonaLocalDtoTovalidacionDto(ambito, accion, personas, properties, tareaDto);
  }

  @Test
  void idPersonaLocalDtoTovalidacionDtoWithEmptyListTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    final TareaDto tareaDto = new TareaDto();
    final List<IdPersonaLocalDto> personas = Collections.emptyList();
    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(false).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    when(this.delegate.idPersonaLocalDtoTovalidacionDto(ambito, accion, personas, properties, tareaDto))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idPersonaLocalDtoTovalidacionDto(ambito, accion, personas, properties, tareaDto);

    assertNotNull(result);
    assertNotNull(result.getIdPersonaLocal());
    assertTrue(result.getIdPersonaLocal().isEmpty());
  }

  @Test
  void idLocalizacionLocalDtoTovalidacionDtoWithDataTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setIdTarea(1L);
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    accion.setId(1L);
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);

    final IdLocalizacionLocalDto tienda1 = new IdLocalizacionLocalDto();
    tienda1.setId("LOC001");
    final IdLocalizacionLocalDto tienda2 = new IdLocalizacionLocalDto();
    tienda2.setId("LOC002");
    final List<IdLocalizacionLocalDto> tiendas = List.of(tienda1, tienda2);

    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(false).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    when(this.delegate.idLocalizacionLocalDtoTovalidacionDto(ambito, accion, tiendas, properties, tareaDto))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idLocalizacionLocalDtoTovalidacionDto(ambito, accion, tiendas, properties, tareaDto);

    assertNotNull(result);
    assertNotNull(result.getIdPersonaLocal());
    assertTrue(result.getIdPersonaLocal().isEmpty());
    assertNotNull(result.getIdLocalizacionLocal());
    assertEquals(2, result.getIdLocalizacionLocal().size());
    assertEquals("LOC001", result.getIdLocalizacionLocal().get(0));
    assertEquals("LOC002", result.getIdLocalizacionLocal().get(1));
    verify(this.delegate, times(1)).idLocalizacionLocalDtoTovalidacionDto(ambito, accion, tiendas, properties, tareaDto);
  }

  @Test
  void idLocalizacionLocalDtoTovalidacionDtoWithEmptyListTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    final TareaDto tareaDto = new TareaDto();
    final List<IdLocalizacionLocalDto> tiendas = Collections.emptyList();
    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(false).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    when(this.delegate.idLocalizacionLocalDtoTovalidacionDto(ambito, accion, tiendas, properties, tareaDto))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idLocalizacionLocalDtoTovalidacionDto(ambito, accion, tiendas, properties, tareaDto);

    assertNotNull(result);
    assertNotNull(result.getIdPersonaLocal());
    assertTrue(result.getIdPersonaLocal().isEmpty());
    assertNotNull(result.getIdLocalizacionLocal());
    assertTrue(result.getIdLocalizacionLocal().isEmpty());
  }

  @Test
  void idPersonaLocalFechaIncidenciaDtoToValidacionDtoWithDataTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setIdTarea(1L);
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    accion.setId(1L);

    final IdPersonaLocalFechaIncidenciaDto incidencia1 = new IdPersonaLocalFechaIncidenciaDto();
    incidencia1.setIdPersonaLocal("12345");
    final IdPersonaLocalFechaIncidenciaDto incidencia2 = new IdPersonaLocalFechaIncidenciaDto();
    incidencia2.setIdPersonaLocal("67890");
    final IdPersonaLocalFechaIncidenciaDto incidencia3 = new IdPersonaLocalFechaIncidenciaDto();
    incidencia3.setIdPersonaLocal("12345");
    final List<IdPersonaLocalFechaIncidenciaDto> incidencias = List.of(incidencia1, incidencia2, incidencia3);

    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(true).maxEmpleados(2).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    validacionDto.setIdPersonaLocal(new ArrayList<>());
    when(this.delegate.idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties);

    assertNotNull(result);
    assertNotNull(result.getIdPersonaLocal());
    assertEquals(2, result.getIdPersonaLocal().size());
    assertTrue(result.getSincronizacion());
    verify(this.delegate, times(1)).idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties);
  }

  @Test
  void idPersonaLocalFechaIncidenciaDtoToValidacionDtoWithEmptyListTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    final List<IdPersonaLocalFechaIncidenciaDto> incidencias = Collections.emptyList();
    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(true).maxEmpleados(10).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    validacionDto.setIdPersonaLocal(new ArrayList<>());
    when(this.delegate.idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties);

    assertNotNull(result);
    assertNotNull(result.getIdPersonaLocal());
    assertTrue(result.getIdPersonaLocal().isEmpty());
    assertFalse(result.getSincronizacion());
  }

  @Test
  void idPersonaLocalFechaIncidenciaDtoToValidacionDtoSincronizacionInactivaTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();

    final IdPersonaLocalFechaIncidenciaDto incidencia = new IdPersonaLocalFechaIncidenciaDto();
    incidencia.setIdPersonaLocal("12345");
    final List<IdPersonaLocalFechaIncidenciaDto> incidencias = List.of(incidencia);

    final PrevalidarPropertiesDto properties = PrevalidarPropertiesDto.builder()
        .sincronizacion(SincronizacionDto.builder().activo(false).maxEmpleados(1).build())
        .build();

    final ValidacionDto validacionDto = new ValidacionDto();
    validacionDto.setIdPersonaLocal(new ArrayList<>());
    when(this.delegate.idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idPersonaLocalFechaIncidenciaDtoToValidacionDto(ambito, accion, incidencias, properties);

    assertNotNull(result);
    assertFalse(result.getSincronizacion());
  }

  @Test
  void idMotivoDesplazamientoDtoToValidacionDtoWithDataTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setIdTarea(1L);
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    accion.setId(1L);

    final IdMotivoDesplazamientoDto motivo1 = new IdMotivoDesplazamientoDto();
    motivo1.setIdMotivoDesplazamiento(1);
    final IdMotivoDesplazamientoDto motivo2 = new IdMotivoDesplazamientoDto();
    motivo2.setIdMotivoDesplazamiento(2);
    final List<IdMotivoDesplazamientoDto> motivos = List.of(motivo1, motivo2);

    final ValidacionDto validacionDto = new ValidacionDto();
    when(this.delegate.idMotivoDesplazamientoDtoToValidacionDto(ambito, accion, motivos))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idMotivoDesplazamientoDtoToValidacionDto(ambito, accion, motivos);

    assertNotNull(result);
    assertNotNull(result.getIdMotivosDesplazamiento());
    assertEquals(2, result.getIdMotivosDesplazamiento().size());
    assertEquals(1, result.getIdMotivosDesplazamiento().get(0));
    assertEquals(2, result.getIdMotivosDesplazamiento().get(1));
    verify(this.delegate, times(1)).idMotivoDesplazamientoDtoToValidacionDto(ambito, accion, motivos);
  }

  @Test
  void idMotivoDesplazamientoDtoToValidacionDtoWithEmptyListTest() {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    final TareaFaseAccionDto accion = new TareaFaseAccionDto();
    final List<IdMotivoDesplazamientoDto> motivos = Collections.emptyList();

    final ValidacionDto validacionDto = new ValidacionDto();
    when(this.delegate.idMotivoDesplazamientoDtoToValidacionDto(ambito, accion, motivos))
        .thenReturn(validacionDto);

    final ValidacionDto result = this.validacionMapperDecorator
        .idMotivoDesplazamientoDtoToValidacionDto(ambito, accion, motivos);

    assertNotNull(result);
    assertNotNull(result.getIdMotivosDesplazamiento());
    assertTrue(result.getIdMotivosDesplazamiento().isEmpty());
  }
}
