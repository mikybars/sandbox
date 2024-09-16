package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {
  @Mock
  private Logger log;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private PorVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo porVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo;

  @Test
  void executeTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);

    doReturn(personas).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .ids(any(AlgoritmoDTO.class), any(
            TareaDto.class));
    final CompletableFuture cfCalc = new CompletableFuture<>();
    cfCalc.complete(null);
    doReturn(cfCalc).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(
            TareaDto.class), anyList());
    doReturn(this.createRunAlgoritmoCalculoPropertiesDto(2)).when(this.runAlgoritmoProperties).getCalculo();

    final CompletableFuture<Void> result =
        this.porVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(this.createRunTareaDto(1L, 2L), new AlgoritmoDTO());

    assertNotNull(result);
  }

  @Test
  void executeExceptionTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);

    doReturn(personas).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .ids(any(AlgoritmoDTO.class), any(
            TareaDto.class));
    final CompletableFuture cfCalc = new CompletableFuture<>();
    cfCalc.complete(null);
    doThrow(new RuntimeException()).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(
            TareaDto.class), anyList());
    doReturn(this.createRunAlgoritmoCalculoPropertiesDto(2)).when(this.runAlgoritmoProperties).getCalculo();

    final CompletableFuture<Void> result =
        this.porVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(this.createRunTareaDto(1L, 2L), new AlgoritmoDTO());

    assertNotNull(result);
  }

  @Test
  void getSqlCalcularTest() {
    doReturn("").when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .getSqlCalcular(new AlgoritmoDTO());
    final String result = this.porVentaDevolucionPorcentajeDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDTO());
    assertEquals("", result);
  }
}
