package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ReglaValidacionExcedidoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ReglaValidacionExcedido;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ReglaValidacionExcedidoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ReglaValidacionExcedidoServiceImplTest {

  @Mock
  private ReglaValidacionExcedidoRepository reglaValidacionExcedidoRepository;

  @Mock
  private ReglaValidacionExcedidoMapper reglaValidacionExcedidoMapper;

  @InjectMocks
  private ReglaValidacionExcedidoServiceImpl reglaValidacionExcedidoService;

  @Test
  void findByCclIdOrigenAndStdIdLegEntShouldReturnListOfReglas() {
    final String cclIdOrigen = "11";
    final String stdIdLegEnt = "11";

    final ReglaValidacionExcedido entity1 = ReglaValidacionExcedido.builder()
        .cclIdOrigen(cclIdOrigen)
        .stdIdLegEnt(stdIdLegEnt)
        .idTipoCalculo("001")
        .importe(new BigDecimal("1000"))
        .build();

    final ReglaValidacionExcedido entity2 = ReglaValidacionExcedido.builder()
        .cclIdOrigen(cclIdOrigen)
        .stdIdLegEnt(stdIdLegEnt)
        .idTipoCalculo("002")
        .importe(new BigDecimal("2000"))
        .build();

    final List<ReglaValidacionExcedido> entities = Arrays.asList(entity1, entity2);

    final ReglaValidacionExcedidoDto dto1 = ReglaValidacionExcedidoDto.builder()
        .cclIdOrigen(cclIdOrigen)
        .stdIdLegEnt(stdIdLegEnt)
        .idTipoCalculo("001")
        .importe(new BigDecimal("1000"))
        .build();

    final ReglaValidacionExcedidoDto dto2 = ReglaValidacionExcedidoDto.builder()
        .cclIdOrigen(cclIdOrigen)
        .stdIdLegEnt(stdIdLegEnt)
        .idTipoCalculo("002")
        .importe(new BigDecimal("2000"))
        .build();

    final List<ReglaValidacionExcedidoDto> dtos = Arrays.asList(dto1, dto2);

    when(this.reglaValidacionExcedidoRepository.findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt))
        .thenReturn(entities);
    when(this.reglaValidacionExcedidoMapper.toDto(entities)).thenReturn(dtos);

    final List<ReglaValidacionExcedidoDto> result = this.reglaValidacionExcedidoService
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals("001", result.get(0).getIdTipoCalculo());
    assertEquals(new BigDecimal("1000"), result.get(0).getImporte());
    assertEquals("002", result.get(1).getIdTipoCalculo());
    assertEquals(new BigDecimal("2000"), result.get(1).getImporte());

    verify(this.reglaValidacionExcedidoRepository, times(1))
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
    verify(this.reglaValidacionExcedidoMapper, times(1)).toDto(entities);
  }

  @Test
  void findByCclIdOrigenAndStdIdLegEntShouldReturnEmptyListWhenNoReglasFound() {
    final String cclIdOrigen = "11";
    final String stdIdLegEnt = "11";

    when(this.reglaValidacionExcedidoRepository.findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt))
        .thenReturn(Collections.emptyList());
    when(this.reglaValidacionExcedidoMapper.toDto(Collections.emptyList()))
        .thenReturn(Collections.emptyList());

    final List<ReglaValidacionExcedidoDto> result = this.reglaValidacionExcedidoService
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    assertNotNull(result);
    assertTrue(result.isEmpty());

    verify(this.reglaValidacionExcedidoRepository, times(1))
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
    verify(this.reglaValidacionExcedidoMapper, times(1)).toDto(Collections.emptyList());
  }

  @Test
  void findByCclIdOrigenAndStdIdLegEntWithDifferentParameters() {
    final String cclIdOrigen = "11";
    final String stdIdLegEnt = "11";

    final ReglaValidacionExcedido entity = ReglaValidacionExcedido.builder()
        .cclIdOrigen(cclIdOrigen)
        .stdIdLegEnt(stdIdLegEnt)
        .idTipoCalculo("002")
        .importe(new BigDecimal("500.00"))
        .build();

    final List<ReglaValidacionExcedido> entities = Collections.singletonList(entity);

    final ReglaValidacionExcedidoDto dto = ReglaValidacionExcedidoDto.builder()
        .cclIdOrigen(cclIdOrigen)
        .stdIdLegEnt(stdIdLegEnt)
        .idTipoCalculo("002")
        .importe(new BigDecimal("500.00"))
        .build();

    final List<ReglaValidacionExcedidoDto> dtos = Collections.singletonList(dto);

    when(this.reglaValidacionExcedidoRepository.findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt))
        .thenReturn(entities);
    when(this.reglaValidacionExcedidoMapper.toDto(entities)).thenReturn(dtos);

    final List<ReglaValidacionExcedidoDto> result = this.reglaValidacionExcedidoService
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("002", result.get(0).getIdTipoCalculo());
    assertEquals(cclIdOrigen, result.get(0).getCclIdOrigen());
    assertEquals(stdIdLegEnt, result.get(0).getStdIdLegEnt());

    verify(this.reglaValidacionExcedidoRepository, times(1))
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
    verify(this.reglaValidacionExcedidoMapper, times(1)).toDto(entities);
  }
}
