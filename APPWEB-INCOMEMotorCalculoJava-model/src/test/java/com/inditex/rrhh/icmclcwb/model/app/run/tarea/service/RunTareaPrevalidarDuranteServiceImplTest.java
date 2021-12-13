package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
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
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class RunTareaPrevalidarDuranteServiceImplTest {

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

  @InjectMocks
  private RunTareaPrevalidarDuranteServiceImpl runTareaPrevalidarDuranteServiceImpl;

  @Random
  private RunTareaDto runTareaDto;

  @Random
  private FaseDto faseDto;

  @Random
  private AccionDto accionDto;

  @Mock
  private RunPrevalidar runPrevalidar;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.runTareaPrevalidarDuranteServiceImpl, "threadSize", 1, true);
    }

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

        this.runTareaPrevalidarDuranteServiceImpl.run(runTareaDto, faseDto, accionDto);

        verify(this.tareaFaseAccionService, timeout(1000).times(1))
            .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
                any(Long.class), any(Integer.class),
                any(Integer.class), any(Integer.class));

        verify(this.tareaFaseService, timeout(1000).times(1))
            .findTareaFaseDtoByIdTareaAndIdFase(
                any(Long.class), any(Integer.class));
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


        final List<TareaFaseAccionDto> tareaFaseAccion = Arrays
            .asList(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
            any(Long.class),
            any(Integer.class), any(Integer.class), any(Integer.class))).thenReturn(tareaFaseAccion);
        when(this.accionService.findAccionDtoById(any(Integer.class)))
            .thenReturn(AccionDto.builder().id(1).nombre("Nombre").peso(100).build());

        final RunPrevalidar service = mock(RunPrevalidar.class);

        final CompletableFuture<List<ValidacionDto>> cfValid = new CompletableFuture<>();
        final ValidacionDto validacion = new ValidacionDto();
        validacion.setResult(Boolean.TRUE);
        validacion.setIdTareaFaseAccion(1L);
        cfValid.complete(Arrays.asList(validacion));

        when(this.runPrevalidarFactory.getRunPrevalidar(any(String.class))).thenReturn(service);
        when(service.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class))).thenReturn(cfValid);
        when(this.tareaFaseAccionService.findById(any(Long.class)))
            .thenReturn(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        try {
            this.runTareaPrevalidarDuranteServiceImpl.run(runTareaDto, faseDto, accionDto);
        } catch (final Exception e) {
            assertThat(e instanceof ValidationException);
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

        final List<TareaFaseAccionDto> tareaFaseAccion = Arrays
            .asList(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
            any(Long.class),
            any(Integer.class), any(Integer.class), any(Integer.class))).thenReturn(tareaFaseAccion);
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
        validacion.setIdPersonaLocal(Arrays.asList("111"));
        cfValid.complete(Arrays.asList(validacion));

        when(this.runPrevalidarFactory.getRunPrevalidar(any(String.class))).thenReturn(service);
        when(service.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class))).thenReturn(cfValid);
        when(this.tareaFaseAccionService.findById(any(Long.class)))
            .thenReturn(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        try {
            this.runTareaPrevalidarDuranteServiceImpl.run(runTareaDto, faseDto, accionDto);
        } catch (final Exception e) {
            assertThat(e instanceof ValidationReintentoException);
        }

    }

  @Test
  void runExceptionTest(@Random AccionDto accion,
      @Random(type = TareaFaseAccionDto.class, size = 2) List<TareaFaseAccionDto> tareaFaseAccionDtoList,
      @Random CompletableFuture<List<ValidacionDto>> cfRun, @Random TareaFaseDto tareaFase,
      @Random(type = ValidacionDto.class, size = 2) List<ValidacionDto> validacionDtoList,
      @Random TareaFaseAccionDto tareaFaseAccionDto,
      @Random SincronizacionResponseDto sincronizacionResponseDto) {

    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {

      doReturn(tareaFaseAccionDtoList).when(this.tareaFaseAccionService)
          .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(this.runTareaDto.getTarea().getId(), this.faseDto.getId(),
              this.accionDto.getId(),
              PuntoEjecucionEnum.DURANTE.getId());

      Map<Integer, List<TareaFaseAccionDto>> fases = tareaFaseAccionDtoList.stream()
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

      doReturn(tareaFase).when(this.tareaFaseService)
          .findTareaFaseDtoByIdTareaAndIdFase(this.runTareaDto.getTarea().getId(), this.faseDto.getId());

      List<ValidacionDto> fallidas = validaciones.stream().filter(e -> Boolean.FALSE.equals(e.getResult()))
          .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso).reversed()).map(e -> {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccionDto,
                EstadoTareaFaseAccionEnum.KO.getDto());
            this.tareaFaseService.updateFechaFinAndEstado(tareaFase,
                EstadoTareaFaseEnum.KO.getDto());
            return e;
          }).collect(Collectors.toList());
      for (ValidacionDto e : fallidas) {
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

      assertThrows(ValidationException.class, () -> {
        this.runTareaPrevalidarDuranteServiceImpl.run(this.runTareaDto, this.faseDto, this.accionDto);
      });
    }
  }

}
