package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;
import com.inditex.rrhh.icmclcwb.rest.client.dto.PeriodoResponseDTO;

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

  @Mock
  private IncomeMetaService incomeMetaService;

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
    final TipoAmbitoDTO tipoAmbitoDTO = new TipoAmbitoDTO();
    tipoAmbitoDTO.setId(TipoAmbitoEnum.SOCIEDAD.getId());
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setNombreUsuario("test");
    trabajo.setIcmIdPeriodo(1L);
    trabajo.setFechaInicioPeriodo(LocalDate.of(2017, 1, 1).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    trabajo.setFechaFinPeriodo(LocalDate.of(2017, 1, 1).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    trabajo.setIdOrganization("test");
    trabajo.setTipoAmbito(tipoAmbitoDTO);
    trabajo.setOrigen(List.of(new TrabajoAmbitoOrigenDTO("ORIGEN1")));
    trabajo.setIdProgramacion(1L);

    final PeriodoResponseDTO mockPeriodoResponse = mock(PeriodoResponseDTO.class);
    final PeriodoDTO mockPeriodo = new PeriodoDTO();
    mockPeriodo.setFechaInicioPeriodo(LocalDate.of(2020, 1, 1).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    mockPeriodo.setFechaFinPeriodo(LocalDate.of(2020, 12, 31).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));

    final EmpresaResultItemDto empresaResultItem = new EmpresaResultItemDto();
    empresaResultItem.setIdEmpresa("EMPRESA1");

    final IdOrigenEmpresaDto empresaNoCalcular = new IdOrigenEmpresaDto("EMPRESA1", "ORIGEN1");

    when(this.trabajoMapper.trabajoDtoToTrabajo(any(TrabajoDTO.class))).thenReturn(new Trabajo());
    when(this.trabajoRepository.save(any(Trabajo.class))).thenReturn(new Trabajo());
    when(this.trabajoMapper.trabajoToTrabajoDto(any(Trabajo.class))).thenReturn(new TrabajoDTO());
    when(this.trabajoMapper.trabajoDtoToSaveProcesoDto(any(TrabajoDTO.class))).thenReturn(new SaveProcesoDto());
    when(this.incomeMetaService.getPeriodos(anyString(), anyInt(), anyBoolean(), anyBoolean()))
        .thenReturn(mockPeriodoResponse);
    when(this.periodoMapper.periodoResponseDtoToPeriodoDto(mockPeriodoResponse)).thenReturn(mockPeriodo);
    final Meta4PropertiesDto mockMeta4PropertiesDto = new Meta4PropertiesDto();
    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPRESA)).thenReturn(mockMeta4PropertiesDto);
    when(this.meta4IcmWsCalcIncomeSessionService.getEmpresa(any(EmpresaRequestDto.class)))
        .thenReturn(List.of(empresaResultItem));
    when(this.trabajoRepositoryCustom.findEmpresasCalcularProgramados(any(TrabajoDTO.class), anyList(), anyList()))
        .thenReturn(List.of(empresaNoCalcular));

    final TrabajoDTO result = this.trabajoServiceImpl.create(trabajo);

    assertNotNull(result);
    verify(this.trabajoMapper, times(1)).trabajoDtoToTrabajo(any(TrabajoDTO.class));
    verify(this.trabajoRepository, times(1)).save(any(Trabajo.class));
    verify(this.trabajoMapper, times(1)).trabajoToTrabajoDto(any(Trabajo.class));
    verify(this.incomeMetaService, times(1)).getPeriodos(anyString(), anyInt(), anyBoolean(), anyBoolean());
    verify(this.periodoMapper, times(1)).periodoResponseDtoToPeriodoDto(mockPeriodoResponse);
    verify(this.meta4IcmWsCalcIncomeSessionService, times(1)).getEmpresa(any(EmpresaRequestDto.class));
    verify(this.trabajoRepositoryCustom, times(1)).findEmpresasCalcularProgramados(any(TrabajoDTO.class), anyList(), anyList());

    assertNull(result.getEmpresa());
    verify(this.meta4IcmWsCalcIncomeService, times(1)).saveProceso(any(SaveProcesoDto.class));
    verify(this.senderTrabajo, times(1)).send(any(TrabajoDTO.class));
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
  void updateEstadoTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final EstadoTrabajoDTO estado = new EstadoTrabajoDTO();
    estado.setId(1);

    doNothing().when(this.trabajoRepositoryCustom).updateEstado(any(TrabajoDTO.class), any(EstadoTrabajoDTO.class));

    this.trabajoServiceImpl.updateEstado(trabajo, estado);

    assertEquals(estado, trabajo.getEstadoTrabajo());
    verify(this.trabajoRepositoryCustom, times(1)).updateEstado(trabajo, estado);
  }

  @Test
  void updateFechaFinTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(1L);

    doNothing().when(this.trabajoRepositoryCustom).updateFechaFin(any(TrabajoDTO.class));

    this.trabajoServiceImpl.updateFechaFin(trabajo);

    verify(this.trabajoRepositoryCustom, times(1)).updateFechaFin(trabajo);
  }

  @Test
  void findEmpresasCalcularProgramadosTest() {
    final TrabajoDTO trabajoDTO = mock(TrabajoDTO.class);
    trabajoDTO.setIdProgramacion(1L);
    final List<String> origen = mock(List.class);
    final List<String> empresa = mock(List.class);

    this.trabajoServiceImpl.findEmpresasCalcularProgramados(trabajoDTO, origen, empresa);
    verify(this.trabajoRepositoryCustom, times(1)).findEmpresasCalcularProgramados(any(TrabajoDTO.class), any(List.class), any(List.class));
  }

}
