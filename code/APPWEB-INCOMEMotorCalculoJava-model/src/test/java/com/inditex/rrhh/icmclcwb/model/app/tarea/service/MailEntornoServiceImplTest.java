package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailEntornoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.MailEntornoRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class MailEntornoServiceImplTest {

  @Mock
  private MailEntornoRepositoryCustomImpl mailEntornoRepositoryCustom;

  @InjectMocks
  private MailEntornoServiceImpl mailEntornoService;

  @Test
  void findMailEntornoDtoByEntornoTest() {

    final MailEntornoDto mailEntornoDto = new MailEntornoDto();
    mailEntornoDto.setEntorno("PRE");
    mailEntornoDto.setActivo(Boolean.TRUE);
    final String entorno = "PRE";

    doReturn(mailEntornoDto).when(this.mailEntornoRepositoryCustom)
        .findMailEntornoDtoByEntorno(entorno);

    final Boolean result = this.mailEntornoService.findEsActivoByEntorno(entorno);

    verify(this.mailEntornoRepositoryCustom, times(1))
        .findMailEntornoDtoByEntorno(entorno);
    assertEquals(Boolean.TRUE, result);

  }

}
