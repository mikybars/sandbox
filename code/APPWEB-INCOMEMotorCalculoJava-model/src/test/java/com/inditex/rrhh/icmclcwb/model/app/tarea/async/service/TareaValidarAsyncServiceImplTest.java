package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaValidarAsyncServiceImplTest {
  @Mock
  private TareaValidarService tareaValidarService;

  @InjectMocks
  private TareaValidarAsyncServiceImpl tareaValidarAsyncService;

  @Test
  void checkDuplicatedTiendasHistoricoTest() {
    this.tareaValidarAsyncService.checkDuplicatedTiendasHistorico(2L);

    verify(this.tareaValidarService).checkDuplicatedTiendasHistorico(anyLong());
  }

  @Test
  void checkDuplicatedTiposHoraTest() {
    this.tareaValidarAsyncService.checkDuplicatedTiposHora(2L);

    verify(this.tareaValidarService).checkDuplicatedTiposHora(anyLong());
  }

  @Test
  void countEmpleadosHistoricoTest() {
    this.tareaValidarAsyncService.countEmpleadosHistorico(2L);

    verify(this.tareaValidarService).countEmpleadosHistorico(anyLong());
  }

  @Test
  void countTiendasHistoricoTest() {
    this.tareaValidarAsyncService.countTiendasHistorico(2L);

    verify(this.tareaValidarService).countTiendasHistorico(anyLong());
  }

  @Test
  void countEstructurasTest() {
    this.tareaValidarAsyncService.countEstructuras(2L);

    verify(this.tareaValidarService).countEstructuras(anyLong());
  }

  @Test
  void countTiendaPresenciaSeccionTest() {
    this.tareaValidarAsyncService.countTiendaPresenciaSeccion(2L);

    verify(this.tareaValidarService).countTiendaPresenciaSeccion(anyLong());
  }

  @Test
  void countLocalizacionPersonaPresenciaTest() {
    this.tareaValidarAsyncService.countLocalizacionPersonaPresencia(2L);

    verify(this.tareaValidarService).countTiendaEmpleadoPresenciaSeccion(anyLong());
  }

  @Test
  void countLocalizacionVentaTest() {
    this.tareaValidarAsyncService.countLocalizacionVenta(2L);

    verify(this.tareaValidarService).countTiendaVentaSeccion(anyLong());
  }

  @Test
  void validateAmbitoTest() {
    this.tareaValidarAsyncService.validateAmbito(2L);

    verify(this.tareaValidarService).validateAmbito(anyLong());
  }
}
