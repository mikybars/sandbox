package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import com.inditex.amigafwk.test.randomizer.RandomizerExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class ReglaEmpleadoExternoMeta4MapperTest {

  @InjectMocks
  ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper = this.getClassMock();

  private ReglaEmpleadoExternoMeta4Mapper getClassMock() {
    return Mockito.mock(ReglaEmpleadoExternoMeta4Mapper.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.reglaEmpleadoExternoMeta4Mapper
          .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(any());
    });
  }
}
