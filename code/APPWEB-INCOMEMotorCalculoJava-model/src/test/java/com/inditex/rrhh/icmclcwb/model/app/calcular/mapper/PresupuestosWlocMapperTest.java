package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.PresupuestoResponseDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PresupuestosWlocMapperTest {

  private PresupuestosWlocMapper presupuestosWlocMapper;

  @BeforeEach
  void setUp() {
    this.presupuestosWlocMapper = Mappers.getMapper(PresupuestosWlocMapper.class);
  }

  @Test
  void testToPresupuestosWlocResultItemDto() {
    // Arrange
    final PresupuestoResponseDTO source = new PresupuestoResponseDTO();
    source.idCodOrigen("ORIGEN1");
    source.setFechaInicio(LocalDate.of(2023, 1, 1));
    source.setFechaFin(LocalDate.of(2023, 12, 31));
    source.setBanda(1);
    source.setOrdinal("1");
    source.setExcepcion(1);
    source.setIdEmpresa(123);
    source.setIdSeccion("SECCION1");
    source.setIdTpPresupuesto("TP1");
    source.setImporteConIva(1235);
    source.setImporteSinIva(1100);

    // Act
    final PresupuestosWlocResultItemDto result = this.presupuestosWlocMapper.toPresupuestosWlocResultItemDto(source, "01");

    // Assert
    assertEquals("01", result.getIdOrigen());
    assertEquals("2023-01-01T00:00", result.getFechaInicio().toString());
    assertEquals("2023-12-31T00:00", result.getFechaFin().toString());
    assertEquals("1", result.getOrdinal());
    assertEquals("123", result.getIdEmpresa());
    assertEquals("SECCION1", result.getIdSeccion());
    assertEquals("ORIGEN1", result.getIdLugarTrabajoMtu());
    assertEquals("TP1", result.getIdTpPresupuesto());
    assertEquals("1235", result.getImporteConImpuestos());
    assertEquals("1100", result.getImporteSinImpuestos());
  }

  @Test
  void testToPresupuestosWlocResultItemDtoList() {
    // Arrange
    final PresupuestoResponseDTO source1 = new PresupuestoResponseDTO();
    source1.idCodOrigen("ORIGEN1");
    source1.setFechaInicio(LocalDate.of(2023, 1, 1));
    source1.setFechaFin(LocalDate.of(2023, 12, 31));

    final PresupuestoResponseDTO source2 = new PresupuestoResponseDTO();
    source2.idCodOrigen("ORIGEN2");
    source2.setFechaInicio(LocalDate.of(2023, 6, 1));
    source2.setFechaFin(LocalDate.of(2023, 6, 30));

    final List<PresupuestoResponseDTO> sourceList = Arrays.asList(source1, source2);

    // Act
    final List<PresupuestosWlocResultItemDto> resultList =
        this.presupuestosWlocMapper.toPresupuestosWlocResultItemDtoList(sourceList, "01");

    // Assert
    assertEquals(2, resultList.size());
    assertEquals("01", resultList.get(0).getIdOrigen());
    assertEquals("2023-01-01T00:00", resultList.get(0).getFechaInicio().toString());
    assertEquals("01", resultList.get(1).getIdOrigen());
    assertEquals("2023-06-01T00:00", resultList.get(1).getFechaInicio().toString());
  }
}
