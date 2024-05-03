package com.inditex.rrhh.icmclcwb.model.app.programacion.async.service;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgamacionAsyncServiceImplTest {
  @Mock
  private ProgramacionService programacionService;

  @InjectMocks
  private ProgamacionAsyncServiceImpl progamacionAsyncService;

  @Test
  void updateFechaSiguienteEjecucionTest() {
    final List<ProgramacionDTO> result = new ArrayList<>();
    this.progamacionAsyncService.updateFechaSiguienteEjecucion(result);

    verify(this.programacionService, times(1)).updateFechaSiguienteEjecucion(anyList());
  }
}
