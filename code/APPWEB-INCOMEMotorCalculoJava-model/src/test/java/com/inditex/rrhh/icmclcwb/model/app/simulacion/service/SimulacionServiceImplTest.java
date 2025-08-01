package com.inditex.rrhh.icmclcwb.model.app.simulacion.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionLocalizacionBandaExcepcionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper.SimulacionLocalizacionBandaExcepcionMapper;
import com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper.SimulacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.SimulacionLocalizacionBandaExcepcion;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository.SimulacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository.SimulacionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository.SimuladorLocalizacionBandaExcepcionRepository;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimulacionServiceImplTest {

  @Mock
  private SimulacionRepositoryCustom simulacionRepositoryCustom;

  @Mock
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Mock
  private SimulacionMapper simulacionMapper;

  @Mock
  private SimulacionRepository simulacionRepository;

  @Mock
  private SimuladorLocalizacionBandaExcepcionRepository simulacionLocalizacionBandaExcepcionRepository;

  @Mock
  private SimulacionLocalizacionBandaExcepcionMapper simulacionLocalizacionBandaExcepcionMapper;

  @InjectMocks
  private SimulacionServiceImpl simulacionServiceImpl;

  @Test
  public void mergePeriodoCalculoPersonaTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.simulacionServiceImpl.mergeEmpleadoSimulacion(tarea);

    verify(this.simulacionRepositoryCustom, times(1))
        .mergeEmpleadoSimulacion(tarea);
  }

  @Test
  public void mergeEstructurasEmpleadoSimulacionTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaPersonaEstructuraDto> estructuras = new ArrayList<>();
    estructuras.add(new TareaPersonaEstructuraDto());
    when(this.simulacionRepositoryCustom.findEstructurasEmpleadoSimulacion(any(TareaDto.class))).thenReturn(estructuras);

    this.simulacionServiceImpl.mergeEstructurasEmpleadoSimulacion(tarea);

    verify(this.tareaPersonaEstructuraService, times(1))
        .saveSimulacion(any(List.class), any(TareaDto.class));
  }

  @Test
  public void mergeEstructurasEmpleadoSimulacionEstructurasEmptyTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaPersonaEstructuraDto> estructuras = new ArrayList<>();
    when(this.simulacionRepositoryCustom.findEstructurasEmpleadoSimulacion(any(TareaDto.class))).thenReturn(estructuras);

    this.simulacionServiceImpl.mergeEstructurasEmpleadoSimulacion(tarea);

    verify(this.tareaPersonaEstructuraService, times(0))
        .saveSimulacion(any(List.class), any(TareaDto.class));
  }

  @Test
  public void mergeEstructurasEmpleadoSimulacionEstructurasNullTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaPersonaEstructuraDto> estructuras = null;
    when(this.simulacionRepositoryCustom.findEstructurasEmpleadoSimulacion(any(TareaDto.class))).thenReturn(estructuras);

    this.simulacionServiceImpl.mergeEstructurasEmpleadoSimulacion(tarea);

    verify(this.tareaPersonaEstructuraService, times(0))
        .saveSimulacion(any(List.class), any(TareaDto.class));
  }

  @Test
  public void mergeEmpleadoSimulacionTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.simulacionServiceImpl.mergeEmpleadoSimulacion(tarea);

    verify(this.simulacionRepositoryCustom, times(1))
        .mergeEmpleadoSimulacion(tarea);
  }

  @Test
  public void mergePresenciaEmpleadoUltimoCalculoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.simulacionServiceImpl.mergePresenciaEmpleadoUltimoCalculo(tarea);

    verify(this.simulacionRepositoryCustom, times(1))
        .mergePresenciaEmpleadoUltimoCalculo(tarea);
  }

  @Test
  public void mergeVentaUltimoCalculoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.simulacionServiceImpl.mergeVentaUltimoCalculo(tarea);

    verify(this.simulacionRepositoryCustom, times(1))
        .mergeVentaUltimoCalculo(tarea);
  }

  @Test
  public void mergePresenciaTiendaUltimoCalculoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.simulacionServiceImpl.mergePresenciaTiendaUltimoCalculo(tarea);

    verify(this.simulacionRepositoryCustom, times(1))
        .mergePresenciaTiendaUltimoCalculo(tarea);
  }

  @Test
  public void updateBandaExcepcionadaTest() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = Instancio.create(SimulacionDto.class);
    final SimulacionLocalizacionBandaExcepcionDto bandaExcepcionada = new SimulacionLocalizacionBandaExcepcionDto();
    bandaExcepcionada.setEsExcepcionBanda0(Boolean.FALSE);
    bandaExcepcionada.setEsExcepcionBanda1(Boolean.TRUE);
    bandaExcepcionada.setEsExcepcionBanda2(Boolean.FALSE);
    bandaExcepcionada.setCclIdCodOrigen("1");
    bandaExcepcionada.setCclIdSeccion("1");

    simulacion.setBandasExcepcionadasSeccion(List.of(bandaExcepcionada));

    this.simulacionServiceImpl.updateBandaExcepcionada(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(1))
        .updateBandaExcepcionada(tarea, 1, "1", "1");
  }

  @Test
  public void findByIdShouldReturnCorrectResultWhenSimulacionExists() {
    final Long id = 1L;
    final Simulacion simulacion = Instancio.create(Simulacion.class);

    when(this.simulacionRepository.findById(id)).thenReturn(Optional.of(simulacion));
    when(this.simulacionMapper.simulacionToSimulacionDto(simulacion)).thenReturn(new SimulacionDto());
    when(this.simulacionLocalizacionBandaExcepcionRepository.findBySimulacion_Id(simulacion.getId()))
        .thenReturn(Optional.empty());

    final SimulacionDto result = this.simulacionServiceImpl.findbyId(id);

    verify(this.simulacionRepository, times(1)).findById(id);
    assertNotNull(result);
  }

  @Test
  public void findByIdShouldReturnNullWhenSimulacionDoesNotExist() {
    final Long id = 1L;
    when(this.simulacionRepository.findById(id)).thenReturn(Optional.empty());

    final SimulacionDto result = this.simulacionServiceImpl.findbyId(id);

    verify(this.simulacionRepository, times(1)).findById(id);
    assertNull(result);
  }

  @Test
  public void findByIdShouldReturnCorrectResultWhenSimulacionExistsWithBandas() {
    final Long id = 1L;
    final Simulacion simulacion = Instancio.create(Simulacion.class);
    simulacion.setId(id);
    final List<SimulacionLocalizacionBandaExcepcion> simulacionBanda =
        Instancio.ofList(SimulacionLocalizacionBandaExcepcion.class).size(1).create();
    final SimulacionDto simulacionDto = new SimulacionDto();
    final List<SimulacionLocalizacionBandaExcepcionDto> simulacionBandaDto = List.of(new SimulacionLocalizacionBandaExcepcionDto());

    when(this.simulacionRepository.findById(id)).thenReturn(Optional.of(simulacion));
    when(this.simulacionMapper.simulacionToSimulacionDto(simulacion)).thenReturn(simulacionDto);
    when(this.simulacionLocalizacionBandaExcepcionRepository.findBySimulacion_Id(simulacion.getId()))
        .thenReturn(Optional.of(simulacionBanda));
    when(this.simulacionLocalizacionBandaExcepcionMapper.simulacionLocalizacionBandaExcepcionToDto(simulacionBanda))
        .thenReturn(simulacionBandaDto);

    final SimulacionDto result = this.simulacionServiceImpl.findbyId(id);

    verify(this.simulacionRepository, times(1)).findById(id);
    assertNotNull(result);
    verify(this.simulacionMapper, times(1)).simulacionToSimulacionDto(simulacion);
    verify(this.simulacionLocalizacionBandaExcepcionRepository, times(1)).findBySimulacion_Id(id);
    verify(this.simulacionLocalizacionBandaExcepcionMapper, times(1)).simulacionLocalizacionBandaExcepcionToDto(simulacionBanda);

    assertNotNull(result);
    assertNotNull(result.getBandasExcepcionadasSeccion());
  }

  @Test
  public void mergePresenciasEmpleadoSimulacionShouldInvokeCorrectMethod() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);

    this.simulacionServiceImpl.mergePresenciasEmpleadoSimulacion(tarea);

    verify(this.simulacionRepositoryCustom, times(1)).mergePresenciasEmpleadoSimulacion(tarea);
  }

  @Test
  public void updateBandaExcepcionadaShouldInvokeCorrectMethodForBanda0() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = Instancio.create(SimulacionDto.class);
    final SimulacionLocalizacionBandaExcepcionDto bandaExcepcionada = new SimulacionLocalizacionBandaExcepcionDto();
    bandaExcepcionada.setEsExcepcionBanda0(Boolean.TRUE);
    bandaExcepcionada.setCclIdCodOrigen("1");
    bandaExcepcionada.setCclIdSeccion("1");

    simulacion.setBandasExcepcionadasSeccion(List.of(bandaExcepcionada));

    this.simulacionServiceImpl.updateBandaExcepcionada(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(1)).updateBandaExcepcionada(tarea, 0, "1", "1");
  }

  @Test
  public void updateBandaExcepcionadaShouldInvokeCorrectMethodForBanda1() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = Instancio.create(SimulacionDto.class);
    final SimulacionLocalizacionBandaExcepcionDto bandaExcepcionada = new SimulacionLocalizacionBandaExcepcionDto();
    bandaExcepcionada.setEsExcepcionBanda1(Boolean.TRUE);
    bandaExcepcionada.setEsExcepcionBanda0(Boolean.FALSE);
    bandaExcepcionada.setCclIdCodOrigen("1");
    bandaExcepcionada.setCclIdSeccion("1");

    simulacion.setBandasExcepcionadasSeccion(List.of(bandaExcepcionada));

    this.simulacionServiceImpl.updateBandaExcepcionada(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(1)).updateBandaExcepcionada(tarea, 1, "1", "1");
  }

  @Test
  public void updateBandaExcepcionadaShouldInvokeCorrectMethodForBanda2() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = Instancio.create(SimulacionDto.class);
    final SimulacionLocalizacionBandaExcepcionDto bandaExcepcionada = new SimulacionLocalizacionBandaExcepcionDto();
    bandaExcepcionada.setEsExcepcionBanda2(Boolean.TRUE);
    bandaExcepcionada.setEsExcepcionBanda0(Boolean.FALSE);
    bandaExcepcionada.setEsExcepcionBanda1(Boolean.FALSE);
    bandaExcepcionada.setCclIdCodOrigen("1");
    bandaExcepcionada.setCclIdSeccion("1");

    simulacion.setBandasExcepcionadasSeccion(List.of(bandaExcepcionada));

    this.simulacionServiceImpl.updateBandaExcepcionada(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(1)).updateBandaExcepcionada(tarea, 2, "1", "1");
  }

  @Test
  public void updateBandaExcepcionadaShouldNotInvokeMethodWhenNoBandaIsExcepcionada() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = Instancio.create(SimulacionDto.class);
    final SimulacionLocalizacionBandaExcepcionDto bandaExcepcionada = new SimulacionLocalizacionBandaExcepcionDto();
    bandaExcepcionada.setEsExcepcionBanda0(Boolean.FALSE);
    bandaExcepcionada.setEsExcepcionBanda1(Boolean.FALSE);
    bandaExcepcionada.setEsExcepcionBanda2(Boolean.FALSE);
    bandaExcepcionada.setCclIdCodOrigen("1");
    bandaExcepcionada.setCclIdSeccion("1");

    simulacion.setBandasExcepcionadasSeccion(List.of(bandaExcepcionada));

    this.simulacionServiceImpl.updateBandaExcepcionada(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(0)).updateBandaExcepcionada(any(), anyInt(), any(), any());
  }

  @Test
  public void updateTiendaPersonaPresenciaTest() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = mock(SimulacionDto.class);
    final String cclIdPerson = "12345";
    final String cclIdCodOrigen = "67890";

    when(simulacion.getCclIdPerson()).thenReturn(cclIdPerson);
    when(simulacion.getCclIdCodOrigen()).thenReturn(cclIdCodOrigen);

    this.simulacionServiceImpl.updateTiendaPersonaPresencia(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(1))
        .updateTiendaPersonaPresencia(tarea, cclIdPerson, cclIdCodOrigen);
  }

  @Test
  public void mergePresenciaTiendaSimulada() {
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final SimulacionDto simulacion = mock(SimulacionDto.class);
    final String cclIdPerson = "12345";
    final String cclIdCodOrigen = "67890";

    when(simulacion.getCclIdPerson()).thenReturn(cclIdPerson);
    when(simulacion.getCclIdCodOrigen()).thenReturn(cclIdCodOrigen);

    this.simulacionServiceImpl.mergePresenciaTiendaSimulada(tarea, simulacion);

    verify(this.simulacionRepositoryCustom, times(1))
        .mergePresenciaTiendaSimulada(tarea, cclIdPerson, cclIdCodOrigen);
  }
}
