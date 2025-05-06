package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionCadenaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaAgrupacionCadenaMapperDecoratorTest {

  @Mock
  private TareaAgrupacionCadenaMapper delegate;

  @InjectMocks
  private TareaAgrupacionCadenaMapperDecorator mapperDecorator = this.getClassMock();

  private TareaAgrupacionCadenaMapperDecorator getClassMock() {
    return Mockito.mock(TareaAgrupacionCadenaMapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void getAgrupOnlineResultItemDtoToTareaAgrupacionCadena_handlesMultipleEntries() {
    final AgrupOnlineResultItemDto item1 = new AgrupOnlineResultItemDto();
    item1.setIdOrigen("ORIGEN1");
    item1.setIdAgrupacion("AGRUP1");

    final AgrupOnlineResultItemDto item2 = new AgrupOnlineResultItemDto();
    item2.setIdOrigen("ORIGEN1");
    item2.setIdAgrupacion("AGRUP1");

    final TareaAgrupacionCadena mappedItem = new TareaAgrupacionCadena();
    when(this.delegate.getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(any(AgrupOnlineResultItemDto.class), any(TareaDto.class)))
        .thenReturn(mappedItem);

    final List<TareaAgrupacionCadena> result =
        this.mapperDecorator.getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(List.of(item1, item2), new TareaDto());

    assertNotNull(result);
    assertEquals(2, result.size());
  }

  @Test
  void getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto_handlesEmptySource() {
    final List<TareaAgrupacionCadenasDto> result =
        this.mapperDecorator.getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto(new ArrayList<>());
    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  void getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto_groupsByAgrupacionId() {
    final TareaAgrupacionCadena item1 = new TareaAgrupacionCadena();
    item1.setIcmIdAgrupacionOnline(1L);
    item1.setCclIdCadena("CADENA1");

    final TareaAgrupacionCadena item2 = new TareaAgrupacionCadena();
    item2.setIcmIdAgrupacionOnline(1L);
    item2.setCclIdCadena("CADENA2");

    final TareaAgrupacionCadena item3 = new TareaAgrupacionCadena();
    item3.setIcmIdAgrupacionOnline(2L);
    item3.setCclIdCadena("CADENA3");

    final List<TareaAgrupacionCadenasDto> result =
        this.mapperDecorator.getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto(List.of(item1, item2, item3));

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals(2, result.get(0).getCadenas().size());
    assertEquals(1, result.get(1).getCadenas().size());
  }

  @Test
  void getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena_handlesMultipleEntries() {
    final AgrupacionesOnlineResponseDTO item1 = new AgrupacionesOnlineResponseDTO();
    item1.setIdOrigen(1);
    item1.setIdAgrupacionOnline(1);

    final AgrupacionesOnlineResponseDTO item2 = new AgrupacionesOnlineResponseDTO();
    item2.setIdOrigen(2);
    item2.setIdAgrupacionOnline(0);

    final TareaAgrupacionCadena mappedItem = new TareaAgrupacionCadena();
    when(this.delegate.getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena(any(AgrupacionesOnlineResponseDTO.class),
        any(TareaDto.class))).thenReturn(mappedItem);

    final List<TareaAgrupacionCadena> result =
        this.mapperDecorator.getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena(List.of(item1, item2), new TareaDto());

    assertNotNull(result);
    assertEquals(2, result.size());
  }

  @Test
  void getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto_handlesNonEmptySource() {
    final TareaAgrupacionCadena item1 = new TareaAgrupacionCadena();
    final TareaAgrupacionCadena item2 = new TareaAgrupacionCadena();

    final TareaAgrupacionCadenaDto dto1 = new TareaAgrupacionCadenaDto();
    final TareaAgrupacionCadenaDto dto2 = new TareaAgrupacionCadenaDto();

    when(this.delegate.getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(item1)).thenReturn(dto1);
    when(this.delegate.getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(item2)).thenReturn(dto2);

    final List<TareaAgrupacionCadenaDto> result =
        this.mapperDecorator.getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(List.of(item1, item2));

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals(dto1, result.get(0));
    assertEquals(dto2, result.get(1));
  }
}
