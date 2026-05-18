package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpresaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.OrigenDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.TiendaOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PeopleAclMapperTest {

  static final LocalDateTime FECHA_INICIO = LocalDateTime.parse("2026-01-01T00:00:00");

  static final LocalDateTime FECHA_FIN = LocalDateTime.parse("2026-12-31T23:59:59");

  static final OffsetDateTime FECHA_INICIO_UTC = FECHA_INICIO.atOffset(ZoneOffset.UTC);

  static final OffsetDateTime FECHA_FIN_UTC = FECHA_FIN.atOffset(ZoneOffset.UTC);

  PeopleAclMapper mapper;

  @BeforeEach
  void beforeEach() {
    mapper = Mappers.getMapper(PeopleAclMapper.class);
  }

  @Nested
  class ToSearchTiendasOnlineRequestDtoFromFilter {

    @Test
    void whenFilterPopulatedExpectFieldsMappedAndIdCadenasIgnored() {
      GenericFilterDto src = new GenericFilterDto();
      src.setIdOrigen("ORIG-1");
      src.setFechaInicio(FECHA_INICIO);
      src.setFechaFin(FECHA_FIN);
      src.setIdCadena("CAD-1");

      SearchTiendasOnlineRequestDto result = mapper.toSearchTiendasOnlineRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdCadenas()).isEmpty();
    }

    @Test
    void whenFilterNullExpectNull() {
      SearchTiendasOnlineRequestDto result = mapper.toSearchTiendasOnlineRequestDto((GenericFilterDto) null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToSearchTiendasOnlineRequestDtoFromRequest {

    @Test
    void whenRequestPopulatedExpectDataUnwrappedAndMapped() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-2");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      TiendaOnlineRequestDto src = new TiendaOnlineRequestDto();
      src.setData(filter);

      SearchTiendasOnlineRequestDto result = mapper.toSearchTiendasOnlineRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-2");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdCadenas()).isEmpty();
    }

    @Test
    void whenRequestDataNullExpectNull() {
      TiendaOnlineRequestDto src = new TiendaOnlineRequestDto();
      src.setData(null);

      SearchTiendasOnlineRequestDto result = mapper.toSearchTiendasOnlineRequestDto(src);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToOffsetDateTime {

    @Test
    void whenSourcePopulatedExpectUtcOffset() {
      OffsetDateTime result = mapper.toOffsetDateTime(FECHA_INICIO);

      assertThat(result).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getOffset()).isEqualTo(ZoneOffset.UTC);
    }

    @Test
    void whenSourceNullExpectNull() {
      OffsetDateTime result = mapper.toOffsetDateTime(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToLocalDateTime {

    @Test
    void whenSourcePopulatedExpectLocalDateTime() {
      LocalDateTime result = mapper.toLocalDateTime(FECHA_INICIO_UTC);

      assertThat(result).isEqualTo(FECHA_INICIO);
    }

    @Test
    void whenSourceWithNonUtcOffsetExpectNormalizedToUtc() {
      OffsetDateTime src = LocalDateTime.parse("2026-01-01T02:00:00").atOffset(ZoneOffset.ofHours(2));

      LocalDateTime result = mapper.toLocalDateTime(src);

      assertThat(result).isEqualTo(LocalDateTime.parse("2026-01-01T00:00:00"));
    }

    @Test
    void whenSourceNullExpectNull() {
      LocalDateTime result = mapper.toLocalDateTime(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToTiendaOnlineResultItemDto {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndRenamed() {
      TiendaOnlineDto src = new TiendaOnlineDto();
      src.setIdOrigen("ORIG-3");
      src.setIdEmpresa("EMP-1");
      src.setIdCadena("CAD-2");
      src.setIdLugarTrabajo("T123");
      src.setIdLugarTrabajoMtu("123");
      src.setFechaInicio(FECHA_INICIO_UTC);
      src.setFechaFin(FECHA_FIN_UTC);

      TiendaOnlineResultItemDto result = mapper.toTiendaOnlineResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-3");
      assertThat(result.getIdEmpresa()).isEqualTo("EMP-1");
      assertThat(result.getIdCadena()).isEqualTo("CAD-2");
      assertThat(result.getIdLocalizacion()).isEqualTo(123L);
      assertThat(result.getIdLocalizacionMeta4()).isEqualTo("T123");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN);
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      TiendaOnlineResultItemDto result = mapper.toTiendaOnlineResultItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToTiendaOnlineResultItemDtoList {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      TiendaOnlineDto first = new TiendaOnlineDto();
      first.setIdOrigen("ORIG-A");
      first.setIdLugarTrabajo("T1");
      first.setIdLugarTrabajoMtu("1");
      first.setFechaInicio(FECHA_INICIO_UTC);
      first.setFechaFin(FECHA_FIN_UTC);
      TiendaOnlineDto second = new TiendaOnlineDto();
      second.setIdOrigen("ORIG-B");
      second.setIdLugarTrabajo("T2");
      second.setIdLugarTrabajoMtu("2");
      second.setFechaInicio(FECHA_INICIO_UTC);
      second.setFechaFin(FECHA_FIN_UTC);

      List<TiendaOnlineResultItemDto> result = mapper.toTiendaOnlineResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdOrigen()).isEqualTo("ORIG-A");
      assertThat(result.get(0).getIdLocalizacion()).isEqualTo(1L);
      assertThat(result.get(0).getIdLocalizacionMeta4()).isEqualTo("T1");
      assertThat(result.get(1).getIdOrigen()).isEqualTo("ORIG-B");
      assertThat(result.get(1).getIdLocalizacion()).isEqualTo(2L);
      assertThat(result.get(1).getIdLocalizacionMeta4()).isEqualTo("T2");
    }

    @Test
    void whenNullListExpectNull() {
      List<TiendaOnlineResultItemDto> result = mapper.toTiendaOnlineResultItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<TiendaOnlineResultItemDto> result = mapper.toTiendaOnlineResultItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToTiendaOnlineResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      TiendaOnlineDto item = new TiendaOnlineDto();
      item.setIdOrigen("ORIG-X");
      item.setIdLugarTrabajo("T123");
      item.setIdLugarTrabajoMtu("99");
      item.setFechaInicio(FECHA_INICIO_UTC);
      item.setFechaFin(FECHA_FIN_UTC);
      SearchTiendasOnlineResponseDto src = new SearchTiendasOnlineResponseDto();
      src.setData(List.of(item));

      TiendaOnlineResponseDto result = mapper.toTiendaOnlineResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-X");
      assertThat(result.getData().get(0).getIdLocalizacion()).isEqualTo(99L);
      assertThat(result.getData().get(0).getIdLocalizacionMeta4()).isEqualTo("T123");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      TiendaOnlineResponseDto result = mapper.toTiendaOnlineResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchTiendasOnlineResponseDto src = new SearchTiendasOnlineResponseDto();
      src.setData(List.of());

      TiendaOnlineResponseDto result = mapper.toTiendaOnlineResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class ToSearchOrigenesRequestDto {

    @Test
    void whenFilterPopulatedExpectIdsEmpresaMappedToIdSociedades() {
      GenericFilterDto src = new GenericFilterDto();
      src.setIdsEmpresa(List.of("SOC-1", "SOC-2"));

      SearchOrigenesRequestDto result = mapper.toSearchOrigenesRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdSociedades()).containsExactly("SOC-1", "SOC-2");
    }

    @Test
    void whenFilterNullExpectNull() {
      SearchOrigenesRequestDto result = mapper.toSearchOrigenesRequestDto((GenericFilterDto) null);

      assertThat(result).isNull();
    }

    @Test
    void whenRequestPopulatedExpectDataUnwrappedAndMapped() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdsEmpresa(List.of("SOC-3"));
      OrigenRequestDto src = new OrigenRequestDto();
      src.setData(filter);

      SearchOrigenesRequestDto result = mapper.toSearchOrigenesRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdSociedades()).containsExactly("SOC-3");
    }

    @Test
    void whenRequestDataNullExpectNull() {
      OrigenRequestDto src = new OrigenRequestDto();
      src.setData(null);

      SearchOrigenesRequestDto result = mapper.toSearchOrigenesRequestDto(src);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToOrigenResultItemDto {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndAuditFieldsIgnored() {
      OrigenDto src = new OrigenDto();
      src.setIdOrigen("ORIG-1");
      src.setIdSociedad("SOC-1");

      OrigenResultItemDto result = mapper.toOrigenResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdSociedad()).isEqualTo("SOC-1");
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      OrigenResultItemDto result = mapper.toOrigenResultItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToOrigenResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      OrigenDto item = new OrigenDto();
      item.setIdOrigen("ORIG-X");
      item.setIdSociedad("SOC-X");
      SearchOrigenesResponseDto src = new SearchOrigenesResponseDto();
      src.setData(List.of(item));

      OrigenResponseDto result = mapper.toOrigenResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-X");
      assertThat(result.getData().get(0).getIdSociedad()).isEqualTo("SOC-X");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      OrigenResponseDto result = mapper.toOrigenResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchOrigenesResponseDto src = new SearchOrigenesResponseDto();
      src.setData(List.of());

      OrigenResponseDto result = mapper.toOrigenResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class ToSearchEmpresasRequestDto {

    @Test
    void whenRequestPopulatedExpectIdOrigenesExtracted() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdOrigenReg("ORIG-1");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdOrigenReg("ORIG-2");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setItem(List.of(item1, item2));
      EmpresaRequestDto src = new EmpresaRequestDto();
      src.setData(filter);

      var result = mapper.toSearchEmpresasRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigenes()).containsExactly("ORIG-1", "ORIG-2");
    }

    @Test
    void whenRequestNullExpectEmptyIdOrigenes() {
      var result = mapper.toSearchEmpresasRequestDto((EmpresaRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigenes()).isEmpty();
    }

    @Test
    void whenRequestDataNullExpectEmptyIdOrigenes() {
      EmpresaRequestDto src = new EmpresaRequestDto();
      src.setData(null);

      var result = mapper.toSearchEmpresasRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigenes()).isEmpty();
    }

    @Test
    void whenRequestItemNullExpectEmptyIdOrigenes() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setItem(null);
      EmpresaRequestDto src = new EmpresaRequestDto();
      src.setData(filter);

      var result = mapper.toSearchEmpresasRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigenes()).isEmpty();
    }
  }

  @Nested
  class ToEmpresaResultItemDto {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndAuditFieldsIgnored() {
      EmpresaDto src = new EmpresaDto();
      src.setIdOrigen("ORIG-1");
      src.setIdEmpresa("EMP-1");

      EmpresaResultItemDto result = mapper.toEmpresaResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdEmpresa()).isEqualTo("EMP-1");
      assertThat(result.getNombreEmpresa()).isNull();
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      EmpresaResultItemDto result = mapper.toEmpresaResultItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToEmpresaResultItemDtoList {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      EmpresaDto first = new EmpresaDto();
      first.setIdOrigen("ORIG-A");
      first.setIdEmpresa("EMP-A");
      EmpresaDto second = new EmpresaDto();
      second.setIdOrigen("ORIG-B");
      second.setIdEmpresa("EMP-B");

      List<EmpresaResultItemDto> result = mapper.toEmpresaResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdOrigen()).isEqualTo("ORIG-A");
      assertThat(result.get(0).getIdEmpresa()).isEqualTo("EMP-A");
      assertThat(result.get(1).getIdOrigen()).isEqualTo("ORIG-B");
      assertThat(result.get(1).getIdEmpresa()).isEqualTo("EMP-B");
    }

    @Test
    void whenNullListExpectNull() {
      List<EmpresaResultItemDto> result = mapper.toEmpresaResultItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<EmpresaResultItemDto> result = mapper.toEmpresaResultItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToEmpresaResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      EmpresaDto item = new EmpresaDto();
      item.setIdOrigen("ORIG-X");
      item.setIdEmpresa("EMP-X");
      SearchEmpresasResponseDto src = new SearchEmpresasResponseDto();
      src.setData(List.of(item));

      EmpresaResponseDto result = mapper.toEmpresaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-X");
      assertThat(result.getData().get(0).getIdEmpresa()).isEqualTo("EMP-X");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      EmpresaResponseDto result = mapper.toEmpresaResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchEmpresasResponseDto src = new SearchEmpresasResponseDto();
      src.setData(List.of());

      EmpresaResponseDto result = mapper.toEmpresaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }
}
