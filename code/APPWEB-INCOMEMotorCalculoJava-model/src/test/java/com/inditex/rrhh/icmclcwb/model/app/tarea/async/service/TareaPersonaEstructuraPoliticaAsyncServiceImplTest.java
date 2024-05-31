package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaPersonaEstructuraPoliticaAsyncServiceImplTest {
  @Mock
  private TareaPersonaEstructuraPoliticaService tareaPersonaEstructuraPoliticaService;

  @InjectMocks
  private TareaPersonaEstructuraPoliticaAsyncServiceImpl tareaPersonaEstructuraPoliticaAsyncService;

  @Test
  void saveTest() {
    final List<ComisionEmpleadoResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaPersonaEstructuraPoliticaAsyncService.save(src, tarea);

    verify(this.tareaPersonaEstructuraPoliticaService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void saveEstructurasPolResultItemDtoTest() {
    final List<EstructurasPolResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaPersonaEstructuraPoliticaAsyncService.saveEstructurasPolResultItemDto(src, tarea);

    verify(this.tareaPersonaEstructuraPoliticaService).saveEstructurasPolResultItemDto(anyList(), any(TareaDto.class));
  }
}
