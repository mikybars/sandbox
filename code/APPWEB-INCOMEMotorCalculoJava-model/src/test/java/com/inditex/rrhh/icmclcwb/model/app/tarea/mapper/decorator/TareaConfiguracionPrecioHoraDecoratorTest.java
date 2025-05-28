package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TareaConfiguracionPrecioHoraDecoratorTest {

  @Mock
  private TareaConfiguracionPrecioHoraMapper delegate;

  @InjectMocks
  private TareaConfiguracionPrecioHoraDecorator decorator = this.getClassMock();

  private TareaConfiguracionPrecioHoraDecorator getClassMock() {
    return Mockito.mock(TareaConfiguracionPrecioHoraDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora_ReturnsMappedList() {
    final List<ConfiguracionPrecioHoraResponseDTO> src =
        List.of(new ConfiguracionPrecioHoraResponseDTO(), new ConfiguracionPrecioHoraResponseDTO());
    final TareaDto tarea = new TareaDto();
    final TareaConfiguracionPrecioHora mappedItem1 = new TareaConfiguracionPrecioHora();
    final TareaConfiguracionPrecioHora mappedItem2 = new TareaConfiguracionPrecioHora();
    final String cclIdOrigen = "1";

    when(this.delegate.configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(src.get(0), tarea, cclIdOrigen))
        .thenReturn(mappedItem1);
    when(this.delegate.configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(src.get(1), tarea, cclIdOrigen))
        .thenReturn(mappedItem2);

    final List<TareaConfiguracionPrecioHora> result =
        this.decorator.configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(src, tarea, cclIdOrigen);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals(mappedItem1, result.get(0));
    assertEquals(mappedItem2, result.get(1));
  }
}
