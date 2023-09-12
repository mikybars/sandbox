
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoValidarMotivosDesplazamientoServiceImplTest {

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private PrevalidarPropertiesDto fechaProperties;

  @Mock
  private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private RunTareaAmbitoValidarMotivosDesplazamientoServiceImpl runTareaAmbitoValidarMotivosDesplazamientoServiceImpl;

  @Test
  public void execute() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final List<IdMotivoDesplazamientoDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdMotivoDesplazamientoDto>> cfComis = new CompletableFuture<>();
    cfComis.complete(lista);

    final MotivosDesplazamientoResponseDto responseDto = MotivosDesplazamientoResponseDto
        .builder()
        .items(new ArrayList<>())
        .build();
    final CompletableFuture<MotivosDesplazamientoResponseDto> cfMeta4 = new CompletableFuture<>();
    cfMeta4.complete(responseDto);

    when(this.comisAsyncService.findMotivoDesplazamiento(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cfComis);
    when(this.meta4IcmWsCalcIncomeService.getMotivosDesplazamiento(any(MotivosDesplazamientoRequestDto.class)))
        .thenReturn(cfMeta4);

    this.runTareaAmbitoValidarMotivosDesplazamientoServiceImpl.execute(runTareaDto, tareaAmbitoDto,
        tareaFaseAccionDto);

    verify(this.comisAsyncService, timeout(1000).times(1))
        .findMotivoDesplazamiento(
            ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class));
    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getMotivosDesplazamiento(ArgumentMatchers.any(MotivosDesplazamientoRequestDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .createTempMotivoDesplazamientoComis();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .createTempMotivoDesplazamientoMeta4();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .insertTempMotivoDesplazamientoComis(ArgumentMatchers.any(List.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .validateTempMotivoDesplazamiento();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .deleteTempMotivoDesplazamientoComis();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .deleteTempMotivoDesplazamientoMeta4();

  }

}
