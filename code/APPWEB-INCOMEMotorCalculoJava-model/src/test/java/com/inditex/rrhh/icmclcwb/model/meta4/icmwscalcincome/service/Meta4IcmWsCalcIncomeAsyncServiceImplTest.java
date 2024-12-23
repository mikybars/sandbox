package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class Meta4IcmWsCalcIncomeAsyncServiceImplTest {
  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private Meta4IcmWsCalcIncomeAsyncServiceImpl meta4IcmWsCalcIncomeAsyncService;

  @Test
  void getConfiguracionesTest() {
    final ConfiguracionesRequestDto request = new ConfiguracionesRequestDto();

    this.meta4IcmWsCalcIncomeAsyncService.getConfiguraciones(request);

    verify(this.meta4IcmWsCalcIncomeService).getConfiguracion(any(ConfiguracionesRequestDto.class));
  }

  @Test
  void getMotivosDesplazamientoTest() {
    this.meta4IcmWsCalcIncomeAsyncService.getMotivosDesplazamiento(MotivosDesplazamientoRequestDto.builder().build());

    verify(this.meta4IcmWsCalcIncomeService).getMotivosDesplazamiento(any(MotivosDesplazamientoRequestDto.class));
  }

  @Test
  void getCatalogoTest() {
    final CatalogoRequestDto request = new CatalogoRequestDto();

    this.meta4IcmWsCalcIncomeAsyncService.getCatalogo(request);

    verify(this.meta4IcmWsCalcIncomeService).getCatalogo(any(CatalogoRequestDto.class));
  }

  @Test
  void getTiposHoraTest() {
    final TiposHoraRequestDto request = new TiposHoraRequestDto();

    this.meta4IcmWsCalcIncomeAsyncService.getTiposHora(request);

    verify(this.meta4IcmWsCalcIncomeService).getTiposHora(any(TiposHoraRequestDto.class));
  }

}
