
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoValidarCondicionesDesplazamientoEsServiceImplTest {

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private RunTareaAmbitoValidarCondicionesDesplazamientoEsServiceImpl runTareaAmbitoValidarCondicionesDesplazamientoEsServiceImpl;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private PrevalidarPropertiesDto bajaProperties;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Test
  void execute() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);

    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = new CompletableFuture<>();
    cf.complete(new ArrayList<>());

    when(this.comisAsyncService.findCondicionesDesplazamientoEs(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoValidarCondicionesDesplazamientoEsServiceImpl.execute(runTareaDto, new TareaAmbitoDto(),
        new TareaFaseAccionDto());

    verify(this.comisAsyncService, timeout(1000).times(1))
        .findCondicionesDesplazamientoEs(
            ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .createTempComisDesplazamiento();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .insertTempComisDesplazamiento(ArgumentMatchers.any(List.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .validateTempComisDesplazamiento(ArgumentMatchers.any(TareaDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .desactivaFechasSolapadas();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .reactivaFechasSolapadas(ArgumentMatchers.any(TareaDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .deleteTempComisDesplazamiento();
    verify(this.validacionMapper, timeout(1000).times(1))
        .idPersonaLocalDtoTovalidacionDto(ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class), ArgumentMatchers.any(List.class),
            ArgumentMatchers.any(PrevalidarPropertiesDto.class), ArgumentMatchers.any(TareaDto.class));
  }

}
