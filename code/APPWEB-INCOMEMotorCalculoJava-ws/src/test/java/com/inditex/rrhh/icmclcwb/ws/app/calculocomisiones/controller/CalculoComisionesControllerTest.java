package com.inditex.rrhh.icmclcwb.ws.app.calculocomisiones.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResultItemDto;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.model.app.calculocomisiones.mapper.CalculoComisionesApiMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.service.CalculoComisionesService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CalculoComisionesControllerTest {

  CalculoComisionesController controller;

  @Mock
  CalculoComisionesService calculoComisionesService;

  @Mock
  CalculoComisionesApiMapper mapper;

  @BeforeEach
  void beforeEach() {
    controller = new CalculoComisionesController(calculoComisionesService, mapper);
  }

  @Nested
  class BuscarCalculoComisiones {

    @Mock
    CalculoComisionesSearchRequestDTO request;

    @Mock
    CalculoComisionesFilterDto filterDto;

    @Mock
    CalculoComisionesResponseDto responseDto;

    @Mock
    CalculoComisionesResultItemDto resultItem;

    @Mock
    CalculoComisionesItemDTO itemDto;

    @Test
    void whenInvokedExpectMapperAndServiceCalledAndOkStatus() {
      List<CalculoComisionesResultItemDto> dataList = List.of(resultItem);
      List<CalculoComisionesItemDTO> expectedResult = List.of(itemDto);
      when(mapper.toFilterDto(request)).thenReturn(filterDto);
      when(calculoComisionesService.buscarCalculoComisiones(filterDto)).thenReturn(responseDto);
      when(responseDto.getData()).thenReturn(dataList);
      when(mapper.toItemDtoList(dataList)).thenReturn(expectedResult);

      ResponseEntity<List<CalculoComisionesItemDTO>> result = controller.buscarCalculoComisiones(request);

      assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(result.getBody()).isSameAs(expectedResult);
      verify(mapper, times(1)).toFilterDto(request);
      verify(calculoComisionesService, times(1)).buscarCalculoComisiones(filterDto);
      verify(mapper, times(1)).toItemDtoList(dataList);
    }

    @Test
    void whenEmptyResultExpectOkStatusWithEmptyList() {
      List<CalculoComisionesResultItemDto> emptyData = List.of();
      List<CalculoComisionesItemDTO> emptyResult = List.of();
      when(mapper.toFilterDto(request)).thenReturn(filterDto);
      when(calculoComisionesService.buscarCalculoComisiones(filterDto)).thenReturn(responseDto);
      when(responseDto.getData()).thenReturn(emptyData);
      when(mapper.toItemDtoList(emptyData)).thenReturn(emptyResult);

      ResponseEntity<List<CalculoComisionesItemDTO>> result = controller.buscarCalculoComisiones(request);

      assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(result.getBody()).isEmpty();
    }
  }
}
