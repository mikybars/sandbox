package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.MailAmbitoRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class MailAmbitoServiceImplTest {

  @Mock
  private MailAmbitoRepositoryCustomImpl mailAmbitoRepositoryCustom;

  @InjectMocks
  private MailAmbitoServiceImpl mailAmbitoService;

  @Test
  void getMailByOrigenEmpresaTest(@Random(size = 4, type = MailAmbitoDto.class) final List<MailAmbitoDto> mailAmbitos) {

    final String cclIdOrigen = "60";
    final String stdIdLegEnt = "179";

    doReturn(mailAmbitos).when(this.mailAmbitoRepositoryCustom)
        .findMailByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    final List<String> expectedResult = mailAmbitos.stream().map(x -> x.getMail()).collect(Collectors.toList());

    final List<String> result = this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    verify(this.mailAmbitoRepositoryCustom, times(1))
        .findMailByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
    assertEquals(expectedResult, result);

  }

}
