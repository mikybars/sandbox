package com.inditex.rrhh.icmclcwb.model.app.calculocomisiones.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.AmbitoFilter;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.ComisionLineDto;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.ComisionLineItemDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CalculoComisionesApiMapperTest {

  CalculoComisionesApiMapper mapper;

  @BeforeEach
  void beforeEach() {
    mapper = Mappers.getMapper(CalculoComisionesApiMapper.class);
  }

  @Nested
  class ToFilterDto {

    @Test
    void whenValidRequestExpectAllFieldsMapped() {
      CalculoComisionesSearchRequestDTO request = new CalculoComisionesSearchRequestDTO();
      request.setIdPeriodo(100L);
      request.setIdOrigen(200L);
      request.setAmbito(CalculoComisionesSearchRequestDTO.AmbitoEnum.EMPRESAS);
      request.setEmpresas(List.of("EMP1", "EMP2"));
      request.setTiendas(List.of("T001"));
      request.setEmpleados(List.of("E001", "E002", "E003"));

      CalculoComisionesFilterDto result = mapper.toFilterDto(request);

      assertThat(result.getIdPeriodo()).isEqualTo(100L);
      assertThat(result.getIdOrigen()).isEqualTo(200L);
      assertThat(result.getAmbito()).isEqualTo(AmbitoFilter.EMPRESAS);
      assertThat(result.getEmpresas()).containsExactly("EMP1", "EMP2");
      assertThat(result.getTiendas()).containsExactly("T001");
      assertThat(result.getEmpleados()).containsExactly("E001", "E002", "E003");
    }

    @Test
    void whenNullAmbitoExpectNullInResult() {
      CalculoComisionesSearchRequestDTO request = new CalculoComisionesSearchRequestDTO();
      request.setIdPeriodo(100L);
      request.setIdOrigen(200L);
      request.setAmbito(null);

      CalculoComisionesFilterDto result = mapper.toFilterDto(request);

      assertThat(result.getAmbito()).isNull();
    }

    @Test
    void whenNullRequestExpectNullResult() {
      CalculoComisionesFilterDto result = mapper.toFilterDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToItemDtoList {

    @Test
    void whenValidItemsExpectAllMapped() {
      ComisionLineDto line1 = ComisionLineDto.builder()
          .idTipoComision("TC1")
          .idTipoCalculo("CALC1")
          .codTipoHora("HORA1")
          .importe(100.50)
          .build();
      ComisionLineDto line2 = ComisionLineDto.builder()
          .idTipoComision("TC2")
          .idTipoCalculo("CALC2")
          .codTipoHora("HORA2")
          .importe(200.75)
          .build();
      CalculoComisionesResultItemDto item = CalculoComisionesResultItemDto.builder()
          .idEmpleado("EMP001")
          .idEmpresa("EMPRESA1")
          .idLugarTrabajo("TIENDA1")
          .comisiones(List.of(line1, line2))
          .build();

      List<CalculoComisionesItemDTO> result = mapper.toItemDtoList(List.of(item));

      assertThat(result).hasSize(1);
      CalculoComisionesItemDTO mapped = result.get(0);
      assertThat(mapped.getIdEmpleado()).isEqualTo("EMP001");
      assertThat(mapped.getIdEmpresa()).isEqualTo("EMPRESA1");
      assertThat(mapped.getIdLugarTrabajo()).isEqualTo("TIENDA1");
      assertThat(mapped.getComisiones()).hasSize(2);
      ComisionLineItemDTO mappedLine1 = mapped.getComisiones().get(0);
      assertThat(mappedLine1.getIdTipoComision()).isEqualTo("TC1");
      assertThat(mappedLine1.getIdTipoCalculo()).isEqualTo("CALC1");
      assertThat(mappedLine1.getCodTipoHora()).isEqualTo("HORA1");
      assertThat(mappedLine1.getImporte()).isEqualTo(100.50);
    }

    @Test
    void whenEmptyListExpectEmptyResult() {
      List<CalculoComisionesItemDTO> result = mapper.toItemDtoList(List.of());

      assertThat(result).isEmpty();
    }

    @Test
    void whenNullListExpectNullResult() {
      List<CalculoComisionesItemDTO> result = mapper.toItemDtoList(null);

      assertThat(result).isNull();
    }
  }
}
