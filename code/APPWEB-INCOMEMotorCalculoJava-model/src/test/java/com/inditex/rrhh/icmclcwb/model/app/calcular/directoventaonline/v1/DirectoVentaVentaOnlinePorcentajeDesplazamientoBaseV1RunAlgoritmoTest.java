package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventaonline.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @InjectMocks
  private DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo directoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo;

  @Test
  void getSqlCalcularTest(@Random final AlgoritmoDTO algoritmo) {
    when(
        this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom
            .getSqlCalcular(any(AlgoritmoDTO.class)))
                .thenReturn(SQL_CALCULAR);

    final String result = this.directoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(algoritmo);

    verify(this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom, times(1))
        .getSqlCalcular(algoritmo);

    assertEquals(SQL_CALCULAR, result);
  }

  @Test
  void calcularTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.directoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo");
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", personas);
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3);
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3);
  }

  @Test
  void calcularExceptionTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    final RuntimeException exception = new RuntimeException("ERROR");
    doThrow(exception).when(this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom).calcular(
        any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList());

    this.directoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo");
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", personas);
    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3);
    verify(this.log, times(1)).error(
        "Trabajo[{}]Tarea[{}] :: {} :: KO :: Personas: {}",
        idTrabajo, idTarea, "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
