package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.async.service.PtrAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppTestConstants;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.AjusteComisionDTO;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.dto.RelojDTO;
import com.inditex.rrhh.icmclcwb.dto.SsoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.core5.http.HttpStatus;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestServiceImpl implements TestService {

  private static final String CONTROLLED_TIMEOUT = "Controlled timeout";

  private static final String CODE = "Code";

  private static final String EXCEPTION = "Exception";

  private static final String OK = "OK";

  private static final String KO = "KO";

  @Value("${amiga.common.oauth2-client.default-client-config.uri-token:sinvaloroauthproperty}")
  String oauthProperty;

  private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);

  @Autowired
  private TestExceptionService testExceptionService;

  @Autowired
  private TestExceptionAsyncService testExceptionAsyncService;

  @Autowired
  private TrabajoService trabajoService;

  @Autowired
  private ProgramacionService programacionService;

  @Autowired
  private MailSender mailSender;

  @Autowired
  private ComisService comisService;

  @Autowired
  private PtrService ptrService;

  @Autowired
  @Qualifier("slrhorcomsClient")
  private RestClient slrhorcomsClient;

  @Autowired
  @Qualifier("meta4ClientPool")
  private Meta4ClientPool meta4ClientPool;

  @Autowired
  private PtrRepositoryCustom ptrRepositoryCustom;

  @Autowired
  private PtrAsyncService ptrAsyncService;

  @Autowired
  @Qualifier("slrhorcomsProperties")
  private Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

  @Autowired
  private TareaRepositoryCustom tareaRepositoryCustom;

  @Autowired
  private TestNormalizacionAsyncService testNormalizacionAsyncService;

  @Override
  public RelojDTO reloj() {
    return new RelojDTO();
  }

  @Override
  // TODO: REVISAR
  public SsoDTO sso() {
    final SsoDTO sso = new SsoDTO();
    return sso;
  }

  @Override
  public void errorSync() {
    this.testExceptionService.icmclcwbException();
  }

  @Override
  public void errorAsync() {
    final CompletableFuture<Void> cfErrorAsync1 = this.testExceptionAsyncService.icmclcwbException();
    AsyncUtils.exceptionally(cfErrorAsync1, new ArrayList<>());

    final CompletableFuture<Void> cfErrorAsync2 = this.testExceptionAsyncService.icmclcwbException();
    AsyncUtils.exceptionally(cfErrorAsync2, new ArrayList<>());

    final CompletableFuture<Void> cfErrorAsyncAllOf = CompletableFuture.allOf(cfErrorAsync1, cfErrorAsync2);
    AsyncUtils.exceptionally(cfErrorAsyncAllOf, new ArrayList<>());
    cfErrorAsyncAllOf.join();
  }

  @Override
  public void sesion() {
    final IcmParamcalempleadosRecord itemGetempleados = new IcmParamcalempleadosRecord();
    itemGetempleados.setFechainicio("2017-07-01T00:00:00.000Z");
    itemGetempleados.setFechafin("2017-12-31T00:00:00.000Z");
    itemGetempleados.setIdorigen("11");
    itemGetempleados.setIdempresa("8");
    final IcmParamcalempleadosBlock filterGetempleados = new IcmParamcalempleadosBlock();
    // itemGetempleados.setIdlugartrabajo("T57");
    filterGetempleados.getIcmParamcalempleadosRecordSet().add(itemGetempleados);

    final IcmParametrospaginacionBlock pageGetempleados = new IcmParametrospaginacionBlock();
    pageGetempleados.setCampoorden("idempleado");
    pageGetempleados.setNumeropagina("1");
    pageGetempleados.setNumeroregistrospagina("200");
    pageGetempleados.setTipoorden("DESC");
    pageGetempleados.setIdbusqueda(StringUtils.EMPTY);
    pageGetempleados.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

    GetempleadosOutput outputGetempleados;
    outputGetempleados = this.meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
    TestServiceImpl.LOG.info("outputGetempleados: {}", outputGetempleados.getReturn());
    outputGetempleados = this.meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
    TestServiceImpl.LOG.info("outputGetempleados: {}", outputGetempleados.getReturn());
    outputGetempleados = this.meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
    TestServiceImpl.LOG.info("outputGetempleados: {}", outputGetempleados.getReturn());

    final IcmParamcaltiendasBlock filterSearchTiendas = new IcmParamcaltiendasBlock();
    final IcmParamcaltiendasRecord itemSearchTiendas = new IcmParamcaltiendasRecord();
    itemSearchTiendas.setFechainicio("2017-07-01T00:00:00.000Z");
    itemSearchTiendas.setFechafin("2017-12-31T00:00:00.000Z");
    itemSearchTiendas.setIdorigen("11");
    itemSearchTiendas.setIdempresa("8");
    itemSearchTiendas.setIdlugartrabajo("T57");
    filterSearchTiendas.getIcmParamcaltiendasRecordSet().add(itemSearchTiendas);

    final IcmParametrospaginacionBlock pageSearchtiendas = new IcmParametrospaginacionBlock();
    pageSearchtiendas.setCampoorden("idempleado");
    pageSearchtiendas.setNumeropagina("1");
    pageSearchtiendas.setNumeroregistrospagina("200");
    pageSearchtiendas.setTipoorden("DESC");
    pageSearchtiendas.setIdbusqueda(StringUtils.EMPTY);
    pageSearchtiendas.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

    SearchtiendasOutput outputSearchtiendas;
    outputSearchtiendas = this.meta4ClientPool.searchtiendas(filterSearchTiendas, pageSearchtiendas);
    TestServiceImpl.LOG.info("outputGetempleados: {}", outputSearchtiendas.getReturn());
    outputSearchtiendas = this.meta4ClientPool.searchtiendas(filterSearchTiendas, pageSearchtiendas);
    TestServiceImpl.LOG.info("outputGetempleados: {}", outputSearchtiendas.getReturn());
    outputSearchtiendas = this.meta4ClientPool.searchtiendas(filterSearchTiendas, pageSearchtiendas);
    TestServiceImpl.LOG.info("outputGetempleados: {}", outputSearchtiendas.getReturn());

    TestServiceImpl.LOG.error("Test sesion()");
  }

  @Override
  // TODO [COMUN] Rehacer este test
  public void programacionBatch() {
    this.programacionService.activa();
    for (int x = 1; x <= 100; x++) {
      this.programacionService.reset();
      // runProgramacionService.run();
    }
  }

  @Override
  public Boolean testUrl(@NotBlank final String url) {
    int code = HttpStatus.SC_OK;
    try {
      final URL siteURL = new URL(url);
      final HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
      connection.setRequestMethod(HttpMethod.POST.name());
      connection.setConnectTimeout(30000);
      connection.connect();
      code = connection.getResponseCode();

      switch (code) {
        case HttpStatus.SC_REQUEST_TIMEOUT:
        case HttpStatus.SC_GATEWAY_TIMEOUT:
        case 598:
        case 524:
          TestServiceImpl.LOG.error(url
              + ": "
              + KO
              + ", "
              + CONTROLLED_TIMEOUT
              + ", "
              + CODE
              + ": "
              + code);
          return Boolean.FALSE;
        default:
          break;
      }

    } catch (final Exception e) {
      TestServiceImpl.LOG.error(url
          + ": "
          + KO
          + ", "
          + EXCEPTION
          + ": "
          + e);
      return Boolean.FALSE;
    }

    TestServiceImpl.LOG.info(url
        + ": "
        + OK
        + ", "
        + CODE
        + ": "
        + code);
    return Boolean.TRUE;
  }

  @Override
  public void trabajoFase1a() {
    AppTestConstants.getFASE_1A().stream().forEach(item -> {
      final String[] values = StringUtils.split(item, ",");
      final String sociedad = values[0];
      final String origen = values[1];
      final String empresa = values[2];
      for (int x = 0; x < 70; x++) {
        final TrabajoDTO trabajo = new TrabajoDTO();
        final LocalDate fechaInicio = TimeUtils.nowLocalDate()
            .minusMonths(x)
            .with(TemporalAdjusters.firstDayOfMonth())
            .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
        final LocalDate fechaFin = TimeUtils.nowLocalDate()
            .minusMonths(x)
            .with(TemporalAdjusters.lastDayOfMonth())
            .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
        trabajo.setIcmIdPeriodo(0L);
        trabajo.setFechaInicioPeriodo(fechaInicio.atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
        trabajo.setFechaFinPeriodo(fechaFin.atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
        trabajo.setIdOrganization(sociedad);
        final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDTO();
        trabajoAmbitoOrigenDto.setCclIdOrigen(origen);
        trabajo.setOrigen(List.of(trabajoAmbitoOrigenDto));
        final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
        trabajoAmbitoEmpresa.setStdIdLegEnt(empresa);
        trabajo.setEmpresa(List.of(trabajoAmbitoEmpresa));
        trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
        this.trabajoService.create(trabajo);
      }
    });
  }

  @Override
  public void testBloqueos(@NotNull final Long limit) {
    AppTestConstants.getTEST().stream().collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
      Collections.shuffle(collected);
      return collected.stream();
    })).limit(limit).collect(Collectors.toList()).forEach(item -> {
      final String[] values = StringUtils.split(item, ",");
      final String sociedad = values[0];
      final String origen = values[1];
      final String empresa = values[2];
      final String localizacion = values[3];
      final String persona = values[4];
      final String orPersona = values[5];
      final Integer tipo = 4;
      final TrabajoDTO trabajo = new TrabajoDTO();
      switch (tipo) {
        case 1:
          this.testSociedad(sociedad, trabajo);
          trabajo.setTipoAmbito(TipoAmbitoEnum.SOCIEDAD.getDto());
          break;
        case 2:
          this.testOrigen(sociedad, origen, trabajo);
          trabajo.setTipoAmbito(TipoAmbitoEnum.ORIGEN.getDto());
          break;
        case 3:
          this.testEmpresa(sociedad, origen, empresa, trabajo);
          trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
          break;
        case 4:
          this.testLocalizacion(sociedad, origen, empresa, localizacion, trabajo);
          trabajo.setTipoAmbito(TipoAmbitoEnum.LOCALIZACION.getDto());
          break;
        case 5:
          this.testPersona(sociedad, origen, empresa, persona, orPersona, trabajo);
          trabajo.setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
          break;
        default:
          break;
      }

      this.trabajoService.create(trabajo);
    });
  }

  @Override
  public String sqlFormatter(@NotBlank final String sql) {
    return new BasicFormatterImpl().format(StringUtils.normalizeSpace(StringUtils.trim(sql)));
  }

  private void testSociedad(final String sociedad, final TrabajoDTO trabajo) {
    trabajo.setIcmIdPeriodo(1L);
    trabajo.setFechaInicioPeriodo(LocalDate.of(2015, 3, 1).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    trabajo.setFechaFinPeriodo(LocalDate.of(2015, 3, 31).atTime(LocalTime.MIDNIGHT).atOffset(ZoneOffset.UTC));
    trabajo.setIdOrganization(sociedad);
  }

  private void testOrigen(final String sociedad, final String origen, final TrabajoDTO trabajo) {
    this.testSociedad(sociedad, trabajo);
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigenDto.setCclIdOrigen(origen);
    trabajo.setOrigen(List.of(trabajoAmbitoOrigenDto));
  }

  private void testEmpresa(final String sociedad, final String origen, final String empresa,
      final TrabajoDTO trabajo) {
    this.testOrigen(sociedad, origen, trabajo);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.setStdIdLegEnt(empresa);
    trabajo.setEmpresa(List.of(trabajoAmbitoEmpresa));
  }

  private void testLocalizacion(final String sociedad, final String origen, final String empresa,
      final String localizacion,
      final TrabajoDTO trabajo) {
    this.testEmpresa(sociedad, origen, empresa, trabajo);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.setStdIdWorkLocat(localizacion);
    trabajoAmbitoLocalizacion.setStdIdLegEnt(empresa);
    trabajoAmbitoLocalizacion.setCclIdOrigen(origen);
    trabajo.setLocalizacion(List.of(trabajoAmbitoLocalizacion));
  }

  private void testPersona(final String sociedad, final String origen, final String empresa, final String persona,
      final String orPersona, final TrabajoDTO trabajo) {
    this.testEmpresa(sociedad, origen, empresa, trabajo);
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.setCclIdPerson(persona);
    trabajoAmbitoPersona.setStdOrHrPeriod(orPersona);
    trabajoAmbitoPersona.setStdIdLegEnt(empresa);
    trabajoAmbitoPersona.setCclIdOrigen(origen);
    trabajo.setPersona(List.of(trabajoAmbitoPersona));
  }

  @Override
  public void sendMail() {
    final SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@inditex.com");
    message.setTo("income-java@vectoritcgroup.com");
    message.setSubject("Lorem ipsum");
    message.setText(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure"
            + " dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat"
            + " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    this.mailSender.send(message);
  }

  @Override
  public void comisTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    runTareaDto.setTrabajo(trabajoDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("38");
    this.comisService.findMotivoDesplazamiento(runTareaDto, tareaAmbitoDto);
  }

  @Override
  public void ptrTestService() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    runTareaDto.setTrabajo(trabajoDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("38");
    tareaDto.setFechaInicioPeriodo(LocalDate.of(2015, 3, 1));
    tareaDto.setFechaFinPeriodo(LocalDate.of(2015, 3, 31));
    this.ptrService.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
  }

  @Override
  public void ptrTestBbddSync() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setFechaInicioPeriodo(LocalDate.of(2021, 8, 1));
    tareaDto.setFechaFinPeriodo(LocalDate.of(2021, 8, 31));
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("528");
    this.ptrRepositoryCustom.findPresenciasOrigenAndFecha(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void ptrTestBbddAsync() {
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setFechaInicioPeriodo(LocalDate.of(2021, 8, 1));
    tareaDto.setFechaFinPeriodo(LocalDate.of(2021, 8, 31));
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("528");
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTrabajo(trabajoDto);
    runTareaDto.setTarea(tareaDto);
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr1 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr1, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr2 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr2, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr3 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr3, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr4 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr4, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr5 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr5, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr6 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr6, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr7 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr7, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr8 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr8, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr9 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr9, cf);
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr10 = this.ptrAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
      AsyncUtils.exceptionally(cfPresenciaPtr10, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      TestServiceImpl.LOG.error("ptrTestBbddAsync", e);
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void slrhorcomsTest() {

    TestServiceImpl.LOG.info("URI-STRING: {}", this.oauthProperty);

    final String endpoint = this.slrhorcomsProperties
        .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO)
        .getEndpoint();

    TestServiceImpl.LOG.info("ENDPOINT: {}", endpoint);

    final ResponseEntity<HorarioComercialFestivoDocDto[]> responseHorarioComercial = this.slrhorcomsClient
        .getForEntity(endpoint + "q=*",
            HorarioComercialFestivoDocDto[].class);
    TestServiceImpl.LOG.info("responseHorarioComercial: {}",
        responseHorarioComercial);
  }

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Override
  public AjusteComisionDTO normalizarAjusteComision(
      @Positive @NotNull final Integer limit) {

    final AjusteComisionDTO result = new AjusteComisionDTO();
    final List<IdTareaDTO> tareasAEjecutar = this.tareaRepositoryCustom
        .findTareasConsolidadesSinAjusteComision(limit);
    result.setIdTarea(tareasAEjecutar);
    result.setTareasProcesadas(tareasAEjecutar.size());
    result.setTareasPendientes(
        this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision() - tareasAEjecutar.size());
    final CompletableFuture<Void> cfNormalizar = this.testNormalizacionAsyncService
        .normalizarAjusteComision(tareasAEjecutar);
    AsyncUtils.exceptionally(cfNormalizar, new ArrayList<>());
    return result;
  }

  // Fin de normalización de tareas consolidadas (para borrar)

}
