package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TrabajoServiceImplTest {

  @Mock
  private SenderTrabajo senderTrabajo;

  @Mock
  private TrabajoMapper trabajoMapper;

  @Mock
  private PeriodoMapper periodoMapper;

  @Mock
  private TrabajoRepository trabajoRepository;

  @Mock
  private TrabajoRepositoryCustom trabajoRepositoryCustom;

  @Mock
  private TrabajoAmbitoOrigenService trabajoAmbitoOrigenService;

  @Mock
  private TrabajoAmbitoEmpresaService trabajoAmbitoEmpresaService;

  @Mock
  private TrabajoAmbitoLocalizacionService trabajoAmbitoLocalizacionService;

  @Mock
  private TrabajoAmbitoPersonaService trabajoAmbitoPersonaService;

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @InjectMocks
  private TrabajoServiceImpl trabajoServiceImpl;

  @Test
  void findWithStatesTest() {
    final Long idTarea = 1L;

    when(this.trabajoRepository.findByIdAndEstadoIdIn(idTarea, AppConstants.ESTADOS_RUN_TRABAJO_OK))
        .thenReturn(new Trabajo());
    when(this.trabajoMapper.trabajoToTrabajoDto(any(Trabajo.class))).thenReturn(new TrabajoDTO());
    this.trabajoServiceImpl.findByIdWithStates(idTarea);
    verify(this.trabajoAmbitoOrigenService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoAmbitoEmpresaService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoAmbitoLocalizacionService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoAmbitoPersonaService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
  }

  @Test
  void findWithStatesTest2() {
    final Long idTarea = 1L;
    when(this.trabajoRepository.findByIdAndEstadoIdIn(idTarea, AppConstants.ESTADOS_RUN_TRABAJO_OK))
        .thenReturn(null);

    assertNull(this.trabajoServiceImpl.findByIdWithStates(1L));
  }

  @Test
  void find() {
    when(this.trabajoRepository.findById(any(Long.class))).thenReturn(Optional.of(new Trabajo()));
    when(this.trabajoMapper.trabajoToTrabajoDto(any(Trabajo.class))).thenReturn(new TrabajoDTO());
    this.trabajoServiceImpl.find(1L);
    verify(this.trabajoAmbitoOrigenService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoAmbitoEmpresaService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoAmbitoLocalizacionService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoAmbitoPersonaService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDTO.class));
  }

  @Test
  void create() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setNombreUsuario("test");
    trabajo.setIcmIdPeriodo(1L);
    trabajo.setFechaInicioPeriodo(LocalDate.of(2017, 01, 01).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    trabajo.setFechaFinPeriodo(LocalDate.of(2017, 01, 01).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    trabajo.setIdOrganization("test");
    trabajo.setTipoAmbito(new TipoAmbitoDTO());
    final PageDto page = new PageDto(1, 100);
    final Meta4PropertiesDto properties = new Meta4PropertiesDto();
    final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    properties.setFilter(filter);
    properties.setPage(page);

    when(this.trabajoMapper.trabajoDtoToTrabajo(any(TrabajoDTO.class))).thenReturn(new Trabajo());
    when(this.trabajoRepository.save(any(Trabajo.class))).thenReturn(new Trabajo());
    when(this.trabajoMapper.trabajoToTrabajoDto(any(Trabajo.class))).thenReturn(new TrabajoDTO());
    when(this.trabajoMapper.trabajoDtoToSaveProcesoDto(any(TrabajoDTO.class))).thenReturn(new SaveProcesoDto());
    when(this.meta4Properties.get(Meta4PropertiesConstants.PERIODOS)).thenReturn(properties);
    when(this.meta4IcmWsCalcIncomeSessionService.getPeriodos(any(PeriodosRequestDto.class)))
        .thenReturn(Arrays.asList(new PeriodosResultItemDto()));

    this.trabajoServiceImpl.create(trabajo);
    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1)).saveProceso(any(SaveProcesoDto.class));
  }

  @Test
  void merge() {
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    final ProgramacionDTO programacion = new ProgramacionDTO();
    final PeriodoDTO periodo = new PeriodoDTO();
    when(this.trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
        any(ProgramacionAmbitoDTO.class), any(ProgramacionDTO.class), any(PeriodoDTO.class)))
            .thenReturn(new TrabajoDTO());

    assertNotNull(this.trabajoServiceImpl.merge(programacion, ambito, periodo));
  }

  @Test
  public void findEmpresasCalcularProgramadosTest() {
    final TrabajoDTO trabajoDTO = mock(TrabajoDTO.class);
    trabajoDTO.setIdProgramacion(1L);
    final List<String> origen = mock(List.class);
    final List<String> empresa = mock(List.class);

    this.trabajoServiceImpl.findEmpresasCalcularProgramados(trabajoDTO, origen, empresa);
    verify(this.trabajoRepositoryCustom, times(1)).findEmpresasCalcularProgramados(any(TrabajoDTO.class), any(List.class), any(List.class));
  }

}
