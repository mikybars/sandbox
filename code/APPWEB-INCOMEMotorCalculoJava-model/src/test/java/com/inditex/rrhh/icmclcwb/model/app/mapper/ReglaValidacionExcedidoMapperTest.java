package com.inditex.rrhh.icmclcwb.model.app.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ReglaValidacionExcedido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ReglaValidacionExcedidoMapperTest {

  private ReglaValidacionExcedidoMapper mapper;

  @BeforeEach
  void setup() {
    this.mapper = Mappers.getMapper(ReglaValidacionExcedidoMapper.class);
  }

  @Test
  void toDtoShouldMapAllFields() {
    final ReglaValidacionExcedido entity = ReglaValidacionExcedido.builder()
        .cclIdOrigen("11")
        .stdIdLegEnt("11")
        .idTipoCalculo("001")
        .importe(new BigDecimal("1000"))
        .build();

    final ReglaValidacionExcedidoDto dto = this.mapper.toDto(entity);

    assertNotNull(dto);
    assertEquals(entity.getCclIdOrigen(), dto.getCclIdOrigen());
    assertEquals(entity.getStdIdLegEnt(), dto.getStdIdLegEnt());
    assertEquals(entity.getIdTipoCalculo(), dto.getIdTipoCalculo());
    assertEquals(entity.getImporte(), dto.getImporte());
  }

  @Test
  void toDtoShouldReturnNullWhenEntityIsNull() {
    final ReglaValidacionExcedidoDto dto = this.mapper.toDto((ReglaValidacionExcedido) null);

    assertNull(dto);
  }

  @Test
  void toDtoListShouldMapAllEntities() {
    final ReglaValidacionExcedido entity1 = ReglaValidacionExcedido.builder()
        .cclIdOrigen("11")
        .stdIdLegEnt("8")
        .idTipoCalculo("001")
        .importe(new BigDecimal("1000"))
        .build();

    final ReglaValidacionExcedido entity2 = ReglaValidacionExcedido.builder()
        .cclIdOrigen("11")
        .stdIdLegEnt("11")
        .idTipoCalculo("002")
        .importe(new BigDecimal("2000"))
        .build();

    final List<ReglaValidacionExcedido> entities = Arrays.asList(entity1, entity2);

    final List<ReglaValidacionExcedidoDto> dtos = this.mapper.toDto(entities);

    assertNotNull(dtos);
    assertEquals(2, dtos.size());
    assertEquals(entity1.getCclIdOrigen(), dtos.get(0).getCclIdOrigen());
    assertEquals(entity1.getIdTipoCalculo(), dtos.get(0).getIdTipoCalculo());
    assertEquals(entity2.getCclIdOrigen(), dtos.get(1).getCclIdOrigen());
    assertEquals(entity2.getIdTipoCalculo(), dtos.get(1).getIdTipoCalculo());
  }

  @Test
  void toDtoListShouldReturnEmptyListWhenEntitiesIsEmpty() {
    final List<ReglaValidacionExcedidoDto> dtos = this.mapper.toDto(Collections.emptyList());

    assertNotNull(dtos);
    assertEquals(0, dtos.size());
  }

  @Test
  void toDtoListShouldReturnNullWhenEntitiesIsNull() {
    final List<ReglaValidacionExcedidoDto> dtos = this.mapper.toDto((List<ReglaValidacionExcedido>) null);

    assertNull(dtos);
  }
}
