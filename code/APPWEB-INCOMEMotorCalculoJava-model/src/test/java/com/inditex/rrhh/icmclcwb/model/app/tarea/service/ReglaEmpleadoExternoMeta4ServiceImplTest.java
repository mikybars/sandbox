package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.ReglaEmpleadoExternoMeta4RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class ReglaEmpleadoExternoMeta4ServiceImplTest {

  @Mock
  private ReglaEmpleadoExternoMeta4RepositoryCustom reglaEmpleadoExternoMeta4RepositoryCustom;

  @Mock
  private ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper;

  @InjectMocks
  private ReglaEmpleadoExternoMeta4ServiceImpl reglaEmpleadoExternoMeta4Service;

  @Test
  public void getReglasEmpleadoExternoMeta4ActivasByCclIdOrigenTest(
      @Random(size = 2, type = ReglaEmpleadoExternoMeta4Dto.class) final List<ReglaEmpleadoExternoMeta4Dto> reglas,
      @Random final ReglaEmpleadoExternoMeta4RequestDto reglaEmpleadoExternoMeta4RequestDto) {
    doReturn(reglas).when(this.reglaEmpleadoExternoMeta4RepositoryCustom).findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen("1", "8");
    doReturn(reglaEmpleadoExternoMeta4RequestDto).when(this.reglaEmpleadoExternoMeta4Mapper)
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);

    final ReglaEmpleadoExternoMeta4RequestDto result =
        this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen("1", "8");

    verify(this.reglaEmpleadoExternoMeta4RepositoryCustom, times(1))
        .findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen("1", "8");
    verify(this.reglaEmpleadoExternoMeta4Mapper, times(1))
        .reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);
    assertEquals(reglaEmpleadoExternoMeta4RequestDto, result);
  }

}
