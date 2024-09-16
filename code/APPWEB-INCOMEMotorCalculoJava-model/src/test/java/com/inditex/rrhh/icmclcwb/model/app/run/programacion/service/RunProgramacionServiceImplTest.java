package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.programacion.async.service.ProgramacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.RunProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.ms.app.programacion.SenderProgramacion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunProgramacionServiceImplTest {

  @Mock
  private ProgramacionService programacionService;

  @Mock
  private ProgramacionAsyncService programacionAsyncService;

  @Mock
  private PeriodoMapper periodoMapper;

  @Mock
  private TrabajoService trabajoService;

  @Mock
  private SenderProgramacion senderProgramacion;

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @InjectMocks
  private RunProgramacionServiceImpl runProgramacionServiceImpl;

  @Test
  public void runShouldReturnRunProgramacionDTOWhenIdIsValid() {
    final Long id = 1L;
    final ProgramacionDTO programacionDTO = new ProgramacionDTO();
    when(this.programacionService.findActivoById(id)).thenReturn(programacionDTO);

    final RunProgramacionDTO result = this.runProgramacionServiceImpl.run(id);

    assertNotNull(result);
    Assertions.assertEquals(programacionDTO, result.getProgramacion());
  }

  @Test
  public void createShouldReturnListOfRunProgramacionDTOWhenThereArePendientes() {
    final List<ProgramacionDTO> pendientes = new ArrayList<>();
    pendientes.add(new ProgramacionDTO());
    when(this.programacionService.findPendiente()).thenReturn(pendientes);
    final CompletableFuture<Void> cfCalc = new CompletableFuture<Void>();
    cfCalc.complete(null);

    when(this.programacionAsyncService.updateFechaSiguienteEjecucion(ArgumentMatchers.any(List.class)))
        .thenReturn(cfCalc);

    final List<RunProgramacionDTO> result = this.runProgramacionServiceImpl.create();

    assertNotNull(result);
    Assertions.assertFalse(result.isEmpty());
  }
}
