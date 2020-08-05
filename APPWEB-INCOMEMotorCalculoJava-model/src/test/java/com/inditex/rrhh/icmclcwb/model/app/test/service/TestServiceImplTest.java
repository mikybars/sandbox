package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.inditex.aqsw.framework.service.aaa.userdetails.sso.model.UserSSO;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        this.testServiceImpl.reloj();
        assertNotNull(this.testServiceImpl.reloj());
    }

    @Test
    public void sso() {
        final UserSSO applicationUser = Mockito.mock(UserSSO.class);
        final Authentication authentication = Mockito.mock(Authentication.class);
        final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        this.testServiceImpl.sso();
        assertNotNull(this.testServiceImpl.sso().getResult());
    }

    @Test
    public void errorSync() {
        this.testServiceImpl.errorSync();
        verify(this.testExceptionService, timeout(1000).times(1)).icmclcwbException();
    }

    @Test
    public void errorAsync() {
        final CompletableFuture<Void> cfNull = CompletableFuture.supplyAsync(() -> {
            return null;
        });

        when(this.testExceptionAsyncService.icmclcwbException()).thenReturn(cfNull);
        this.testServiceImpl.errorAsync();
        verify(this.testExceptionAsyncService, timeout(1000).times(2)).icmclcwbException();
    }

    @Test
    public void sesion() {
        final GetempleadosOutput outputEmpleados = new GetempleadosOutput();
        final SearchtiendasOutput outputTiendas = new SearchtiendasOutput();
        outputEmpleados.setReturn(0.0);
        outputTiendas.setReturn(0.0);
        when(this.meta4ClientPool.getempleados(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class))).thenReturn(outputEmpleados);
        when(this.meta4ClientPool.searchtiendas(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class))).thenReturn(outputTiendas);
        this.testServiceImpl.sesion();
        verify(this.meta4ClientPool, timeout(1000).times(3)).getempleados(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class));
        verify(this.meta4ClientPool, timeout(1000).times(3)).searchtiendas(any(IcmParametrosentradaBlock.class),
                any(IcmParametrospaginacionBlock.class));
    }

    @Test
    // TODO [COMUN] Rehacer este test
    public void programacionBatch() {
        this.testServiceImpl.programacionBatch();
        verify(this.programacionService, timeout(1000).times(1)).activa();
        verify(this.programacionService, timeout(1000).times(100)).reset();
        // verify(runProgramacionService, timeout(1000).times(100)).run();
    }

    @Test
    public void testUrl() throws IOException {
        assertFalse(this.testServiceImpl.testUrl("testUrl"));
        assertTrue(this.testServiceImpl.testUrl("http://www.test.com"));

    }

    @Test
    public void testBloqueos() {
        this.testServiceImpl.testBloqueos(2L);
        verify(this.trabajoService, timeout(1000).times(2)).create(any(TrabajoDto.class));
    }

    @Test
    public void sqlFormatter() {
        this.testServiceImpl.sqlFormatter("test");
        assertNotNull(this.testServiceImpl.sqlFormatter("test"));
    }

}
