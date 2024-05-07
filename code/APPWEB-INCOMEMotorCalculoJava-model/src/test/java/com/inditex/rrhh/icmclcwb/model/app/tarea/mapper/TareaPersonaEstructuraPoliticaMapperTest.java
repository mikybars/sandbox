package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaPersonaEstructuraPoliticaMapperTest {

  @InjectMocks
  private TareaPersonaEstructuraPoliticaMapper tareaPersonaEstructuraPoliticaMapper = this.getClassMock();

  private TareaPersonaEstructuraPoliticaMapper getClassMock() {
    return Mockito.mock(TareaPersonaEstructuraPoliticaMapper.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    final var tareaPersonaEstructuraPoliticaDtoList = Instancio.createList(TareaPersonaEstructuraPoliticaDto.class);

    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(tareaPersonaEstructuraPoliticaDtoList);
    });
  }

  @Test
  void tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDtoExceptionTest() {
    final var tareaPersonaEstructuraPoliticaList = Instancio.createList(TareaPersonaEstructuraPolitica.class);

    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(tareaPersonaEstructuraPoliticaList);
    });
  }

  @Test
  void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    final var comisionEmpleadoResultItemDtoList = Instancio.createList(ComisionEmpleadoResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);

    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(comisionEmpleadoResultItemDtoList, tarea);
    });
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    final var estructurasPolResultItemDtoList = Instancio.createList(EstructurasPolResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(estructurasPolResultItemDtoList, tarea);
    });
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaExceptionTest2() {
    final var estructurasPolResultItemDto = Instancio.create(EstructurasPolResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    final var valores = Instancio.create(ListaValoresPoliticasResultItemDto.class);
    final var condiciones = Instancio.create(ListaCondicionesPoliticasResultItemDto.class);

    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(estructurasPolResultItemDto, condiciones, valores,
              tarea);
    });
  }

}
