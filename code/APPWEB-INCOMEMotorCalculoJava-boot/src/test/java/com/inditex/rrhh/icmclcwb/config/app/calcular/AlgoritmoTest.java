package com.inditex.rrhh.icmclcwb.config.app.calcular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class AlgoritmoTest {

  @Mock
  private AlgoritmoService algoritmoService;

  @Test
  @Disabled
  public void checkDuplicatedActives() {
    assertEquals(Boolean.FALSE, this.algoritmoService.checkDuplicatedActives());
  }

}
