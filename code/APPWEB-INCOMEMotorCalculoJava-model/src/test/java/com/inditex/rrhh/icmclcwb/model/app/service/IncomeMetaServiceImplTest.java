package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class IncomeMetaServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  @Qualifier("externosIncomeMetaApiClient")
  private ExternosApi externosApi;

  @InjectMocks
  private IncomeMetaServiceImpl incomeMetaService;

  @Test
  void getEmpleadosExternosExcluidosDenominadorTest(@Random final ExternosRequestDTO request,
      @Random(size = 2, type = EmpleadoExternoDTO.class) final List<EmpleadoExternoDTO> response) {
    doReturn(response).when(this.externosApi).findExternos(request);

    final List<EmpleadoExternoDTO> result = this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(request);
    Assertions.assertEquals(response, result);
  }

}
