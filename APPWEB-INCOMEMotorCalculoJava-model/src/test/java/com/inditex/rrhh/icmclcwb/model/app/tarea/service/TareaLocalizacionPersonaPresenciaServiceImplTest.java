package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionPersonaPresenciaServiceImplTest {

  @Mock
  private TareaLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionPersonaPresenciaServiceImpl tareaLocalizacionPersonaPresenciaServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;

  @Test
  void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto = new ArrayList<>();

    this.tareaLocalizacionPersonaPresenciaServiceImpl.save(genericEmpleadoResultItemDto, tarea);

    verify(this.tareaLocalizacionPersonaPresenciaMapper, times(1))
        .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            ArgumentMatchers.<List<GenericEmpleadoResultItemDto>>any(), any(TareaDto.class));
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPersonaPresencia>>any());
  }

  @Test
  void savePtrPresenciaDetalleTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<PtrPresenciaDetalleResultItemDto> ptrPresenciaDetalleDto = new ArrayList<>();

    this.tareaLocalizacionPersonaPresenciaServiceImpl.savePtrPresenciaDetalle(ptrPresenciaDetalleDto, tarea, 1);

    verify(this.tareaLocalizacionPersonaPresenciaMapper, times(1))
        .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
            ArgumentMatchers.<List<PtrPresenciaDetalleResultItemDto>>any(), any(TareaDto.class),
            any(Integer.class));
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPersonaPresencia>>any());
  }

  @Test
  void updateActivoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.updateActivo(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).updateActivo(any(RunTareaDto.class));
  }

  @Test
  void updateActivoVacioTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.updateActivoVacio(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .updateActivoVacio(any(RunTareaDto.class));
  }

  @Test
  void compensarTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.compensar(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).compensar(any(RunTareaDto.class));
  }

  @Test
  void compensarChallengeTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.compensarChallenge(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .compensarChallenge(any(RunTareaDto.class));
  }

  @Test
  void presenciasIncluidoVentaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciasIncluidoVenta(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .presenciasIncluidoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresencia(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorPresencia(any(RunTareaDto.class));
  }

  @Test
  void presenciaDesplazamientoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciaDesplazamiento(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .presenciaDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresenciaDesplazamiento(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorPresenciaDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPresenciaDesplazamientoBase(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorPresenciaDesplazamientoBase(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void presenciasHorasFijasTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciasHorasFijas(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .presenciasHorasFijas(any(RunTareaDto.class));
  }

  @Test
  void presenciasHorasFijasDesplazamientosTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.presenciasHorasFijasDesplazamientos(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .presenciasHorasFijasDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void indicadorPersonaPorVentaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.indicadorPersonaPorVenta(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorPersonaPorVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoDirectoVenta(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoDirectoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaSinPresenciasTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoDirectoVentaSinPresencias(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoDirectoVentaSinPresencias(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoBaseDirectoVenta(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoBaseDirectoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaOtraTiendaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoBaseDirectoVentaOtraTienda(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoBaseDirectoVentaOtraTienda(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamientoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaCambioFuncionTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoDirectoVentaCambioFuncion(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoDirectoVentaCambioFuncion(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoChallengeImporteTiendaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl
        .indicadorDesplazamientoChallengeImporteTienda(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1))
        .indicadorDesplazamientoChallengeImporteTienda(any(RunTareaDto.class));
  }

  @Test
  void updateActivoPersonasExternasTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPersonaPresenciaServiceImpl.updateActivoPersonasExternas(runTarea);
    verify(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, times(1)).updateActivoPersonasExternas(runTarea);
  }

}
