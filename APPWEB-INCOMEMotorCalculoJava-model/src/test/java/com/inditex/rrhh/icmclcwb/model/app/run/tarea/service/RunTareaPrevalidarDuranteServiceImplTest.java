/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.mail.MailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class RunTareaPrevalidarDuranteServiceImplTest {

    @Mock
    private LimpiezaService limpiezaService;

    @Mock
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Mock
    private RunPrevalidarFactory runPrevalidarFactory;

    @Mock
    private AccionService accionService;

    @Mock
    private TareaFaseAccionService tareaFaseAccionService;

    @Mock
    private TareaFaseService tareaFaseService;

    @Mock
    private SenderTarea senderTarea;

    @Mock
    private MailSender mailSender;

    @InjectMocks
    private RunTareaPrevalidarDuranteServiceImpl runTareaPrevalidarDuranteServiceImpl;

    @Test
    public void run()
            throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        tareaDto.setId(1L);
        runTareaDto.setTarea(tareaDto);
        final FaseDto faseDto = new FaseDto();
        faseDto.setId(1);
        final AccionDto accionDto = new AccionDto();
        accionDto.setId(1);

        this.runTareaPrevalidarDuranteServiceImpl.run(runTareaDto, faseDto, accionDto);

        verify(this.tareaFaseAccionService, timeout(1000).times(1))
            .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
                    ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class),
                    ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(Integer.class));

        verify(this.tareaFaseService, timeout(1000).times(1))
            .findTareaFaseDtoByIdTareaAndIdFase(
                    ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class));
    }

    @Test
    public void runFasesOK()
            throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        tareaDto.setId(1L);
        runTareaDto.setTarea(tareaDto);
        final FaseDto faseDto = new FaseDto();
        faseDto.setId(1);
        final AccionDto accionDto = new AccionDto();
        accionDto.setId(1);


        final List<TareaFaseAccionDto> tareaFaseAccion = Arrays
            .asList(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(any(Long.class),
                any(Integer.class), any(Integer.class))).thenReturn(tareaFaseAccion);
        when(this.accionService.findAccionDtoById(any(Integer.class)))
            .thenReturn(AccionDto.builder().id(1).nombre("Nombre").peso(100).build());

        final RunPrevalidar service = mock(RunPrevalidar.class);

        final CompletableFuture<List<ValidacionDto>> cfValid = new CompletableFuture<>();
        final ValidacionDto validacion = new ValidacionDto();
        validacion.setResult(Boolean.TRUE);
        validacion.setIdTareaFaseAccion(1L);
        cfValid.complete(Arrays.asList(validacion));

        when(this.runPrevalidarFactory.getRunPrevalidar(any(String.class))).thenReturn(service);
        when(service.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class))).thenReturn(cfValid);
        when(this.tareaFaseAccionService.findById(any(Long.class)))
            .thenReturn(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        try {
            this.runTareaPrevalidarDuranteServiceImpl.run(runTareaDto, faseDto, accionDto);
        } catch (final Exception e) {
            assertThat(e instanceof ValidationException);
        }

    }

    @Test
    public void runFasesKO()
            throws NoSuchFieldException, SecurityException, InterruptedException, ExecutionException {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        tareaDto.setId(1L);
        runTareaDto.setTarea(tareaDto);
        final FaseDto faseDto = new FaseDto();
        faseDto.setId(1);
        final AccionDto accionDto = new AccionDto();
        accionDto.setId(1);

        final List<TareaFaseAccionDto> tareaFaseAccion = Arrays
            .asList(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());

        when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(any(Long.class),
                any(Integer.class), any(Integer.class))).thenReturn(tareaFaseAccion);
        when(this.tareaFaseAccionService.countReintentosByIdTareaAndIdAccionAndIdEstado(any(TareaFaseAccionDto.class),
                any(TareaFaseDto.class))).thenReturn(1);
        when(this.accionService.findAccionDtoById(any(Integer.class)))
            .thenReturn(AccionDto.builder()
                .id(1)
                .nombre("Nombre")
                .esReaccionReintento(Boolean.TRUE)
                .esReaccionEsperar(Boolean.FALSE)
                .reintentoMax(2)
                .peso(100)
                .build());

        final RunPrevalidar service = mock(RunPrevalidar.class);

        final CompletableFuture<List<ValidacionDto>> cfValid = new CompletableFuture<>();
        final ValidacionDto validacion = new ValidacionDto();
        validacion.setResult(Boolean.FALSE);
        validacion.setIdTareaFaseAccion(1L);
        validacion.setSincronizacion(Boolean.TRUE);
        validacion.setIdPersonaLocal(Arrays.asList("111"));
        cfValid.complete(Arrays.asList(validacion));

        when(this.runPrevalidarFactory.getRunPrevalidar(any(String.class))).thenReturn(service);
        when(service.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class))).thenReturn(cfValid);
        when(this.tareaFaseAccionService.findById(any(Long.class)))
            .thenReturn(TareaFaseAccionDto.builder().peso(100).idTareaFase(1L).idAccion(1).build());


        try {
            this.runTareaPrevalidarDuranteServiceImpl.run(runTareaDto, faseDto, accionDto);
        } catch (final Exception e) {
            assertThat(e instanceof ValidationReintentoException);
        }

    }

}
