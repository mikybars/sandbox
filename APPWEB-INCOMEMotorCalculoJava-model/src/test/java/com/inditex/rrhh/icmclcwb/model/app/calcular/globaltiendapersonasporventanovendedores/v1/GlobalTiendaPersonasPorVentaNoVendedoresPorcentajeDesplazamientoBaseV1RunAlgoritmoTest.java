package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendapersonasporventanovendedores.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private static final String SQL_CALCULAR = "SELECT * FROM WHATEVER";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @InjectMocks
  private GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmo globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmo;

  @Test
  void getSqlCalcularTest(@Random final AlgoritmoDTO algoritmo) {
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class)))
            .thenReturn(SQL_CALCULAR);

    final String result = this.globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(algoritmo);

    verify(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom, times(1))
        .getSqlCalcular(algoritmo);

    assertEquals(SQL_CALCULAR, result);
  }

  @Test
  void calcularTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom.ids(
        any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea, personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea, 3);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea, 3);
  }

  @Test
  void calcularExceptionTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom.ids(
        any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    final RuntimeException exception = new RuntimeException("ERROR");
    doThrow(exception)
        .when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom).calcular(
            any(AlgoritmoDTO.class),
            any(TareaDto.class), anyList());

    this.globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea, personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea, 3);
    verify(this.log, times(1)).error("Trabajo[{}]Tarea[{}] :: {} :: KO :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1", idTrabajo, idTarea, 3, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
