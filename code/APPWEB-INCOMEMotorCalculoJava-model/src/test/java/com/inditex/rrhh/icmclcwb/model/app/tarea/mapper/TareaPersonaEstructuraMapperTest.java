package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class TareaPersonaEstructuraMapperTest {

  @InjectMocks
  TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper = this.getClassMock();

  private TareaPersonaEstructuraMapper getClassMock() {
    return Mockito.mock(TareaPersonaEstructuraMapper.class, Mockito.CALLS_REAL_METHODS);
  }

  @Mock
  private TareaPersonaEstructuraDto tareaPersonaEstructuraDto;

  @Mock
  private TareaPersonaEstructura tareaPersonaEstructura;

  @Test
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    final var tareaPersonaEstructuraDtoList = Instancio.createList(TareaPersonaEstructuraDto.class);

    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraMapper
          .simulacionTareaPersonaEstructuraDtoToTareaPersonaEstructuraDto(tareaPersonaEstructuraDtoList);
    });
  }

}
