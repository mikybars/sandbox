package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import org.instancio.junit.InstancioSource;
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
  @InstancioSource
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoTest(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    final ReglaEmpleadoExternoMeta4RequestDto result = this.reglaEmpleadoExternoMeta4MapperDecorator
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoNullTest(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    final ReglaEmpleadoExternoMeta4RequestDto result = this.reglaEmpleadoExternoMeta4MapperDecorator
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);

    assertNull(result);
  }

}
