package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class ReglaEmpleadoExternoMeta4MapperDecoratorTest {

  @InjectMocks
  private ReglaEmpleadoExternoMeta4MapperDecorator reglaEmpleadoExternoMeta4MapperDecorator = this.getClassMock();

  private ReglaEmpleadoExternoMeta4MapperDecorator getClassMock() {
    return Mockito.mock(ReglaEmpleadoExternoMeta4MapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoTest(
      @Random(size = 2, type = ReglaEmpleadoExternoMeta4Dto.class) final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    final ReglaEmpleadoExternoMeta4RequestDto result = this.reglaEmpleadoExternoMeta4MapperDecorator
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);

    assertNotNull(result);
  }

  @Test
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoNullTest(
      @Random(size = 0, type = ReglaEmpleadoExternoMeta4Dto.class) final List<ReglaEmpleadoExternoMeta4Dto> reglas) {

    final ReglaEmpleadoExternoMeta4RequestDto result = this.reglaEmpleadoExternoMeta4MapperDecorator
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);

    assertNull(result);
  }

}
