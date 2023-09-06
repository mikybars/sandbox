package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaCoeficienteMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaCoeficienteRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaPersonaCoeficienteServiceImplTest {

  @Mock
  private TareaPersonaCoeficienteRepositoryCustom tareaPersonaCoeficienteRepositoryCustom;

  @InjectMocks
  private TareaPersonaCoeficienteServiceImpl tareaPersonaCoeficienteServiceImpl;

  @Mock
  private TareaPersonaCoeficienteMapper tareaPersonaCoeficienteMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<GenericEmpleadoResultItemDto> empleados = new ArrayList<>();

    this.tareaPersonaCoeficienteServiceImpl.save(empleados, tarea);
    verify(this.tareaPersonaCoeficienteRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaPersonaCoeficiente>>any());
  }

}
