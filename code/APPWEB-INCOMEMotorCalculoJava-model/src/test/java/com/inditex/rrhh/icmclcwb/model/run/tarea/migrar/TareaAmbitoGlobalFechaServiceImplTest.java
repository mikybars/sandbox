package com.inditex.rrhh.icmclcwb.model.run.tarea.migrar;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalFechaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaAmbitoGlobalFechaServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalFechaRepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TareaAmbitoGlobalFechaServiceImplTest {

  @Mock
  private TareaAmbitoGlobalFechaRepositoryCustom tareaAmbitoGlobalFechaRepositoryCustom;

  @Mock
  private TareaAmbitoGlobalFechaMapper tareaAmbitoGlobalFechaMapper;

  @InjectMocks
  private TareaAmbitoGlobalFechaServiceImpl tareaAmbitoGlobalFechaService;

  private TareaAmbitoGlobalFechaDto tareaAmbitoGlobalFechaDto;

  private TareaDto tareaDto;

  private PeriodoDto periodoDto;

  @BeforeEach
  void setUp() {
    this.tareaAmbitoGlobalFechaDto = new TareaAmbitoGlobalFechaDto();
    this.tareaDto = new TareaDto();
    this.periodoDto = new PeriodoDto();
  }

  @Test
  void findFechaAmbitoDtoByIdTareaAndIdTipoDatoTest() {
    final Long idTarea = 1L;
    final Integer idTipoDato = 1;

    when(this.tareaAmbitoGlobalFechaRepositoryCustom.findFechaAmbitoDtoByIdTareaAndIdTipoDato(idTarea, idTipoDato))
        .thenReturn(this.periodoDto);

    final PeriodoDto result = this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(idTarea, idTipoDato);

    verify(this.tareaAmbitoGlobalFechaRepositoryCustom).findFechaAmbitoDtoByIdTareaAndIdTipoDato(idTarea, idTipoDato);
  }
}
