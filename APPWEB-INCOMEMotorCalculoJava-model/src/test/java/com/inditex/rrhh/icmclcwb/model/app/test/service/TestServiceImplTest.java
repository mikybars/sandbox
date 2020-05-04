package com.inditex.rrhh.icmclcwb.model.app.test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceImplTest {

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

    @InjectMocks
    private TestServiceImpl testServiceImpl;

    @Test
    public void reloj() {
        testServiceImpl.reloj();
        assertNotNull(testServiceImpl.reloj());
    }

    @Test
    public void sso() {
        UserSSO applicationUser = Mockito.mock(UserSSO.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        testServiceImpl.sso();
        assertNotNull(testServiceImpl.sso().getResult());
    }

    @Test
    public void errorSync() {
        testServiceImpl.errorSync();
        verify(testExceptionService, timeout(1000).times(1)).icmclcwbException();
    }

    @Test
    public void errorAsync() {
        CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(testExceptionAsyncService.icmclcwbException()).thenReturn(cfNull);
        testServiceImpl.errorAsync();
        verify(testExceptionAsyncService, timeout(1000).times(2)).icmclcwbException();
    }

    @Test
    public void sesion() {
        GetempleadosOutput outputEmpleados = new GetempleadosOutput();
        SearchtiendasOutput outputTiendas = new SearchtiendasOutput();
        outputEmpleados.setReturn(0.0);
        outputTiendas.setReturn(0.0);
        when(meta4ClientPool.getempleados(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class))).thenReturn(outputEmpleados);
        when(meta4ClientPool.searchtiendas(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class))).thenReturn(outputTiendas);
        testServiceImpl.sesion();
        verify(meta4ClientPool, timeout(1000).times(3)).getempleados(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class));
        verify(meta4ClientPool, timeout(1000).times(3)).searchtiendas(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class));
    }

    @Test
    // TODO [COMUN] Rehacer este test
    public void programacionBatch() {
        testServiceImpl.programacionBatch();
        verify(programacionService, timeout(1000).times(1)).activa();
        verify(programacionService, timeout(1000).times(100)).reset();
        // verify(runProgramacionService, timeout(1000).times(100)).run();
    }

    @Test
    public void testUrl() throws IOException {
        assertFalse(testServiceImpl.testUrl("testUrl"));
        assertTrue(testServiceImpl.testUrl("http://www.test.com"));

    }

    @Test
    public void testBloqueos() {
        testServiceImpl.testBloqueos(2L);
        verify(trabajoService, timeout(1000).times(2)).create(any(TrabajoDto.class));
    }

    @Test
    public void sqlFormatter() {
        testServiceImpl.sqlFormatter("test");
        assertNotNull(testServiceImpl.sqlFormatter("test"));
    }

}
