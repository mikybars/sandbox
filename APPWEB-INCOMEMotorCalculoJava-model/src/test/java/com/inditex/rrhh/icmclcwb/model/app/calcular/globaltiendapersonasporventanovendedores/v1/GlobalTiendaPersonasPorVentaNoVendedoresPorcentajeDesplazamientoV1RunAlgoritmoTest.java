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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private static final String SQL_CALCULAR = "SELECT * FROM WHATEVER";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom;

  @InjectMocks
  private GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo;

  @Test
  void getSqlCalcularTest(@Random final AlgoritmoDTO algoritmo) {
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class)))
            .thenReturn(SQL_CALCULAR);

    final String result = this.globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo.getSqlCalcular(algoritmo);

    verify(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom, times(1))
        .getSqlCalcular(algoritmo);

    assertEquals(SQL_CALCULAR, result);
  }

  @Test
  void calcularTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom.ids(
        any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea, personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea, 3);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea, 3);
  }

  @Test
  void calcularExceptionTest(@Random final AlgoritmoDTO algoritmo, @Random final RunTareaDto runTarea,
      @Random(size = 3, type = IdPersonaLocalDto.class) final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom.ids(
        any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    final RuntimeException exception = new RuntimeException("ERROR");
    doThrow(exception).when(this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom)
        .calcular(
            any(AlgoritmoDTO.class),
            any(TareaDto.class), anyList());

    this.globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea, personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea, 3);
    verify(this.log, times(1)).error("Trabajo[{}]Tarea[{}] :: {} :: KO :: Personas: {}",
        "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo", idTrabajo, idTarea, 3, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
