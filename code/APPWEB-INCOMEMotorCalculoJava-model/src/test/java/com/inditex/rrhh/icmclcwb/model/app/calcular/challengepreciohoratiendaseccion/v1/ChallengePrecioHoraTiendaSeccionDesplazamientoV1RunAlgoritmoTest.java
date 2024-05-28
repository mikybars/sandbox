package com.inditex.rrhh.icmclcwb.model.app.calcular.challengepreciohoratiendaseccion.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class ChallengePrecioHoraTiendaSeccionDesplazamientoV1RunAlgoritmoTest implements RunAlgoritmoTest {
  @Mock
  private Logger log;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @InjectMocks
  private ChallengePrecioHoraTiendaSeccionDesplazamientoV1RunAlgoritmo challengePrecioHoraTiendaSeccionDesplazamientoV1RunAlgoritmo;

  private final AlgoritmoDTO algoritmo = new AlgoritmoDTO();

  @BeforeEach
  void initExecuteTest() {

    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);

    doReturn(personas).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom).ids(
        any(AlgoritmoDTO.class),
        any(TareaDto.class));

    doReturn(this.createRunAlgoritmoCalculoPropertiesDto(2)).when(this.runAlgoritmoProperties).getCalculo();

    final CompletableFuture cfCalc = new CompletableFuture<>();
    cfCalc.complete(null);

    doReturn(cfCalc).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList());
  }

  @Test
  void executeTest() {
    final CompletableFuture<Void> result =
        this.challengePrecioHoraTiendaSeccionDesplazamientoV1RunAlgoritmo.execute(this.createRunTareaDto(2L, 3L), this.algoritmo);

    assertNotNull(result);
  }

  @BeforeEach
  void initExecuteExceptionTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);
    doReturn(personas).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom)
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class));

    doReturn(this.createRunAlgoritmoCalculoPropertiesDto(2)).when(this.runAlgoritmoProperties).getCalculo();

    doThrow(new RuntimeException()).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom)
        .calcular(any(
            AlgoritmoDTO.class), any(TareaDto.class), anyList());
  }

  @Test
  void executeExeptionTest() {
    final CompletableFuture<Void> result =
        this.challengePrecioHoraTiendaSeccionDesplazamientoV1RunAlgoritmo.execute(this.createRunTareaDto(2L, 3L), this.algoritmo);
    assertNotNull(result);
  }

  @BeforeEach
  void initGetSqlCalcularTest() {
    doReturn("getSqlCalcular").when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoV1RepositoryCustom)
        .getSqlCalcular(this.algoritmo);
  }

  @Test
  void getSqlCalcularTest() {
    final String result = this.challengePrecioHoraTiendaSeccionDesplazamientoV1RunAlgoritmo.getSqlCalcular(this.algoritmo);
    assertNotNull(result);
    assertEquals("getSqlCalcular", result);
  }
}
