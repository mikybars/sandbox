package com.inditex.rrhh.icmclcwb.model.app.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUser;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.dto.AjusteComisionDTO;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TestServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private TrabajoService trabajoService;

  @Mock
  private TestExceptionService testExceptionService;

  @Mock
  private TestExceptionAsyncService testExceptionAsyncService;

  @Mock
  private ProgramacionService programacionService;

  @Mock
  private RunProgramacionService runProgramacionService;

  @Mock
  private Meta4ClientPool meta4ClientPool;

  @Mock
  private HttpURLConnection connection;

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Mock
  private TareaRepositoryCustom tareaRepositoryCustom;

  @Mock
  private TestNormalizacionAsyncService testNormalizacionAsyncService;

  // Fin de normalización de tareas consolidadas (para borrar)

  @Mock
  @Qualifier("slrhorcomsProperties")
  private Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

  @Mock
  @Qualifier("slrhorcomsClient")
  private RestClient slrhorcomsClient;

  @InjectMocks
  private TestServiceImpl testServiceImpl;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void reloj() {
    this.testServiceImpl.reloj();
    assertNotNull(this.testServiceImpl.reloj());
  }

  @Disabled
  // TODO: Revisar
  @Test
  void sso() {
    final HeimdalUser applicationUser = Mockito.mock(HeimdalUser.class);
    final Authentication authentication = Mockito.mock(Authentication.class);
    final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
    when(securityContext.getAuthentication()).thenReturn(authentication);
    SecurityContextHolder.setContext(securityContext);
    when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

    this.testServiceImpl.sso();
    assertNotNull(this.testServiceImpl.sso().getResult());
  }

  @Test
  void errorSync() {
    this.testServiceImpl.errorSync();
    verify(this.testExceptionService, timeout(1000).times(1)).icmclcwbException();
  }

  @Test
  void errorAsync() {
    final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
      return null;
    });

    when(this.testExceptionAsyncService.icmclcwbException()).thenReturn(cfNull);
    this.testServiceImpl.errorAsync();
    verify(this.testExceptionAsyncService, timeout(1000).times(2)).icmclcwbException();
  }

  @Test
  void sesion() {
    final GetempleadosOutput outputEmpleados = new GetempleadosOutput();
    final SearchtiendasOutput outputTiendas = new SearchtiendasOutput();
    outputEmpleados.setReturn(0.0);
    outputTiendas.setReturn(0.0);
    when(this.meta4ClientPool.getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(outputEmpleados);
    when(this.meta4ClientPool.searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(outputTiendas);
    this.testServiceImpl.sesion();
    verify(this.meta4ClientPool, timeout(1000).times(3)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
    verify(this.meta4ClientPool, timeout(1000).times(3)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  // TODO [COMUN] Rehacer este test
  void programacionBatch() {
    this.testServiceImpl.programacionBatch();
    verify(this.programacionService, timeout(1000).times(1)).activa();
    verify(this.programacionService, timeout(1000).times(100)).reset();
    // verify(runProgramacionService, timeout(1000).times(100)).run();
  }

  @Test
  // TODO: Revisar esto
  void testUrl() throws IOException {
    assertTrue(this.testServiceImpl.testUrl("http://www.test.com"));
  }

  @Test
  void testBloqueos() {
    this.testServiceImpl.testBloqueos(2L);
    verify(this.trabajoService, timeout(1000).times(2)).create(any(TrabajoDTO.class));
  }

  @Test
  void sqlFormatter() {
    this.testServiceImpl.sqlFormatter("test");
    assertNotNull(this.testServiceImpl.sqlFormatter("test"));
  }

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Test
  void testServiceNormalizarAjusteComisionTareasProcesadasLimitMayorQueTareasAProcesarTest() {

    final int limit = 10;
    final IdTareaDTO id1 = new IdTareaDTO();
    id1.setId(123L);
    final IdTareaDTO id2 = new IdTareaDTO();
    id2.setId(124L);
    when(this.tareaRepositoryCustom.findTareasConsolidadesSinAjusteComision(any(Integer.class)))
        .thenReturn(Arrays.asList(id1, id2));
    when(this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision()).thenReturn(100);
    when(this.testNormalizacionAsyncService.normalizarAjusteComision(ArgumentMatchers.any()))
        .thenReturn(CompletableFuture.completedFuture(AsyncConstants.NIL));

    final AjusteComisionDTO result = this.testServiceImpl.normalizarAjusteComision(limit);

    assertNotNull(result);
    assertEquals(2, result.getTareasProcesadas());
  }

  @Test
  void testServiceNormalizarAjusteIdTareasTest() {

    final IdTareaDTO id1 = new IdTareaDTO();
    id1.setId(123L);
    final IdTareaDTO id2 = new IdTareaDTO();
    id2.setId(124L);
    when(this.tareaRepositoryCustom.findTareasConsolidadesSinAjusteComision(any(Integer.class)))
        .thenReturn(Arrays.asList(id1, id2));
    when(this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision()).thenReturn(100);
    when(this.testNormalizacionAsyncService.normalizarAjusteComision(ArgumentMatchers.any()))
        .thenReturn(CompletableFuture.completedFuture(AsyncConstants.NIL));

    final AjusteComisionDTO result = this.testServiceImpl.normalizarAjusteComision(2);
    assertNotNull(result);
    assertEquals(Arrays.asList(id1, id2), result.getIdTarea());
  }

  @Test
  void testServiceNormalizarAjusteTareasPendientesTest() {

    final IdTareaDTO id1 = new IdTareaDTO();
    id1.setId(123L);
    final IdTareaDTO id2 = new IdTareaDTO();
    id2.setId(124L);
    when(this.tareaRepositoryCustom.findTareasConsolidadesSinAjusteComision(any(Integer.class)))
        .thenReturn(Arrays.asList(id1, id2));
    when(this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision()).thenReturn(100);
    when(this.testNormalizacionAsyncService.normalizarAjusteComision(ArgumentMatchers.any()))
        .thenReturn(CompletableFuture.completedFuture(AsyncConstants.NIL));

    final AjusteComisionDTO result = this.testServiceImpl.normalizarAjusteComision(2);
    assertNotNull(result);
    // 100 (total) - 2 (tareas que se procesan) = 98
    assertEquals(98, result.getTareasPendientes());
  }

  @Test
  void testServiceNormalizarAjusteNormalizarTest() {

    final IdTareaDTO id1 = new IdTareaDTO();
    id1.setId(123L);
    final IdTareaDTO id2 = new IdTareaDTO();
    id2.setId(124L);
    when(this.tareaRepositoryCustom.findTareasConsolidadesSinAjusteComision(any(Integer.class)))
        .thenReturn(Arrays.asList(id1, id2));
    when(this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision()).thenReturn(100);
    when(this.testNormalizacionAsyncService.normalizarAjusteComision(ArgumentMatchers.any()))
        .thenReturn(CompletableFuture.completedFuture(AsyncConstants.NIL));

    final AjusteComisionDTO result = this.testServiceImpl.normalizarAjusteComision(200);

    verify(this.testNormalizacionAsyncService, times(1)).normalizarAjusteComision(Arrays.asList(id1, id2));

  }

  // Fin de normalización de tareas consolidadas (para borrar)

  @Test
  void testSlrhorcomsTest() {

    final SlrhorcomsPropertiesDto slrhorcoms = new SlrhorcomsPropertiesDto();
    slrhorcoms.setEndpoint("/HorarioComercialFestivos/list");

    when(this.slrhorcomsProperties.get("festivos")).thenReturn(slrhorcoms);
    when(this.slrhorcomsClient.getForEntity("/HorarioComercialFestivos/list?q=*",
        HorarioComercialFestivoDocDto[].class))
            .thenReturn(mock(ResponseEntity.class));

    this.testServiceImpl.slrhorcomsTest();
  }

}
