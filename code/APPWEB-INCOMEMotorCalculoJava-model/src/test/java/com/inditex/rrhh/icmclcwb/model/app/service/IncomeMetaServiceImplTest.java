package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.inditex.rrhh.icmclcwb.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class IncomeMetaServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  @Qualifier("externosIncomeMetaApiClient")
  private ExternosApi externosApi;

  @InjectMocks
  private IncomeMetaServiceImpl incomeMetaService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getEmpleadosExternosExcluidosDenominadorTest(final ExternosRequestDTO request,
      final List<EmpleadoExternoDTO> response) {
    doReturn(response).when(this.externosApi).findExternos(request);

    final List<EmpleadoExternoDTO> result = this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(request);
    Assertions.assertEquals(response, result);
  }

}
