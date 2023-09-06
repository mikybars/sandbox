package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionHistoricoServiceImplTest {

  @Mock
  private TareaLocalizacionHistoricoRepositoryCustom tareaLocalizacionHistoricoRepositoryCustom;

  @Mock
  private TareaLocalizacionHistoricoRepository tareaLocalizacionHistoricoRepository;

  @InjectMocks
  private TareaLocalizacionHistoricoServiceImpl tareaLocalizacionHistoricoServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLocalizacionHistoricoMapper tareaLocalizacionHistoricoMapper;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaLocalizacionHistoricoDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionHistoricoServiceImpl.save(genericTiendaResultItemDto);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1))
        .save(ArgumentMatchers.any());
  }

  @Test
  public void mergeTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<GenericTiendaResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionHistoricoServiceImpl.merge(genericTiendaResultItemDto, tarea);
    verify(this.tareaLocalizacionHistoricoMapper, times(1))
        .genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
            ArgumentMatchers.<List<GenericTiendaResultItemDto>>any(), any(TareaDto.class));
  }

  @Test
  public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;
    final String cclIdOrigen = "1";

    this.tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(idTarea,
        cclIdOrigen);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1))
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class));
  }

  @Test
  public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;
    final String cclIdOrigen = "1";

    this.tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(idTarea,
        cclIdOrigen);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1))
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class));
  }

  @Test
  public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;
    final String cclIdOrigen = "1";

    this.tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(idTarea,
        cclIdOrigen);
    verify(this.tareaLocalizacionHistoricoRepository, times(1))
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(any(Long.class), any(String.class));
  }

  @Test
  public void findIdCadenaDtoByIdTareaAndCclIdOrigenAndVentaConceptoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;
    final String cclIdOrigen = "1";
    final Long idVentaConcepto = 1L;

    this.tareaLocalizacionHistoricoServiceImpl.findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen,
        idVentaConcepto);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1)).getCadenasByTareaAndOrigen(any(Long.class),
        any(String.class), any(List.class));
  }

  @Test
  public void findIdCadenaDtoByIdTareaAndCclIdOrigenTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;
    final String cclIdOrigen = "1";

    this.tareaLocalizacionHistoricoServiceImpl.findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1)).getCadenasByTareaAndOrigen(any(Long.class),
        any(String.class));
  }

  @Test
  public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacionTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;
    final String cclCodOrigen = "1";
    final List<String> idTipoCalculo = new ArrayList<>();

    this.tareaLocalizacionHistoricoServiceImpl
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(idTarea, cclCodOrigen,
            idTipoCalculo);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1))
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(any(Long.class),
            any(String.class), ArgumentMatchers.any());
  }

  @Test
  public void findTiendasPresupuestosByIdTareaTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;

    this.tareaLocalizacionHistoricoServiceImpl.findTiendasPresupuestosByIdTarea(idTarea);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1))
        .findIdLocalizacionLocalDtoPresupuestosByIdTarea(any(Long.class));
  }

  @Test
  public void findIdLocalizacionByIdTareaTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final Long idTarea = 1L;

    this.tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionByIdTarea(idTarea);
    verify(this.tareaLocalizacionHistoricoRepositoryCustom, times(1))
        .findIdLocalizacionByIdTarea(any(Long.class));
  }

}
