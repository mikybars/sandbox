package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class ReglaEmpleadoExternoMeta4MapperDecoratorTest {

  @InjectMocks
  private ReglaEmpleadoExternoMeta4MapperDecorator reglaEmpleadoExternoMeta4MapperDecorator = this.getClassMock();

  private ReglaEmpleadoExternoMeta4MapperDecorator getClassMock() {
    return Mockito.mock(ReglaEmpleadoExternoMeta4MapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoTest(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    final List<ReglaEmpleadoExternoMeta4RequestDto> result = this.reglaEmpleadoExternoMeta4MapperDecorator
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoList(reglas);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoNullTest() {

    final List<ReglaEmpleadoExternoMeta4Dto> reglas = Instancio.ofList(ReglaEmpleadoExternoMeta4Dto.class).size(0).create();

    final List<ReglaEmpleadoExternoMeta4RequestDto> result = this.reglaEmpleadoExternoMeta4MapperDecorator
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoList(reglas);

    assertNull(result);
  }

}
