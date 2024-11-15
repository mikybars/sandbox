package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.ReglaEmpleadoExternoMeta4RepositoryCustom;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class ReglaEmpleadoExternoMeta4ServiceImplTest {

  @Mock
  private ReglaEmpleadoExternoMeta4RepositoryCustom reglaEmpleadoExternoMeta4RepositoryCustom;

  @Mock
  private ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper;

  @InjectMocks
  private ReglaEmpleadoExternoMeta4ServiceImpl reglaEmpleadoExternoMeta4Service;

  @ParameterizedTest
  @InstancioSource
  void getReglasEmpleadoExternoMeta4ActivasByCclIdOrigenTest(
      final List<ReglaEmpleadoExternoMeta4Dto> reglas,
      final List<ReglaEmpleadoExternoMeta4RequestDto> reglaEmpleadoExternoMeta4RequestDto) {
    doReturn(reglas).when(this.reglaEmpleadoExternoMeta4RepositoryCustom).findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen("1", "8");
    doReturn(reglaEmpleadoExternoMeta4RequestDto).when(this.reglaEmpleadoExternoMeta4Mapper)
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoList(reglas);

    final List<ReglaEmpleadoExternoMeta4RequestDto> result =
        this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen("1", "8");

    verify(this.reglaEmpleadoExternoMeta4RepositoryCustom, times(1))
        .findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen("1", "8");
    verify(this.reglaEmpleadoExternoMeta4Mapper, times(1))
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDtoList(reglas);
    assertEquals(reglaEmpleadoExternoMeta4RequestDto, result);
  }

}
