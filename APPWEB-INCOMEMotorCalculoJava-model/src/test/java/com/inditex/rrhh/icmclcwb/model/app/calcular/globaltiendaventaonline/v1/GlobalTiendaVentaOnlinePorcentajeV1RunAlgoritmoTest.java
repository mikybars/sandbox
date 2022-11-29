package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaventaonline.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private static final String SQL_CALCULAR = "SELECT * FROM WHATEVER";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom;

  @InjectMocks
  private GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo globalTiendaVentaOnlinePorcentajeV1RunAlgoritmo;

  @Test
  void getSqlCalcularTest(@Random final AlgoritmoDTO algoritmo) {
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom.getSqlCalcular(any(AlgoritmoDTO.class)))
        .thenReturn(SQL_CALCULAR);

    final String result = this.globalTiendaVentaOnlinePorcentajeV1RunAlgoritmo.getSqlCalcular(algoritmo);

    verify(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom, times(1)).getSqlCalcular(algoritmo);

    assertEquals(SQL_CALCULAR, result);
  }

  @Test
  void calcularTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
        .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.globalTiendaVentaOnlinePorcentajeV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo");
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo", personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo", 3);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo", 3);
  }

  @Test
  void calcularExceptionTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
        .thenReturn(personas);
    final RuntimeException exception = new RuntimeException("ERROR");
    doThrow(exception).when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom).calcular(any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList());

    this.globalTiendaVentaOnlinePorcentajeV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo");
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo", personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo", 3);
    verify(this.log, times(1)).error("Trabajo[{}]Tarea[{}] :: {} :: KO :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo", 3, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
