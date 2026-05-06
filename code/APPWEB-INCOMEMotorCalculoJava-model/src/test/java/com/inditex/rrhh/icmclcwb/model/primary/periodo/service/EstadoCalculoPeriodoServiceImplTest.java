package com.inditex.rrhh.icmclcwb.model.primary.periodo.service;

import static java.util.Collections.emptyList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.EstadoCalculoPeriodoRepository;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EstadoCalculoPeriodoServiceImplTest {

  @Mock
  EstadoCalculoPeriodoRepository estadoCalculoPeriodoRepository;

  EstadoCalculoPeriodoServiceImpl estadoCalculoPeriodoService;

  @BeforeEach
  void setUp() {
    estadoCalculoPeriodoService = new EstadoCalculoPeriodoServiceImpl(estadoCalculoPeriodoRepository);
  }

  @Nested
  class BuscarEstadosPeriodoCalculo {

    @Test
    void whenValidRequestExpectResults() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      var expected = List.of(new EstadoPeriodoCalculoDTO().idPeriodo("1"));
      when(estadoCalculoPeriodoRepository.getEstadoPeriodo(request)).thenReturn(expected);

      var result = estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(request);

      assertThat(result).isEqualTo(expected);
      verify(estadoCalculoPeriodoRepository, times(1)).getEstadoPeriodo(request);
    }

    @Test
    void whenRepositoryReturnsEmptyExpectEmptyList() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      when(estadoCalculoPeriodoRepository.getEstadoPeriodo(request)).thenReturn(emptyList());

      var result = estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(request);

      assertThat(result).isEmpty();
      verify(estadoCalculoPeriodoRepository, times(1)).getEstadoPeriodo(request);
    }

    @Test
    void whenRepositoryThrowsExceptionExpectExceptionPropagated() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      when(estadoCalculoPeriodoRepository.getEstadoPeriodo(request)).thenThrow(new RuntimeException("DB error"));

      ThrowingCallable result = () -> estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(request);

      assertThatThrownBy(result).isInstanceOf(RuntimeException.class).hasMessageContaining("DB error");
    }
  }
}
