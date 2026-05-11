package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraDataResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VentaIntegraServiceNoOpTest {

  private VentaIntegraServiceNoOp service;

  @BeforeEach
  void beforeEach() {
    service = new VentaIntegraServiceNoOp();
  }

  @Nested
  class GetTiendasVentaNoIntegra {

    @Test
    void when_invoked_expect_empty_list() {
      final VentaIntegraRequestDto request = VentaIntegraRequestDto.builder()
          .idOrigen(1)
          .idEmpresa(2)
          .fechaDesde("2025-01-01")
          .fechaHasta("2025-12-31")
          .listaTiendas(List.of(100, 200))
          .build();

      final List<VentaIntegraDataResponseDto> result = service.getTiendasVentaNoIntegra(request);

      assertThat(result).isEmpty();
    }

    @Test
    void when_invoked_with_null_expect_empty_list() {
      final List<VentaIntegraDataResponseDto> result = service.getTiendasVentaNoIntegra(null);

      assertThat(result).isEmpty();
    }
  }
}
