package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUser;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUtils;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

  @Autowired
  private TrabajoRepository trabajoRepository;

  @Autowired
  private TrabajoRepositoryCustom trabajoRepositoryCustom;

  @Autowired
  private TrabajoMapper trabajoMapper;

  @Autowired
  private PeriodoMapper periodoMapper;

  @Autowired
  private TrabajoAmbitoOrigenService trabajoAmbitoOrigenService;

  @Autowired
  private TrabajoAmbitoEmpresaService trabajoAmbitoEmpresaService;

  @Autowired
  private TrabajoAmbitoLocalizacionService trabajoAmbitoLocalizacionService;

  @Autowired
  private TrabajoAmbitoPersonaService trabajoAmbitoPersonaService;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private IncomeMetaService incomeMetaService;

  @Autowired
  private SenderTrabajo senderTrabajo;

  @Autowired
  @Qualifier("meta4Properties")
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Override
  public TrabajoDTO findByIdWithStates(@NotNull @Positive final Long id) {

    final Trabajo trabajoData = this.trabajoRepository.findByIdAndEstadoIdIn(id, AppConstants.ESTADOS_RUN_TRABAJO_OK);
    if (trabajoData == null) {
      return null;
    }

    final TrabajoDTO trabajo = this.trabajoMapper
        .trabajoToTrabajoDto(trabajoData);
    trabajo.setOrigen(this.trabajoAmbitoOrigenService.findByTrabajo(trabajo));
    trabajo.setEmpresa(this.trabajoAmbitoEmpresaService.findByTrabajo(trabajo));
    trabajo.setLocalizacion(this.trabajoAmbitoLocalizacionService.findByTrabajo(trabajo));
    trabajo.setPersona(this.trabajoAmbitoPersonaService.findByTrabajo(trabajo));

    return trabajo;
  }

  @Override
  public TrabajoDTO find(@NotNull @Positive final Long id) {
    final TrabajoDTO trabajo = this.trabajoMapper.trabajoToTrabajoDto(this.trabajoRepository.findById(id).get());
    trabajo.setOrigen(this.trabajoAmbitoOrigenService.findByTrabajo(trabajo));
    trabajo.setEmpresa(this.trabajoAmbitoEmpresaService.findByTrabajo(trabajo));
    trabajo.setLocalizacion(this.trabajoAmbitoLocalizacionService.findByTrabajo(trabajo));
    trabajo.setPersona(this.trabajoAmbitoPersonaService.findByTrabajo(trabajo));
    return trabajo;
  }

  @Override
  // TODO: Revisar si es login o username
  public TrabajoDTO create(@Valid @TrabajoValidator final TrabajoDTO trabajo) {

    trabajo.setFechaHoraCreacion(TimeUtils.nowLocalDateTime().atOffset(ZoneOffset.UTC));
    trabajo.setEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE.getDto());
    if (StringUtils.isBlank(trabajo.getNombreUsuario())) {
      final HeimdalUser heimdalUser = HeimdalUtils.getHeimdalUser();
      if (StringUtils.isNotBlank(heimdalUser.getLogin())) {
        trabajo.setNombreUsuario(heimdalUser.getLogin());
      }
    }

    // TODO: Revisar estas fechas
    final PeriodoDTO periodo = this.periodoMapper.periodoResponseDtoToPeriodoDto(
        this.incomeMetaService.getPeriodos(trabajo.getIdOrganization(), trabajo.getIcmIdPeriodo().intValue(), true, true));
    trabajo
        .setFechaInicioPeriodo(periodo.getFechaInicioPeriodo());
    trabajo.setFechaFinPeriodo(periodo.getFechaFinPeriodo());

    final TrabajoDTO result = this.trabajoMapper
        .trabajoToTrabajoDto(this.trabajoRepository.save(this.trabajoMapper.trabajoDtoToTrabajo(trabajo)));
    if (CollectionUtils.isNotEmpty(trabajo.getOrigen())) {
      result.setOrigen(this.trabajoAmbitoOrigenService.create(trabajo.getOrigen(), result));
    }

    if (CollectionUtils.isNotEmpty(trabajo.getEmpresa())) {
      result.setEmpresa(this.trabajoAmbitoEmpresaService.create(trabajo.getEmpresa(), result));
    }
    if (CollectionUtils.isNotEmpty(trabajo.getLocalizacion())) {
      result.setLocalizacion(this.trabajoAmbitoLocalizacionService.create(trabajo.getLocalizacion(), result));
    }
    if (CollectionUtils.isNotEmpty(trabajo.getPersona())) {
      result.setPersona(this.trabajoAmbitoPersonaService.create(trabajo.getPersona(), result));
    }
    List<IdOrigenEmpresaDto> empresasNoCalcular = new ArrayList<>();

    if (trabajo.getIdProgramacion() != null) {
      if (trabajo.getTipoAmbito().getId().equals(TipoAmbitoEnum.SOCIEDAD.getId())
          || trabajo.getTipoAmbito().getId().equals(TipoAmbitoEnum.ORIGEN.getId())) {
        final EmpresaRequestDto empresaRequestDto = new EmpresaRequestDto();
        empresaRequestDto.setData(new GenericFilterDto());
        empresaRequestDto.setPage(this.meta4Properties.get(Meta4PropertiesConstants.EMPRESA).getPage());
        empresaRequestDto.getData().setItem(new ArrayList<>());
        trabajo.getOrigen()
            .stream()
            .forEach(e -> empresaRequestDto.getData()
                .getItem()
                .add(GenericFilterParametersDto.builder().idOrigenReg(e.getCclIdOrigen()).build()));
        final List<EmpresaResultItemDto> origen = this.meta4IcmWsCalcIncomeSessionService.getEmpresa(empresaRequestDto);
        final List<TrabajoAmbitoEmpresaDTO> trabajoAmbitoEmpresa = origen.stream()
            .map(e -> {
              final TrabajoAmbitoEmpresaDTO ambitoEmpresa = new TrabajoAmbitoEmpresaDTO();
              ambitoEmpresa.setStdIdLegEnt(e.getIdEmpresa());
              ambitoEmpresa.setIdTrabajo(trabajo.getId());
              return ambitoEmpresa;
            })
            .collect(Collectors.toList());
        empresasNoCalcular = this.findEmpresasCalcularProgramados(trabajo,
            origen.stream().map(e -> e.getIdEmpresa()).collect(Collectors.toList()),
            trabajo.getOrigen().stream().map(e -> e.getCclIdOrigen()).collect(
                Collectors.toList()));
        final List<String> empresas = empresasNoCalcular.stream().map(e -> e.getStdIdLegEnt()).collect(Collectors.toList());
        result
            .setEmpresa(
                trabajoAmbitoEmpresa.stream().filter(e -> !empresas.contains(e.getStdIdLegEnt())).collect(Collectors.toList()));

        if (CollectionUtils.isEmpty(result.getEmpresa())) {
          this.updateEstado(result, EstadoTrabajoEnum.OK.getDto());
          this.updateFechaFin(result);
          return result;
        } else {
          result.setEmpresa(null);
        }
      }

      if (trabajo.getTipoAmbito().getId().equals(TipoAmbitoEnum.EMPRESA.getId())
          || trabajo.getTipoAmbito().getId().equals(TipoAmbitoEnum.LOCALIZACION.getId())
          || trabajo.getTipoAmbito().getId().equals(TipoAmbitoEnum.PERSONA.getId())) {

        empresasNoCalcular = this.findEmpresasCalcularProgramados(trabajo,
            trabajo.getEmpresa().stream().map(e -> e.getStdIdLegEnt()).collect(Collectors.toList()),
            trabajo.getOrigen().stream().map(e -> e.getCclIdOrigen()).collect(
                Collectors.toList()));
        final List<String> empresas = empresasNoCalcular.stream().map(e -> e.getStdIdLegEnt()).collect(Collectors.toList());
        result
            .setEmpresa(
                result.getEmpresa().stream().filter(e -> !empresas.contains(e.getStdIdLegEnt())).collect(Collectors.toList()));

        if (CollectionUtils.isEmpty(result.getEmpresa())) {
          this.updateEstado(result, EstadoTrabajoEnum.OK.getDto());
          this.updateFechaFin(result);
          return result;
        }
      }
    }
    // Guardado del trabajo en Meta4
    this.meta4IcmWsCalcIncomeService.saveProceso(this.trabajoMapper.trabajoDtoToSaveProcesoDto(result));
    // Envío del trabajo a la cola
    this.senderTrabajo.send(result);
    return result;
  }

  @Override
  public TrabajoDTO merge(@Valid @NotNull final ProgramacionDTO programacion,
      @Valid @NotNull final ProgramacionAmbitoDTO programacionAmbito, @Valid @NotNull final PeriodoDTO periodo) {
    return this.trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
        programacionAmbito,
        programacion, periodo);
  }

  @Override
  public void updateFechaFin(@NotNull final TrabajoDTO trabajo) {
    this.trabajoRepositoryCustom.updateFechaFin(trabajo);
  }

  @Override
  public void updateEstado(@NotNull final TrabajoDTO trabajo, @NotNull final EstadoTrabajoDTO estado) {
    trabajo.setEstadoTrabajo(estado);
    this.trabajoRepositoryCustom.updateEstado(trabajo, estado);
  }

  @Override
  public List<IdOrigenEmpresaDto> findEmpresasCalcularProgramados(@NotNull final TrabajoDTO trabajo,
      @NotNull final List<String> stdIdLegEnt,
      @NotNull final List<String> cclIdOrigen) {
    return this.trabajoRepositoryCustom.findEmpresasCalcularProgramados(trabajo, stdIdLegEnt,
        cclIdOrigen);
  }
}
