package com.inditex.rrhh.icmclcwb.model.iopcomercialcalendar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class IOPComercialCalendarAsyncServiceImplTest {
  @Mock
  private IOPComercialCalendarService IOPComercialCalendarService;

  @InjectMocks
  private IOPComercialCalendarAsyncServiceImpl iopcomercialcalendarAsyncService;

  @Test
  void horarioComercialFestivosTest() {
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();

    this.iopcomercialcalendarAsyncService.horarioComercialFestivos(request);

    verify(this.IOPComercialCalendarService).horarioComercialFestivos(any(HorarioComercialFestivosRequestDto.class));
  }

}
