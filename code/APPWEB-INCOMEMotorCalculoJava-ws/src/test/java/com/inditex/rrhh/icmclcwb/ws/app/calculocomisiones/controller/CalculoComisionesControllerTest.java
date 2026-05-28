package com.inditex.rrhh.icmclcwb.ws.app.calculocomisiones.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.liquidacion.service.LiquidacionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResultItemDto;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaResultadoItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoResponseDTO;
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
  LiquidacionService liquidacionService;

  @Mock
  CalculoComisionesApiMapper mapper;

  @BeforeEach
  void beforeEach() {
    controller = new CalculoComisionesController(calculoComisionesService, liquidacionService, mapper);
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

  @Nested
  class ConsultarCalculoBulk {

    @Mock
    CalculoConsultaRequestDTO request;

    @Mock
    CalculoConsultaResultadoItemDTO resultItem;

    @Test
    void whenInvokedExpectServiceCalledAndOkStatus() {
      List<CalculoConsultaResultadoItemDTO> expectedResult = List.of(resultItem);
      when(liquidacionService.consultarCalculoBulk(request)).thenReturn(expectedResult);

      ResponseEntity<List<CalculoConsultaResultadoItemDTO>> result = controller.consultarCalculoBulk(request);

      assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(result.getBody()).isSameAs(expectedResult);
      verify(liquidacionService, times(1)).consultarCalculoBulk(request);
    }

    @Test
    void whenEmptyResultExpectOkStatusWithEmptyList() {
      List<CalculoConsultaResultadoItemDTO> emptyResult = List.of();
      when(liquidacionService.consultarCalculoBulk(request)).thenReturn(emptyResult);

      ResponseEntity<List<CalculoConsultaResultadoItemDTO>> result = controller.consultarCalculoBulk(request);

      assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(result.getBody()).isEmpty();
    }
  }

  @Nested
  class ActualizarEstadoCalculoBulk {

    @Mock
    CalculoEstadoRequestDTO request;

    @Mock
    CalculoEstadoResponseDTO responseDto;

    @Test
    void whenInvokedExpectServiceCalledAndOkStatus() {
      when(liquidacionService.actualizarEstadoCalculoBulk(request)).thenReturn(responseDto);

      ResponseEntity<CalculoEstadoResponseDTO> result = controller.actualizarEstadoCalculoBulk(request);

      assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(result.getBody()).isSameAs(responseDto);
      verify(liquidacionService, times(1)).actualizarEstadoCalculoBulk(request);
    }
  }
}
