package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.AusenciaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.ConfiguracionVentaOnlineDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpresaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.OrigenDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasIncomeRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasIncomeResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.TiendaIncomeDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.TiendaOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

  @Nested
  class ToSearchAusenciasRequestDto {

    @Test
    void whenRequestPopulatedExpectAllFieldsMapped() {
      GenericFilterParametersDto item = new GenericFilterParametersDto();
      item.setIdEmpleado("EMP-001");
      item.setOrEmpleado("1");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setIdsEmpresa(List.of("SOC-1"));
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(List.of(item));
      AusenciasRequestDto src = new AusenciasRequestDto();
      src.setData(filter);

      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdEmpresa()).isEqualTo("SOC-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdEmpleado()).isEqualTo("EMP-001");
      assertThat(result.getIdOrdinalEmpleado()).isEqualTo("1");
    }

    @Test
    void whenRequestNullExpectEmptyDto() {
      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto((AusenciasRequestDto) null);

      assertThat(result).isNotNull();
    }

    @Test
    void whenRequestDataNullExpectEmptyDto() {
      AusenciasRequestDto src = new AusenciasRequestDto();
      src.setData(null);

      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto(src);

      assertThat(result).isNotNull();
    }

    @Test
    void whenIdsEmpresaNullExpectIdEmpresaNull() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setIdsEmpresa(null);
      AusenciasRequestDto src = new AusenciasRequestDto();
      src.setData(filter);

      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto(src);

      assertThat(result.getIdEmpresa()).isNull();
    }

    @Test
    void whenIdsEmpresaEmptyExpectIdEmpresaNull() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setIdsEmpresa(List.of());
      AusenciasRequestDto src = new AusenciasRequestDto();
      src.setData(filter);

      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto(src);

      assertThat(result.getIdEmpresa()).isNull();
    }

    @Test
    void whenItemNullExpectEmpleadoFieldsNull() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setItem(null);
      AusenciasRequestDto src = new AusenciasRequestDto();
      src.setData(filter);

      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto(src);

      assertThat(result.getIdEmpleado()).isNull();
      assertThat(result.getIdOrdinalEmpleado()).isNull();
    }

    @Test
    void whenItemEmptyExpectEmpleadoFieldsNull() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setItem(List.of());
      AusenciasRequestDto src = new AusenciasRequestDto();
      src.setData(filter);

      SearchAusenciasRequestDto result = mapper.toSearchAusenciasRequestDto(src);

      assertThat(result.getIdEmpleado()).isNull();
      assertThat(result.getIdOrdinalEmpleado()).isNull();
    }
  }

  @Nested
  class ToAusenciasResultItemDto {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndAuditFieldsIgnored() {
      AusenciaDto src = new AusenciaDto();
      src.setIdOrigen("ORIG-1");
      src.setIdEmpleado("EMP-1");
      src.setIdOrdinalEmpleado("2");
      src.setTipo(AusenciaDto.TipoEnum._1);
      src.setFechaInicio(FECHA_INICIO_UTC);
      src.setFechaFin(FECHA_FIN_UTC);

      AusenciasResultItemDto result = mapper.toAusenciasResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdorigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(result.getOrEmpleado()).isEqualTo("2");
      assertThat(result.getTipo()).isEqualTo("1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN);
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      AusenciasResultItemDto result = mapper.toAusenciasResultItemDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenTipoNullExpectTipoNull() {
      AusenciaDto src = new AusenciaDto();
      src.setIdOrigen("ORIG-1");
      src.setTipo(null);

      AusenciasResultItemDto result = mapper.toAusenciasResultItemDto(src);

      assertThat(result.getTipo()).isNull();
    }
  }

  @Nested
  class ToAusenciasResultItemDtoList {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      AusenciaDto first = new AusenciaDto();
      first.setIdOrigen("ORIG-A");
      first.setIdEmpleado("EMP-A");
      first.setTipo(AusenciaDto.TipoEnum._1);
      first.setFechaInicio(FECHA_INICIO_UTC);
      first.setFechaFin(FECHA_FIN_UTC);
      AusenciaDto second = new AusenciaDto();
      second.setIdOrigen("ORIG-B");
      second.setIdEmpleado("EMP-B");
      second.setTipo(AusenciaDto.TipoEnum._2);
      second.setFechaInicio(FECHA_INICIO_UTC);
      second.setFechaFin(FECHA_FIN_UTC);

      List<AusenciasResultItemDto> result = mapper.toAusenciasResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdorigen()).isEqualTo("ORIG-A");
      assertThat(result.get(0).getTipo()).isEqualTo("1");
      assertThat(result.get(1).getIdorigen()).isEqualTo("ORIG-B");
      assertThat(result.get(1).getTipo()).isEqualTo("2");
    }

    @Test
    void whenNullListExpectNull() {
      List<AusenciasResultItemDto> result = mapper.toAusenciasResultItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<AusenciasResultItemDto> result = mapper.toAusenciasResultItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToAusenciasResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      AusenciaDto item = new AusenciaDto();
      item.setIdOrigen("ORIG-X");
      item.setIdEmpleado("EMP-X");
      item.setTipo(AusenciaDto.TipoEnum._1);
      item.setFechaInicio(FECHA_INICIO_UTC);
      item.setFechaFin(FECHA_FIN_UTC);
      SearchAusenciasResponseDto src = new SearchAusenciasResponseDto();
      src.setData(List.of(item));

      AusenciasResponseDto result = mapper.toAusenciasResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdorigen()).isEqualTo("ORIG-X");
      assertThat(result.getData().get(0).getTipo()).isEqualTo("1");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      AusenciasResponseDto result = mapper.toAusenciasResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchAusenciasResponseDto src = new SearchAusenciasResponseDto();
      src.setData(List.of());

      AusenciasResponseDto result = mapper.toAusenciasResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class TipoEnumToString {

    @Test
    void whenNullExpectNull() {
      String result = mapper.tipoEnumToString(null);

      assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("tipoEnumProvider")
    void whenEnumValueExpectStringRepresentation(AusenciaDto.TipoEnum input, String expected) {
      String result = mapper.tipoEnumToString(input);

      assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> tipoEnumProvider() {
      return Stream.of(
          Arguments.of(AusenciaDto.TipoEnum._1, "1"),
          Arguments.of(AusenciaDto.TipoEnum._2, "2"));
    }
  }

  @Nested
  class ToSearchTiendasIncomeRequestDto {

    @Test
    void whenRequestPopulatedWithItemsExpectFieldsMapped() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdLugarTrabajo("T001");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdLugarTrabajo("T002");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(List.of(item1, item2));
      TiendasRequestDto src = new TiendasRequestDto();
      src.setData(filter);

      SearchTiendasIncomeRequestDto result = mapper.toSearchTiendasIncomeRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdLugaresTrabajo()).containsExactly("T001", "T002");
    }

    @Test
    void whenRequestNullExpectEmptyDto() {
      SearchTiendasIncomeRequestDto result = mapper.toSearchTiendasIncomeRequestDto((TiendasRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getFechaInicio()).isNull();
      assertThat(result.getFechaFin()).isNull();
    }

    @Test
    void whenRequestDataNullExpectEmptyDto() {
      TiendasRequestDto src = new TiendasRequestDto();
      src.setData(null);

      SearchTiendasIncomeRequestDto result = mapper.toSearchTiendasIncomeRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getFechaInicio()).isNull();
      assertThat(result.getFechaFin()).isNull();
    }

    @Test
    void whenItemNullExpectNoIdLugaresTrabajo() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(null);
      TiendasRequestDto src = new TiendasRequestDto();
      src.setData(filter);

      SearchTiendasIncomeRequestDto result = mapper.toSearchTiendasIncomeRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdLugaresTrabajo()).isEmpty();
    }
  }

  @Nested
  class ToGenericTiendaResultItemDto {

    @Test
    void whenSourcePopulatedExpectMappedFieldsAndIgnoredFields() {
      TiendaIncomeDto src = new TiendaIncomeDto();
      src.setIdLugarTrabajo("T123");
      src.setIdLugarTrabajoMtu("MTU-99");
      src.setFechaInicio(FECHA_INICIO_UTC);
      src.setFechaFin(FECHA_FIN_UTC);
      src.setEsComisionable(true);

      GenericTiendaResultItemDto result = mapper.toGenericTiendaResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdLugarTrabajo()).isEqualTo("T123");
      assertThat(result.getIdLugarTrabajoMtu()).isEqualTo("MTU-99");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN);
      assertThat(result.getEsComisionable()).isTrue();
      assertThat(result.getIdPais()).isNull();
      assertThat(result.getIdProvincia()).isNull();
      assertThat(result.getCalcula()).isNull();
      assertThat(result.getIdCadena()).isNull();
      assertThat(result.getIdOrigen()).isNull();
      assertThat(result.getIdEmpresa()).isNull();
      assertThat(result.getIdTiendaMtu()).isNull();
      assertThat(result.getFechaFestivo()).isNull();
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      GenericTiendaResultItemDto result = mapper.toGenericTiendaResultItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToGenericTiendaResultItemDtoList {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      TiendaIncomeDto first = new TiendaIncomeDto();
      first.setIdLugarTrabajo("T1");
      first.setIdLugarTrabajoMtu("MTU-1");
      first.setFechaInicio(FECHA_INICIO_UTC);
      first.setFechaFin(FECHA_FIN_UTC);
      first.setEsComisionable(true);
      TiendaIncomeDto second = new TiendaIncomeDto();
      second.setIdLugarTrabajo("T2");
      second.setIdLugarTrabajoMtu("MTU-2");
      second.setFechaInicio(FECHA_INICIO_UTC);
      second.setFechaFin(FECHA_FIN_UTC);
      second.setEsComisionable(false);

      List<GenericTiendaResultItemDto> result = mapper.toGenericTiendaResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdLugarTrabajo()).isEqualTo("T1");
      assertThat(result.get(0).getEsComisionable()).isTrue();
      assertThat(result.get(1).getIdLugarTrabajo()).isEqualTo("T2");
      assertThat(result.get(1).getEsComisionable()).isFalse();
    }

    @Test
    void whenNullListExpectNull() {
      List<GenericTiendaResultItemDto> result = mapper.toGenericTiendaResultItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<GenericTiendaResultItemDto> result = mapper.toGenericTiendaResultItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToTiendasResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      TiendaIncomeDto item = new TiendaIncomeDto();
      item.setIdLugarTrabajo("T123");
      item.setIdLugarTrabajoMtu("MTU-5");
      item.setFechaInicio(FECHA_INICIO_UTC);
      item.setFechaFin(FECHA_FIN_UTC);
      item.setEsComisionable(true);
      SearchTiendasIncomeResponseDto src = new SearchTiendasIncomeResponseDto();
      src.setData(List.of(item));

      TiendasResponseDto result = mapper.toTiendasResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdLugarTrabajo()).isEqualTo("T123");
      assertThat(result.getData().get(0).getEsComisionable()).isTrue();
      assertThat(result.getData().get(0).getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getData().get(0).getFechaFin()).isEqualTo(FECHA_FIN);
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      TiendasResponseDto result = mapper.toTiendasResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchTiendasIncomeResponseDto src = new SearchTiendasIncomeResponseDto();
      src.setData(List.of());

      TiendasResponseDto result = mapper.toTiendasResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class ToSearchConfVentaOnlineRequestDtoFromFilter {

    @Test
    void whenFilterPopulatedExpectFieldsMapped() {
      GenericFilterDto src = new GenericFilterDto();
      src.setIdOrigen("ORIG-1");
      src.setIdCadena("CAD-1");
      src.setFechaInicio(FECHA_INICIO);
      src.setFechaFin(FECHA_FIN);

      SearchConfVentaOnlineRequestDto result = mapper.toSearchConfVentaOnlineRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdCadena()).isEqualTo("CAD-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
    }

    @Test
    void whenFilterNullExpectNull() {
      SearchConfVentaOnlineRequestDto result = mapper.toSearchConfVentaOnlineRequestDto((GenericFilterDto) null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToSearchConfVentaOnlineRequestDtoFromRequest {

    @Test
    void whenRequestPopulatedExpectDataUnwrappedAndMapped() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-2");
      filter.setIdCadena("CAD-2");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      ConfiguracionVentaOnlineRequestDto src = new ConfiguracionVentaOnlineRequestDto();
      src.setData(filter);

      SearchConfVentaOnlineRequestDto result = mapper.toSearchConfVentaOnlineRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-2");
      assertThat(result.getIdCadena()).isEqualTo("CAD-2");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
    }

    @Test
    void whenRequestDataNullExpectNull() {
      ConfiguracionVentaOnlineRequestDto src = new ConfiguracionVentaOnlineRequestDto();
      src.setData(null);

      SearchConfVentaOnlineRequestDto result = mapper.toSearchConfVentaOnlineRequestDto(src);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToConfiguracionVentaOnlineResultItemDto {

    @Test
    void whenSourcePopulatedExpectFieldsMapped() {
      ConfiguracionVentaOnlineDto src = new ConfiguracionVentaOnlineDto();
      src.setIdOrigen("ORIG-3");
      src.setIdAgrupacion("AGRUP-1");
      src.setIdConcepto("CONC-1");
      src.setPorcentaje("50.5");
      src.setFechaInicio(FECHA_INICIO_UTC);
      src.setFechaFin(FECHA_FIN_UTC);

      ConfiguracionVentaOnlineResultItemDto result = mapper.toConfiguracionVentaOnlineResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-3");
      assertThat(result.getIdAgrupacion()).isEqualTo("AGRUP-1");
      assertThat(result.getIdConcepto()).isEqualTo("CONC-1");
      assertThat(result.getPorcentaje()).isEqualTo("50.5");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN);
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      ConfiguracionVentaOnlineResultItemDto result = mapper.toConfiguracionVentaOnlineResultItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToConfiguracionVentaOnlineResultItemDtoList {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      ConfiguracionVentaOnlineDto first = new ConfiguracionVentaOnlineDto();
      first.setIdOrigen("ORIG-A");
      first.setIdAgrupacion("AGRUP-A");
      first.setIdConcepto("CONC-A");
      first.setPorcentaje("10");
      first.setFechaInicio(FECHA_INICIO_UTC);
      first.setFechaFin(FECHA_FIN_UTC);
      ConfiguracionVentaOnlineDto second = new ConfiguracionVentaOnlineDto();
      second.setIdOrigen("ORIG-B");
      second.setIdAgrupacion("AGRUP-B");
      second.setIdConcepto("CONC-B");
      second.setPorcentaje("20");
      second.setFechaInicio(FECHA_INICIO_UTC);
      second.setFechaFin(FECHA_FIN_UTC);

      List<ConfiguracionVentaOnlineResultItemDto> result = mapper.toConfiguracionVentaOnlineResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdOrigen()).isEqualTo("ORIG-A");
      assertThat(result.get(0).getIdConcepto()).isEqualTo("CONC-A");
      assertThat(result.get(1).getIdOrigen()).isEqualTo("ORIG-B");
      assertThat(result.get(1).getIdConcepto()).isEqualTo("CONC-B");
    }

    @Test
    void whenNullListExpectNull() {
      List<ConfiguracionVentaOnlineResultItemDto> result = mapper.toConfiguracionVentaOnlineResultItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<ConfiguracionVentaOnlineResultItemDto> result = mapper.toConfiguracionVentaOnlineResultItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToConfiguracionVentaOnlineResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      ConfiguracionVentaOnlineDto item = new ConfiguracionVentaOnlineDto();
      item.setIdOrigen("ORIG-X");
      item.setIdAgrupacion("AGRUP-X");
      item.setIdConcepto("CONC-X");
      item.setPorcentaje("75");
      item.setFechaInicio(FECHA_INICIO_UTC);
      item.setFechaFin(FECHA_FIN_UTC);
      SearchConfVentaOnlineResponseDto src = new SearchConfVentaOnlineResponseDto();
      src.setData(List.of(item));

      ConfiguracionVentaOnlineResponseDto result = mapper.toConfiguracionVentaOnlineResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-X");
      assertThat(result.getData().get(0).getIdConcepto()).isEqualTo("CONC-X");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      ConfiguracionVentaOnlineResponseDto result = mapper.toConfiguracionVentaOnlineResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchConfVentaOnlineResponseDto src = new SearchConfVentaOnlineResponseDto();
      src.setData(List.of());

      ConfiguracionVentaOnlineResponseDto result = mapper.toConfiguracionVentaOnlineResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }
}
