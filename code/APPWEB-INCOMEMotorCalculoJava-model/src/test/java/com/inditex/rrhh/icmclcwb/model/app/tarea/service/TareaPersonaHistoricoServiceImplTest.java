package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaPersonaHistoricoServiceImplTest {

  @Mock
  private TareaPersonaHistoricoRepositoryCustom tareaPersonaHistoricoRepositoryCustom;

  @Mock
  private TareaPersonaHistoricoRepository tareaPersonaHistoricoRepository;

  @InjectMocks
  private TareaPersonaHistoricoServiceImpl tareaPersonaHistoricoServiceImpl;

  @Mock
  private TareaPersonaHistoricoMapper tareaPersonaHistoricoMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaPersonaHistoricoDto> personas = new ArrayList<>();

    this.tareaPersonaHistoricoServiceImpl.save(personas);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaPersonaHistorico>>any());
  }

  @Test
  public void mergeTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<GenericEmpleadoResultItemDto> personas = new ArrayList<>();

    this.tareaPersonaHistoricoServiceImpl.merge(personas, tarea);
    verify(this.tareaPersonaHistoricoMapper, times(1))
        .genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(
            ArgumentMatchers.<List<GenericEmpleadoResultItemDto>>any(), any(TareaDto.class));
  }

  @Test
  public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbitoTest() {
    final String cclIdOrigen = "1";
    final Long idTarea = 1L;

    this.tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        cclIdOrigen);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1))
        .findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class));
  }

  @Test
  public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbitoTest() {
    final String cclIdOrigen = "1";
    final Long idTarea = 1L;
    final List<Integer> idsTipoDato = new ArrayList<>();

    final List<GenericAlgoritmoPropertiesDto> algoritmos = Arrays.asList(
        new GenericAlgoritmoPropertiesDto());
    when(this.tareaPersonaHistoricoRepositoryCustom.findIdTipoCalculoAndIdTipoComisionByIdsTiposDato(anyList()))
        .thenReturn(algoritmos);

    this.tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea,
        cclIdOrigen, idsTipoDato);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempAlgoritmo();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).indexTempAlgoritmo();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).insertTempAlgoritmo(algoritmos);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1))
        .findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(any(Long.class), any(String.class),
            ArgumentMatchers.<List<Integer>>any());
  }

  @Test
  public void findPeriodoByIdTareaDtoTest() {
    final Long idTarea = 1L;
    this.tareaPersonaHistoricoServiceImpl.findPeriodoByIdTareaDto(idTarea);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1)).findPeriodoDtoByIdTarea(any(Long.class));
  }

  @Test
  public void findIdPersonaHistoricoDtoGrupoFechasByIdTareaTest() {
    final Long idTarea = 1L;
    this.tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoDtoGrupoFechasByIdTarea(idTarea);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1))
        .findIdPersonaHistoricoDtoGrupoFechasByIdTarea(any(Long.class));
  }

  @Test
  public void findIdPersonaLocalCompensacionChallengeByIdTareaTest() {
    final Long idTarea = 1L;
    this.tareaPersonaHistoricoServiceImpl.findIdPersonaLocalCompensacionChallengeByIdTarea(idTarea);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1))
        .findIdPersonaLocalCompensacionChallengeByIdTarea(any(Long.class));
  }

  @Test
  public void findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilioTest() {
    final Long idTarea = 1L;
    final String cclIdOrigen = "1";
    this.tareaPersonaHistoricoServiceImpl
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(idTarea, cclIdOrigen);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1))
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
            idTarea, cclIdOrigen, TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS);

  }

  @Test
  public void findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbitoTest() {
    final String cclIdOrigen = "1";
    final Long idTarea = 1L;

    this.tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        cclIdOrigen);
    verify(this.tareaPersonaHistoricoRepositoryCustom, times(1))
        .findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class));
  }

}
