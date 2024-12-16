package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class RunTareaPrevalidarAntesServiceImplTest {

  @Mock
  private LimpiezaService limpiezaService;

  @Mock
  private MailService mailService;

  @Mock
  private SenderTarea senderTarea;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private RunPrevalidarFactory runPrevalidarFactory;

  @Mock
  private AccionService accionService;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private TareaFaseService tareaFaseService;

  @Mock
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  @Mock
  private Logger log;

  @InjectMocks
  private RunTareaPrevalidarAntesServiceImpl runTareaPrevalidarAntesServiceImpl;

  final RunTareaDto runTareaDto = Instancio.create(RunTareaDto.class);

  final FaseDto faseDto = Instancio.create(FaseDto.class);

  @Mock
  private RunPrevalidar runPrevalidar;

  @Mock
  private MailEntornoService mailEntornoService;

  @Test
  public void run()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    this.runTareaPrevalidarAntesServiceImpl.run(runTareaDto, faseDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
            any(Long.class), any(Integer.class),
            any(Integer.class));

  }

  @Test
  public void runFasesOK()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final List<TareaFaseAccionDto> tareaFaseAccion =
        Collections.singletonList(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(any(Long.class),
        any(Integer.class), any(Integer.class))).thenReturn(tareaFaseAccion);
    when(this.accionService.findAccionDtoById(any(Integer.class)))
        .thenReturn(AccionDto.builder().id(1).nombre("Nombre").peso(100).build());

    final RunPrevalidar service = mock(RunPrevalidar.class);

    final CompletableFuture<List<ValidacionDto>> cfValid = new CompletableFuture<>();
    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.TRUE);
    validacion.setIdTareaFaseAccion(1L);
    cfValid.complete(List.of(validacion));

    when(this.runPrevalidarFactory.getRunPrevalidar(any(String.class))).thenReturn(service);
    when(service.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class))).thenReturn(cfValid);
    when(this.tareaFaseAccionService.findById(any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

    try {
      this.runTareaPrevalidarAntesServiceImpl.run(runTareaDto, faseDto);
    } catch (final Exception e) {
      assertFalse(ValidationException.class.isAssignableFrom(e.getClass()));
    }

  }

  @Test
  public void runFasesKO()
      throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final List<TareaFaseAccionDto> tareaFaseAccion =
        Collections.singletonList(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(any(Long.class),
        any(Integer.class), any(Integer.class))).thenReturn(tareaFaseAccion);
    when(this.tareaFaseAccionService.countReintentosByIdTareaAndIdAccionAndIdEstado(any(TareaFaseAccionDto.class),
        any(TareaFaseDto.class))).thenReturn(1);
    when(this.accionService.findAccionDtoById(any(Integer.class)))
        .thenReturn(AccionDto.builder()
            .id(1)
            .nombre("Nombre")
            .esReaccionReintento(Boolean.TRUE)
            .esReaccionEsperar(Boolean.FALSE)
            .reintentoMax(2)
            .peso(100)
            .build());

    final RunPrevalidar service = mock(RunPrevalidar.class);

    final CompletableFuture<List<ValidacionDto>> cfValid = new CompletableFuture<>();
    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.FALSE);
    validacion.setIdTareaFaseAccion(1L);
    validacion.setSincronizacion(Boolean.TRUE);
    validacion.setIdPersonaLocal(List.of("111"));
    cfValid.complete(List.of(validacion));

    when(this.runPrevalidarFactory.getRunPrevalidar(any(String.class))).thenReturn(service);
    when(service.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class))).thenReturn(cfValid);
    when(this.tareaFaseAccionService.findById(any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

    try {
      this.runTareaPrevalidarAntesServiceImpl.run(runTareaDto, faseDto);
    } catch (final Exception e) {
      assertFalse(ValidationReintentoException.class.isAssignableFrom(e.getClass()));
    }

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void runExceptionTest(final TareaFaseDto tareaFase, final AccionDto accionDto,
      final List<TareaFaseAccionDto> tareaFaseAccionDtoList,
      final TareaFaseAccionDto tareaFaseAccionDto,
      final CompletableFuture<List<ValidacionDto>> cfRun,
      final SincronizacionResponseDto sincronizacionResponseDto) {
    final AccionDto accion = new AccionDto();
    accion.setEsReaccionReintento(true);
    accion.setReintentoMax(3);
    accion.setId(1);
    final List<ValidacionDto> validacionDtoList = new ArrayList<>();
    validacionDtoList
        .add(ValidacionDto.builder().result(Boolean.FALSE).reaccionPeso(1).idPersonaLocal(List.of("1", "2")).idTareaFaseAccion(1L)
            .idMotivosDesplazamiento(List.of(1, 2)).build());

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      doReturn(tareaFase).when(this.tareaFaseService)
          .findTareaFaseDtoByIdTareaAndIdFase(this.runTareaDto.getTarea().getId(), this.faseDto.getId());

      doReturn(tareaFaseAccionDtoList).when(this.tareaFaseAccionService)
          .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(this.runTareaDto.getTarea().getId(), this.faseDto.getId(),
              PuntoEjecucionEnum.ANTES.getId());
      final Map<Integer, List<TareaFaseAccionDto>> fases = tareaFaseAccionDtoList.stream()
          .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso).reversed())
          .collect(Collectors.groupingBy(TareaFaseAccionDto::getPeso));

      final List<ValidacionDto> validaciones = new ArrayList<>();
      for (final Integer pesos : fases.keySet()) {
        for (final TareaFaseAccionDto tareaFaseAccion : fases.get(pesos)) {
          doReturn(accionDto).when(this.accionService).findAccionDtoById(tareaFaseAccion.getIdAccion());

          doReturn(this.runPrevalidar).when(this.runPrevalidarFactory).getRunPrevalidar(accionDto.getNombre());
          doReturn(cfRun).when(this.runPrevalidar).execute(this.runTareaDto, tareaFaseAccion);

          utilities.when(() -> AsyncUtils.get(cfRun)).thenReturn(validacionDtoList);
          validaciones.addAll(validacionDtoList);
        }
      }

      final List<ValidacionDto> fallidas = validaciones.stream().filter(e -> Boolean.FALSE.equals(e.getResult()))
          .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso).reversed()).map(e -> {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccionDto,
                EstadoTareaFaseAccionEnum.KO.getDto());
            this.tareaFaseService.updateFechaInicioAndFechaFinAndEstado(tareaFase,
                EstadoTareaFaseEnum.KO.getDto());
            return e;
          }).collect(Collectors.toList());
      for (final ValidacionDto e : fallidas) {
        doReturn(tareaFaseAccionDto).when(this.tareaFaseAccionService).findById(e.getIdTareaFaseAccion());
      }

      // Preparacion de datos para la ejecucion del siguiente doReturn
      fallidas.stream().forEach(e -> {
        final List<SincronizacionFilterParametersDto> filterParameters = e
            .getIdPersonaLocal()
            .stream()
            .map(
                f -> SincronizacionFilterParametersDto.builder()
                    .idOrigen(e.getCclIdOrigen())
                    .idEmpresa(AppConstants.ID_ORIGEN_SPAIN.equals(e.getCclIdOrigen())
                        ? e.getStdIdLegEnt()
                        : null)
                    .idEmpleado(f)
                    .fechaInicio(this.runTareaDto.getTarea().getFechaInicioPeriodo())
                    .fechaFin(this.runTareaDto.getTarea().getFechaFinPeriodo())
                    .build())
            .collect(Collectors.toList());
        final SincronizacionFilterDto filter = SincronizacionFilterDto.builder()
            .items(filterParameters)
            .build();
        final SincronizacionRequestDto request = new SincronizacionRequestDto();
        request.setData(filter);

        doReturn(sincronizacionResponseDto).when(this.meta4IcmWsCalcIncomeService).sincronizacion(request);
      });

      doReturn(tareaFaseAccionDto).when(this.tareaFaseAccionService).findById(fallidas.get(0).getIdTareaFaseAccion());
      doReturn(accion).when(this.accionService).findAccionDtoById(tareaFaseAccionDto.getIdAccion());
      doReturn(2).when(this.tareaFaseAccionService).countReintentosByIdTareaAndIdAccionAndIdEstado(
          tareaFaseAccionDto, tareaFase);

      assertThrows(ValidationReintentoException.class, () -> {
        this.runTareaPrevalidarAntesServiceImpl.run(this.runTareaDto, this.faseDto);
      });

      accion.setEsReaccionEsperar(false);
      assertThrows(ValidationReintentoException.class, () -> {
        this.runTareaPrevalidarAntesServiceImpl.run(this.runTareaDto, this.faseDto);
      });

      accion.setEsReaccionReintento(false);
      assertThrows(ValidationException.class, () -> {
        this.runTareaPrevalidarAntesServiceImpl.run(this.runTareaDto, this.faseDto);
      });
    }
  }

}
