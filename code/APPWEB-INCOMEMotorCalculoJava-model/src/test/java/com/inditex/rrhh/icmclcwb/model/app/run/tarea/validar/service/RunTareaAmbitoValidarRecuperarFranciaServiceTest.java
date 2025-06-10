package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.AvisosGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.ErorresGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoValidarRecuperarFranciaServiceTest {

  @Mock
  private ComisService comisService;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @InjectMocks
  private RunTareaAmbitoValidarRecuperarFranciaServiceImpl runTareaAmbitoValidarRecuperarFranciaServiceImpl;

  @Test
  public void executeTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDto);
    runTareaDto.getTrabajo().setIdSimulacion(null);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1").build());

    final List<IdPersonaLocalCarenciaDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalCarenciaDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    final LiquidacionResponseDto response = new LiquidacionResponseDto();
    final LiquidacionResultItemDto result = new LiquidacionResultItemDto();
    response.setData(new ArrayList<>());
    result.setResultado("KO");
    result.setAvisos(AvisosGuardadoResultItemDto.builder().resultado("KO").avisos(new ArrayList<>()).build());
    result.setErrores(ErorresGuardadoResultItemDto.builder().resultado("KO").errores(new ArrayList<>()).build());
    response.getData().add(result);

    when(this.meta4IcmWsCalcIncomeService.liquidacion(any(LiquidacionRequestDto.class))).thenReturn(response);

    when(this.comisService.validateTempComisRecuperarFrancia(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(personas);

    this.runTareaAmbitoValidarRecuperarFranciaServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.validacionMapper, timeout(1000).times(1))
        .booleanToValidacionDto(ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class), any(Boolean.class));
  }

  @Test
  public void executeEmptyPersonasTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDto);
    runTareaDto.getTrabajo().setIdSimulacion(null);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final List<IdPersonaLocalDto> personas = new ArrayList<>();

    final List<IdPersonaLocalCarenciaDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalCarenciaDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.comisService.validateTempComisRecuperarFrancia(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(personas);

    this.runTareaAmbitoValidarRecuperarFranciaServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.validacionMapper, timeout(1000).times(1))
        .booleanToValidacionDto(ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class), any(Boolean.class));
  }

  @Test
  public void executeWhenExceptionThrownTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDto);
    runTareaDto.getTrabajo().setIdSimulacion(null);

    // Arrange
    when(this.comisService.validateTempComisRecuperarFrancia(any(), any()))
        .thenThrow(new RuntimeException("Test exception"));

    // Act & Assert
    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoValidarRecuperarFranciaServiceImpl.execute(runTareaDto, new TareaAmbitoDto(), new TareaFaseAccionDto());
    });

    // Verify
    verify(this.tareaFaseAccionService, times(1)).updateFechaFinAndEstado(any(), any());
  }
}
