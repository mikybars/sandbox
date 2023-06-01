package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaFaseAccionVentaIntegraMapperTest {

  @InjectMocks
  private TareaFaseAccionVentaIntegraMapper tareaFaseAccionVentaIntegraMapper;

  private TareaFaseAccionVentaIntegraMapper getClassMock() {
    return Mockito.mock(TareaFaseAccionVentaIntegraMapper.class, Mockito.CALLS_REAL_METHODS);
  }
}
