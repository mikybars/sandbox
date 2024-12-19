package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SlrHorarioComercialAsyncServiceImplTest {
  @Mock
  private SlrHorarioComercialService slrHorarioComercialService;

  @InjectMocks
  private SlrHorarioComercialAsyncServiceImpl slrHorarioComercialAsyncService;

  @Test
  void horarioComercialFestivosTest() {
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();

    this.slrHorarioComercialAsyncService.horarioComercialFestivos(request);

    verify(this.slrHorarioComercialService).horarioComercialFestivos(any(HorarioComercialFestivosRequestDto.class));
  }

}
