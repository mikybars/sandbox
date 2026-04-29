package com.inditex.rrhh.icmclcwb.ws.app.periodo.controller;

import static java.util.Collections.emptyList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.EstadoCalculoPeriodoService;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class EstadoCalculoPeriodoControllerTest {

  @Mock
  EstadoCalculoPeriodoService estadoCalculoPeriodoService;

  EstadoCalculoPeriodoController estadoCalculoPeriodoController;

  @BeforeEach
  void setUp() {
    estadoCalculoPeriodoController = new EstadoCalculoPeriodoController(estadoCalculoPeriodoService);
  }

  @Nested
  class BuscarEstadosPeriodoCalculo {

    @Test
    void whenResultsPresentExpectOkWithBody() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1", "STORE2"), "1", "ORG1");
      var expected = List.of(
          new EstadoPeriodoCalculoDTO()
              .idPeriodo("1")
              .idOrigen("ORIGEN1")
              .idEmpresa("LEG1")
              .fechaInicioPeriodo(LocalDate.of(2026, 1, 1))
              .fechaFinPeriodo(LocalDate.of(2026, 1, 31))
              .idLugarTrabajo("STORE1")
              .idEstado("3")
              .nombreEstado("Calculado"));
      when(estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(request)).thenReturn(expected);

      var response = estadoCalculoPeriodoController.buscarEstadosPeriodoCalculo(request);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(response.getBody()).isEqualTo(expected);
      verify(estadoCalculoPeriodoService, times(1)).buscarEstadosPeriodoCalculo(request);
    }

    @Test
    void whenNoResultsExpectOkWithEmptyBody() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      when(estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(request)).thenReturn(emptyList());

      var response = estadoCalculoPeriodoController.buscarEstadosPeriodoCalculo(request);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(response.getBody()).isEmpty();
    }

    @Test
    void whenServiceThrowsExpectExceptionPropagated() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      when(estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(request))
          .thenThrow(new RuntimeException("DB error"));

      ThrowingCallable result = () -> estadoCalculoPeriodoController.buscarEstadosPeriodoCalculo(request);

      assertThatThrownBy(result)
          .isInstanceOf(RuntimeException.class)
          .hasMessage("DB error");
    }
  }
}
