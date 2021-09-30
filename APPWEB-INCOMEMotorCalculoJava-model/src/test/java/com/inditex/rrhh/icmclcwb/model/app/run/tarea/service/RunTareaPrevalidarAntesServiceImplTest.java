/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.concurrent.ExecutionException;

import org.springframework.mail.MailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class RunTareaPrevalidarAntesServiceImplTest {

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
    private RunTareaPrevalidarAntesServiceImpl runTareaPrevalidarAntesServiceImpl;

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

        this.runTareaPrevalidarAntesServiceImpl.run(runTareaDto, faseDto);

        verify(this.tareaFaseAccionService, timeout(1000).times(1))
            .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
                    ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class),
                    ArgumentMatchers.any(Integer.class));

    }

}
