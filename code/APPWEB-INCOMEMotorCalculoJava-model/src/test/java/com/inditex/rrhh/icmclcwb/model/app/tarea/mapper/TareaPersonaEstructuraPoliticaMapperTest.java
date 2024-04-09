package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaPersonaEstructuraPoliticaMapperTest {

  @InjectMocks
  private TareaPersonaEstructuraPoliticaMapper tareaPersonaEstructuraPoliticaMapper = getClassMock();

  @Random(type = TareaPersonaEstructuraPoliticaDto.class, size = 2)
  private List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaDtoList;

  @Random(type = TareaPersonaEstructuraPolitica.class, size = 2)
  private List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaList;

  @Random(type = ComisionEmpleadoResultItemDto.class, size = 2)
  private List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDtoList;

  @Random
  private TareaDto tarea;

  @Random(type = EstructurasPolResultItemDto.class, size = 2)
  List<EstructurasPolResultItemDto> estructurasPolResultItemDtoList;

  @Random
  EstructurasPolResultItemDto estructurasPolResultItemDto;

  @Random
  ListaCondicionesPoliticasResultItemDto condiciones;

  @Random
  ListaValoresPoliticasResultItemDto valores;

  private TareaPersonaEstructuraPoliticaMapper getClassMock() {
    return Mockito.mock(TareaPersonaEstructuraPoliticaMapper.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(this.tareaPersonaEstructuraPoliticaDtoList);
    });
  }

  @Test
  void tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDtoExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(this.tareaPersonaEstructuraPoliticaList);
    });
  }

  @Test
  void comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(this.comisionEmpleadoResultItemDtoList, this.tarea);
    });
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(this.estructurasPolResultItemDtoList, this.tarea);
    });
  }

  @Test
  void estructurasPolResultItemDtoToTareaPersonaEstructuraPoliticaExceptionTest2() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaPersonaEstructuraPoliticaMapper
          .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(this.estructurasPolResultItemDto, this.condiciones, this.valores,
              this.tarea);
    });
  }

}
