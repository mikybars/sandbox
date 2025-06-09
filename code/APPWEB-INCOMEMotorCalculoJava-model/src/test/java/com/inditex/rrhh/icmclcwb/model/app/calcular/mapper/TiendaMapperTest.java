package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiendaResponseDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class TiendaMapperTest {

  private TiendaMapper tiendaMapper;

  @BeforeEach
  void setUp() {
    this.tiendaMapper = Mappers.getMapper(TiendaMapper.class);
  }

  @Test
  void testToGenericTiendaResultItemDto() {
    final TiendaResponseDTO source = new TiendaResponseDTO();
    source.setStdIdWorkLocat("123");
    source.setCclIdCodOrigen("ORIGEN1");
    source.setFechaInicio(LocalDate.of(2023, 1, 1));
    source.setFechaFin(LocalDate.of(2023, 12, 31));
    source.setStdIdCountry("ES");
    source.setStdIdGeoDiv("PROV1");
    source.setStdIdLegEnt("EMP1");
    source.setCclIdCadena("CAD1");
    source.setStdIdSubGeoDiv("LOC1");

    final GenericTiendaResultItemDto result = this.tiendaMapper.toGenericTiendaResultItemDto(source, "01");

    assertEquals("123", result.getIdLugarTrabajo());
    assertEquals("01", result.getIdOrigen());
    assertEquals("ES", result.getIdPais());
    assertEquals("LOC1", result.getIdProvincia());
    assertEquals("EMP1", result.getIdEmpresa());
    assertEquals("CAD1", result.getIdCadena());
  }

  @Test
  void testToGenericTiendaResultItemDtoList() {
    final TiendaResponseDTO source1 = new TiendaResponseDTO();
    source1.setStdIdWorkLocat("123");
    source1.setCclIdCodOrigen("ORIGEN1");
    source1.setFechaInicio(LocalDate.of(2023, 12, 1));
    source1.setFechaFin(LocalDate.of(2023, 12, 31));

    final TiendaResponseDTO source2 = new TiendaResponseDTO();
    source2.setStdIdWorkLocat("456");
    source2.setCclIdCodOrigen("ORIGEN2");
    source2.setFechaInicio(LocalDate.of(2023, 12, 1));
    source2.setFechaFin(LocalDate.of(2023, 12, 31));

    final List<TiendaResponseDTO> sourceList = Arrays.asList(source1, source2);

    final List<GenericTiendaResultItemDto> resultList = this.tiendaMapper.toGenericTiendaResultItemDtoList(sourceList, "01");

    assertEquals(2, resultList.size());
    assertEquals("123", resultList.get(0).getIdLugarTrabajo());
    assertEquals("01", resultList.get(0).getIdOrigen());
    assertEquals("456", resultList.get(1).getIdLugarTrabajo());
    assertEquals("01", resultList.get(1).getIdOrigen());
  }
}
