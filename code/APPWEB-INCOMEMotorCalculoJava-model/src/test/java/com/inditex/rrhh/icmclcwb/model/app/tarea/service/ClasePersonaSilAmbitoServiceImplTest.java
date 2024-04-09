package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.ClasePersonaSilAmbitoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class ClasePersonaSilAmbitoServiceImplTest {

  @Mock
  private ClasePersonaSilAmbitoRepositoryCustom clasePersonaSilAmbitoRepositoryCustom;

  @InjectMocks
  private ClasePersonaSilAmbitoServiceImpl clasePersonaSilAmbitoService;

  @Test
  void getClaseAndEstadoByCclIdOrigenAndStdIdLegEntTest(
      @Random(size = 1, type = ClasePersonaSilAmbitoDto.class) final List<ClasePersonaSilAmbitoDto> claseEstados) {

    final String cclIdOrigen = "60";
    final String stdIdLegEnt = "179";

    doReturn(claseEstados).when(this.clasePersonaSilAmbitoRepositoryCustom).findClaseEstadoByCclIdOrigenAndStdIdLegEnt(cclIdOrigen,
        stdIdLegEnt);

    final List<ClasePersonaSilAmbitoDto> result =
        this.clasePersonaSilAmbitoService.getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    verify(this.clasePersonaSilAmbitoRepositoryCustom, times(1))
        .findClaseEstadoByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
    assertEquals(claseEstados, result);

  }

}
