package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.AusenciaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.CoeficienteJornadaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.ConfiguracionProductoVentaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.ConfiguracionVentaOnlineDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpleadoDesplazadoDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpleadoPresenciaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpresaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.FlagCalculaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.OrigenDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.PresenciaManualDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.PresupuestoWlocDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchCoeficienteJornadaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchCoeficienteJornadaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfProductoVentaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfProductoVentaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosDesplazadosRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosDesplazadosResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchFlagCalculaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchFlagCalculaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasIncomeRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasIncomeResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SeccionPresenciaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.TiendaIncomeDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.TiendaOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
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

  @Nested
  class ToSearchConfProductoVentaRequestDtoFromFilter {

    @Test
    void whenFilterPopulatedExpectIdOrigenMapped() {
      GenericFilterDto src = new GenericFilterDto();
      src.setIdOrigen("ORIG-1");

      SearchConfProductoVentaRequestDto result = mapper.toSearchConfProductoVentaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
    }

    @Test
    void whenFilterNullExpectNull() {
      SearchConfProductoVentaRequestDto result = mapper.toSearchConfProductoVentaRequestDto((GenericFilterDto) null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToSearchConfProductoVentaRequestDtoFromRequest {

    @Test
    void whenRequestPopulatedExpectDataUnwrappedAndMapped() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-2");
      ConfiguracionProductoVentaRequestDto src = new ConfiguracionProductoVentaRequestDto();
      src.setData(filter);

      SearchConfProductoVentaRequestDto result = mapper.toSearchConfProductoVentaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-2");
    }

    @Test
    void whenRequestDataNullExpectNull() {
      ConfiguracionProductoVentaRequestDto src = new ConfiguracionProductoVentaRequestDto();
      src.setData(null);

      SearchConfProductoVentaRequestDto result = mapper.toSearchConfProductoVentaRequestDto(src);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToConfiguracionProductoVentaResultItemDtoTest {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndAuditFieldsIgnored() {
      ConfiguracionProductoVentaDto src = new ConfiguracionProductoVentaDto();
      src.setIdOrigen("ORIG-1");
      src.setIdProducto("42");

      ConfiguracionProductoVentaResultItemDto result = mapper.toConfiguracionProductoVentaResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdProducto()).isEqualTo(42);
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      ConfiguracionProductoVentaResultItemDto result = mapper.toConfiguracionProductoVentaResultItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToConfiguracionProductoVentaResultItemDtoListTest {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      ConfiguracionProductoVentaDto first = new ConfiguracionProductoVentaDto();
      first.setIdOrigen("ORIG-A");
      first.setIdProducto("1");
      ConfiguracionProductoVentaDto second = new ConfiguracionProductoVentaDto();
      second.setIdOrigen("ORIG-B");
      second.setIdProducto("2");

      List<ConfiguracionProductoVentaResultItemDto> result = mapper.toConfiguracionProductoVentaResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdOrigen()).isEqualTo("ORIG-A");
      assertThat(result.get(0).getIdProducto()).isEqualTo(1);
      assertThat(result.get(1).getIdOrigen()).isEqualTo("ORIG-B");
      assertThat(result.get(1).getIdProducto()).isEqualTo(2);
    }

    @Test
    void whenNullListExpectNull() {
      List<ConfiguracionProductoVentaResultItemDto> result = mapper.toConfiguracionProductoVentaResultItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<ConfiguracionProductoVentaResultItemDto> result = mapper.toConfiguracionProductoVentaResultItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToConfiguracionProductoVentaResponseDtoTest {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      ConfiguracionProductoVentaDto item = new ConfiguracionProductoVentaDto();
      item.setIdOrigen("ORIG-X");
      item.setIdProducto("99");
      SearchConfProductoVentaResponseDto src = new SearchConfProductoVentaResponseDto();
      src.setData(List.of(item));

      ConfiguracionProductoVentaResponseDto result = mapper.toConfiguracionProductoVentaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-X");
      assertThat(result.getData().get(0).getIdProducto()).isEqualTo(99);
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      ConfiguracionProductoVentaResponseDto result = mapper.toConfiguracionProductoVentaResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchConfProductoVentaResponseDto src = new SearchConfProductoVentaResponseDto();
      src.setData(List.of());

      ConfiguracionProductoVentaResponseDto result = mapper.toConfiguracionProductoVentaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class ToSearchFlagCalculaRequestDto {

    @Test
    void whenRequestNullExpectEmptyRequest() {
      SearchFlagCalculaRequestDto result = mapper.toSearchFlagCalculaRequestDto((FlagCalculaRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isNull();
      assertThat(result.getIdEmpresa()).isNull();
    }

    @Test
    void whenRequestDataNullExpectEmptyRequest() {
      FlagCalculaRequestDto src = new FlagCalculaRequestDto();
      src.setData(null);

      SearchFlagCalculaRequestDto result = mapper.toSearchFlagCalculaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isNull();
      assertThat(result.getIdEmpresa()).isNull();
    }

    @Test
    void whenFullRequestExpectAllFieldsMapped() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdLugarTrabajo("LT-1");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdLugarTrabajo("LT-2");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setIdsEmpresa(List.of("EMP-1", "EMP-2"));
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(List.of(item1, item2));
      FlagCalculaRequestDto src = new FlagCalculaRequestDto();
      src.setData(filter);

      SearchFlagCalculaRequestDto result = mapper.toSearchFlagCalculaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdEmpresa()).isEqualTo("EMP-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdLugaresTrabajo()).containsExactly("LT-1", "LT-2");
    }

    @Test
    void whenEmptyIdsEmpresaExpectIdEmpresaNotSet() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setIdsEmpresa(List.of());
      FlagCalculaRequestDto src = new FlagCalculaRequestDto();
      src.setData(filter);

      SearchFlagCalculaRequestDto result = mapper.toSearchFlagCalculaRequestDto(src);

      assertThat(result.getIdEmpresa()).isNull();
    }

    @Test
    void whenEmptyItemsExpectIdLugaresTrabajoNotSet() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setItem(List.of());
      FlagCalculaRequestDto src = new FlagCalculaRequestDto();
      src.setData(filter);

      SearchFlagCalculaRequestDto result = mapper.toSearchFlagCalculaRequestDto(src);

      assertThat(result.getIdLugaresTrabajo()).isEmpty();
    }
  }

  @Nested
  class CalculaEnumToBoolean {

    @Test
    void whenEnum1ExpectTrue() {
      Boolean result = mapper.calculaEnumToBoolean(FlagCalculaDto.CalculaEnum._1);

      assertThat(result).isTrue();
    }

    @Test
    void whenEnum0ExpectFalse() {
      Boolean result = mapper.calculaEnumToBoolean(FlagCalculaDto.CalculaEnum._0);

      assertThat(result).isFalse();
    }

    @Test
    void whenNullExpectNull() {
      Boolean result = mapper.calculaEnumToBoolean(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToSearchCoeficienteJornadaRequestDto {

    @Test
    void whenRequestPopulatedWithItemsExpectFieldsMapped() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdEmpleado("EMP-001");
      item1.setOrEmpleado("1");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdEmpleado("EMP-002");
      item2.setOrEmpleado("2");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(List.of(item1, item2));
      CoefJornadaRequestDto src = new CoefJornadaRequestDto();
      src.setData(filter);

      SearchCoeficienteJornadaRequestDto result = mapper.toSearchCoeficienteJornadaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getEmpleados()).hasSize(2);
      assertThat(result.getEmpleados().get(0).getIdEmpleado()).isEqualTo("EMP-001");
      assertThat(result.getEmpleados().get(0).getIdOrdinalEmpleado()).isEqualTo("1");
      assertThat(result.getEmpleados().get(1).getIdEmpleado()).isEqualTo("EMP-002");
      assertThat(result.getEmpleados().get(1).getIdOrdinalEmpleado()).isEqualTo("2");
    }

    @Test
    void whenRequestNullExpectEmptyDto() {
      SearchCoeficienteJornadaRequestDto result = mapper.toSearchCoeficienteJornadaRequestDto((CoefJornadaRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isNull();
      assertThat(result.getFechaInicio()).isNull();
      assertThat(result.getFechaFin()).isNull();
    }

    @Test
    void whenRequestDataNullExpectEmptyDto() {
      CoefJornadaRequestDto src = new CoefJornadaRequestDto();
      src.setData(null);

      SearchCoeficienteJornadaRequestDto result = mapper.toSearchCoeficienteJornadaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isNull();
      assertThat(result.getFechaInicio()).isNull();
      assertThat(result.getFechaFin()).isNull();
    }

    @Test
    void whenItemNullExpectNoEmpleados() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(null);
      CoefJornadaRequestDto src = new CoefJornadaRequestDto();
      src.setData(filter);

      SearchCoeficienteJornadaRequestDto result = mapper.toSearchCoeficienteJornadaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getEmpleados()).isNullOrEmpty();
    }

    @Test
    void whenItemEmptyExpectNoEmpleados() {
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(List.of());
      CoefJornadaRequestDto src = new CoefJornadaRequestDto();
      src.setData(filter);

      SearchCoeficienteJornadaRequestDto result = mapper.toSearchCoeficienteJornadaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getEmpleados()).isNullOrEmpty();
    }
  }

  @Nested
  class ToFlagCalculaItemDto {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndCalculaConverted() {
      FlagCalculaDto src = new FlagCalculaDto();
      src.setIdLugarTrabajo("T123");
      src.setIdLugarTrabajoMtu("MTU-1");
      src.setFechaInicio(FECHA_INICIO_UTC);
      src.setFechaFin(FECHA_FIN_UTC);
      src.setCalcula(FlagCalculaDto.CalculaEnum._1);
      src.setEsComisionable(true);

      GenericTiendaResultItemDto result = mapper.toFlagCalculaItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdLugarTrabajo()).isEqualTo("T123");
      assertThat(result.getIdLugarTrabajoMtu()).isEqualTo("MTU-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN);
      assertThat(result.getCalcula()).isTrue();
      assertThat(result.getEsComisionable()).isTrue();
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
    }

    @Test
    void whenSourceNullExpectNull() {
      GenericTiendaResultItemDto result = mapper.toFlagCalculaItemDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenCalculaEnum0ExpectFalse() {
      FlagCalculaDto src = new FlagCalculaDto();
      src.setCalcula(FlagCalculaDto.CalculaEnum._0);

      GenericTiendaResultItemDto result = mapper.toFlagCalculaItemDto(src);

      assertThat(result.getCalcula()).isFalse();
    }
  }

  @Nested
  class ToGenericEmpleadoResultItemDtoFromCoeficienteJornada {

    @Test
    void whenSourcePopulatedExpectFieldsMappedAndRenamed() {
      CoeficienteJornadaDto src = new CoeficienteJornadaDto();
      src.setIdEmpleado("EMP-1");
      src.setIdOrdinalEmpleado("2");
      src.setFechaInicioCompleta(FECHA_INICIO_UTC);
      src.setFechaFinCompleta(FECHA_FIN_UTC);
      src.setFechaInicioParcial(FECHA_INICIO_UTC);
      src.setFechaFinParcial(FECHA_FIN_UTC);
      src.setCoeficienteJornada("0.75");

      GenericEmpleadoResultItemDto result = mapper.toGenericEmpleadoResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(result.getOrEmpleado()).isEqualTo("2");
      assertThat(result.getFechaInicioCom()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFinCom()).isEqualTo(FECHA_FIN);
      assertThat(result.getFechaInicioPar()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFinPar()).isEqualTo(FECHA_FIN);
      assertThat(result.getCoefJornada()).isEqualTo("0.75");
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.isM4AutoGeneratedToDelete()).isFalse();
      assertThat(result.getFecha()).isNull();
      assertThat(result.getFechaInicio()).isNull();
      assertThat(result.getFechaFin()).isNull();
      assertThat(result.getIdOrigen()).isNull();
      assertThat(result.getIdCadena()).isNull();
      assertThat(result.getIdEmpresa()).isNull();
      assertThat(result.getIdPais()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      GenericEmpleadoResultItemDto result = mapper.toGenericEmpleadoResultItemDto((CoeficienteJornadaDto) null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToGenericEmpleadoResultItemDtoListFromCoeficienteJornada {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      CoeficienteJornadaDto first = new CoeficienteJornadaDto();
      first.setIdEmpleado("EMP-A");
      first.setIdOrdinalEmpleado("1");
      first.setCoeficienteJornada("0.5");
      first.setFechaInicioCompleta(FECHA_INICIO_UTC);
      first.setFechaFinCompleta(FECHA_FIN_UTC);
      CoeficienteJornadaDto second = new CoeficienteJornadaDto();
      second.setIdEmpleado("EMP-B");
      second.setIdOrdinalEmpleado("2");
      second.setCoeficienteJornada("1.0");
      second.setFechaInicioCompleta(FECHA_INICIO_UTC);
      second.setFechaFinCompleta(FECHA_FIN_UTC);

      List<GenericEmpleadoResultItemDto> result = mapper.toGenericEmpleadoResultItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdEmpleado()).isEqualTo("EMP-A");
      assertThat(result.get(0).getOrEmpleado()).isEqualTo("1");
      assertThat(result.get(0).getCoefJornada()).isEqualTo("0.5");
      assertThat(result.get(1).getIdEmpleado()).isEqualTo("EMP-B");
      assertThat(result.get(1).getOrEmpleado()).isEqualTo("2");
      assertThat(result.get(1).getCoefJornada()).isEqualTo("1.0");
    }

    @Test
    void whenNullListExpectNull() {
      List<GenericEmpleadoResultItemDto> result = mapper.toGenericEmpleadoResultItemDtoList((List<CoeficienteJornadaDto>) null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<GenericEmpleadoResultItemDto> result = mapper.toGenericEmpleadoResultItemDtoList(List.<CoeficienteJornadaDto>of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToFlagCalculaItemDtoList {

    @Test
    void whenListPopulatedExpectAllItemsMapped() {
      FlagCalculaDto first = new FlagCalculaDto();
      first.setIdLugarTrabajo("T1");
      first.setCalcula(FlagCalculaDto.CalculaEnum._1);
      first.setFechaInicio(FECHA_INICIO_UTC);
      first.setFechaFin(FECHA_FIN_UTC);
      FlagCalculaDto second = new FlagCalculaDto();
      second.setIdLugarTrabajo("T2");
      second.setCalcula(FlagCalculaDto.CalculaEnum._0);
      second.setFechaInicio(FECHA_INICIO_UTC);
      second.setFechaFin(FECHA_FIN_UTC);

      List<GenericTiendaResultItemDto> result = mapper.toFlagCalculaItemDtoList(List.of(first, second));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdLugarTrabajo()).isEqualTo("T1");
      assertThat(result.get(0).getCalcula()).isTrue();
      assertThat(result.get(1).getIdLugarTrabajo()).isEqualTo("T2");
      assertThat(result.get(1).getCalcula()).isFalse();
    }

    @Test
    void whenNullListExpectNull() {
      List<GenericTiendaResultItemDto> result = mapper.toFlagCalculaItemDtoList(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyListExpectEmptyList() {
      List<GenericTiendaResultItemDto> result = mapper.toFlagCalculaItemDtoList(List.of());

      assertThat(result).isEmpty();
    }
  }

  @Nested
  class ToFlagCalculaResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      FlagCalculaDto item = new FlagCalculaDto();
      item.setIdLugarTrabajo("T123");
      item.setCalcula(FlagCalculaDto.CalculaEnum._1);
      item.setFechaInicio(FECHA_INICIO_UTC);
      item.setFechaFin(FECHA_FIN_UTC);
      SearchFlagCalculaResponseDto src = new SearchFlagCalculaResponseDto();
      src.setData(List.of(item));

      FlagCalculaResponseDto result = mapper.toFlagCalculaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdLugarTrabajo()).isEqualTo("T123");
      assertThat(result.getData().get(0).getCalcula()).isTrue();
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      FlagCalculaResponseDto result = mapper.toFlagCalculaResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchFlagCalculaResponseDto src = new SearchFlagCalculaResponseDto();
      src.setData(List.of());

      FlagCalculaResponseDto result = mapper.toFlagCalculaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class ToCoefJornadaResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      CoeficienteJornadaDto item = new CoeficienteJornadaDto();
      item.setIdEmpleado("EMP-X");
      item.setIdOrdinalEmpleado("1");
      item.setCoeficienteJornada("0.8");
      item.setFechaInicioCompleta(FECHA_INICIO_UTC);
      item.setFechaFinCompleta(FECHA_FIN_UTC);
      SearchCoeficienteJornadaResponseDto src = new SearchCoeficienteJornadaResponseDto();
      src.setData(List.of(item));

      CoefJornadaResponseDto result = mapper.toCoefJornadaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdEmpleado()).isEqualTo("EMP-X");
      assertThat(result.getData().get(0).getOrEmpleado()).isEqualTo("1");
      assertThat(result.getData().get(0).getCoefJornada()).isEqualTo("0.8");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      CoefJornadaResponseDto result = mapper.toCoefJornadaResponseDto(null);

      assertThat(result).isNull();
    }

    @Test
    void whenEmptyDataExpectEmptyList() {
      SearchCoeficienteJornadaResponseDto src = new SearchCoeficienteJornadaResponseDto();
      src.setData(List.of());

      CoefJornadaResponseDto result = mapper.toCoefJornadaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
      assertThat(result.getPage()).isNull();
    }
  }

  @Nested
  class ToSearchPresenciaManualRequestDto {

    @Test
    void whenRequestPopulatedExpectAllFilterFieldsMapped() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdLugarTrabajo("T001");
      item1.setIdEmpleado("EMP-1");
      item1.setIdTipoHora("3");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdLugarTrabajo("T002");
      item2.setIdEmpleado("EMP-2");
      item2.setIdTipoHora("4");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setIdsEmpresa(List.of("SOC-1", "SOC-2"));
      filter.setItem(List.of(item1, item2));
      PresenciaManualRequestDto src = new PresenciaManualRequestDto();
      src.setData(filter);

      SearchPresenciaManualRequestDto result = mapper.toSearchPresenciaManualRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdEmpresas()).containsExactly("SOC-1", "SOC-2");
      assertThat(result.getIdLugaresTrabajo()).containsExactly("T001", "T002");
      assertThat(result.getIdEmpleados()).containsExactly("EMP-1", "EMP-2");
      assertThat(result.getIdTiposHora()).containsExactly("3", "4");
    }

    @Test
    void whenRequestDataNullExpectRequestWithEmptyIdOrigen() {
      PresenciaManualRequestDto src = new PresenciaManualRequestDto();
      src.setData(null);

      SearchPresenciaManualRequestDto result = mapper.toSearchPresenciaManualRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }

    @Test
    void whenRequestNullExpectRequestWithEmptyIdOrigen() {
      SearchPresenciaManualRequestDto result = mapper.toSearchPresenciaManualRequestDto((PresenciaManualRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }
  }

  @Nested
  class ToPresenciaManualResponseDto {

    @Test
    void whenResponseWithSectionsExpectFlattenedItems() {
      SeccionPresenciaDto seccion1 = new SeccionPresenciaDto();
      seccion1.setIdSeccion("SEC-1");
      seccion1.setMinutos(30);
      SeccionPresenciaDto seccion2 = new SeccionPresenciaDto();
      seccion2.setIdSeccion("SEC-2");
      seccion2.setMinutos(60);
      PresenciaManualDto record = new PresenciaManualDto();
      record.setIdEmpleado("EMP-1");
      record.setIdOrdinalEmpleado("2");
      record.setIdEmpleadoLocal("LOCAL-1");
      record.setIdOrigen("ORIG-1");
      record.setIdEmpresa("SOC-1");
      record.setIdCadena("CAD-1");
      record.setIdLugarTrabajo("T001");
      record.setIdLugarTrabajoMtu("MTU-1");
      record.setIdTipoHora("5");
      record.setFechaPresencia(FECHA_INICIO_UTC);
      record.setSecciones(List.of(seccion1, seccion2));
      SearchPresenciaManualResponseDto src = new SearchPresenciaManualResponseDto();
      src.setData(List.of(record));

      PresenciaManualResponseDto result = mapper.toPresenciaManualResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(2);
      GenericEmpleadoResultItemDto first = result.getData().get(0);
      assertThat(first.getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(first.getOrEmpleado()).isEqualTo("2");
      assertThat(first.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(first.getIdLugarTrabajo()).isEqualTo("T001");
      assertThat(first.getFecha()).isEqualTo(FECHA_INICIO);
      assertThat(first.getIdTipoHora()).isEqualTo(5);
      assertThat(first.getIdSeccion()).isEqualTo("SEC-1");
      assertThat(first.getMinutos()).isEqualTo("30");
      GenericEmpleadoResultItemDto second = result.getData().get(1);
      assertThat(second.getIdSeccion()).isEqualTo("SEC-2");
      assertThat(second.getMinutos()).isEqualTo("60");
    }

    @Test
    void whenResponseWithEmptySectionsExpectOneItemWithNullSeccionAndMinutos() {
      PresenciaManualDto record = new PresenciaManualDto();
      record.setIdEmpleado("EMP-1");
      record.setIdOrigen("ORIG-1");
      record.setSecciones(List.of());
      SearchPresenciaManualResponseDto src = new SearchPresenciaManualResponseDto();
      src.setData(List.of(record));

      PresenciaManualResponseDto result = mapper.toPresenciaManualResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdSeccion()).isNull();
      assertThat(result.getData().get(0).getMinutos()).isNull();
    }

    @Test
    void whenResponseNullExpectEmptyResponse() {
      PresenciaManualResponseDto result = mapper.toPresenciaManualResponseDto(null);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isNull();
    }
  }

  @Nested
  class ToSearchEmpleadosDesplazadosRequestDto {

    @Test
    void whenRequestPopulatedExpectAllFilterFieldsMapped() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdLugarTrabajo("T001");
      item1.setIdEmpleado("EMP-1");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdLugarTrabajo("T002");
      item2.setIdEmpleado("EMP-2");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setIdsEmpresa(List.of("SOC-1", "SOC-2"));
      filter.setItem(List.of(item1, item2));
      EmpleadosDesplazamientoRequestDto src = new EmpleadosDesplazamientoRequestDto();
      src.setData(filter);

      SearchEmpleadosDesplazadosRequestDto result = mapper.toSearchEmpleadosDesplazadosRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdEmpresas()).containsExactly("SOC-1", "SOC-2");
      assertThat(result.getIdLugaresTrabajo()).containsExactly("T001", "T002");
      assertThat(result.getIdEmpleados()).containsExactly("EMP-1", "EMP-2");
    }

    @Test
    void whenRequestDataNullExpectRequestWithEmptyIdOrigen() {
      EmpleadosDesplazamientoRequestDto src = new EmpleadosDesplazamientoRequestDto();
      src.setData(null);

      SearchEmpleadosDesplazadosRequestDto result = mapper.toSearchEmpleadosDesplazadosRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }

    @Test
    void whenRequestNullExpectRequestWithEmptyIdOrigen() {
      SearchEmpleadosDesplazadosRequestDto result = mapper.toSearchEmpleadosDesplazadosRequestDto((EmpleadosDesplazamientoRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }
  }

  @Nested
  class ToEmpleadoDesplazadoItemDto {

    @Test
    void whenSourcePopulatedExpectMappedFieldsAndIgnoredFieldsNull() {
      EmpleadoDesplazadoDto src = new EmpleadoDesplazadoDto();
      src.setIdEmpleado("EMP-1");
      src.setIdEmpleadoLocal("LOCAL-1");
      src.setIdLugarTrabajo("T001");
      src.setIdLugarTrabajoMtu("MTU-1");
      src.setIdEmpresa("SOC-1");
      src.setIdOrigen("ORIG-1");

      GenericEmpleadoResultItemDto result = mapper.toEmpleadoDesplazadoItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(result.getIdEmpleadoLocal()).isEqualTo("LOCAL-1");
      assertThat(result.getIdLugarTrabajo()).isEqualTo("T001");
      assertThat(result.getIdLugarTrabajoMtu()).isEqualTo("MTU-1");
      assertThat(result.getIdEmpresa()).isEqualTo("SOC-1");
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      // Ignored fields
      assertThat(result.getM4AutoGeneratedRecordID()).isNull();
      assertThat(result.getFechaInicio()).isNull();
      assertThat(result.getFechaFin()).isNull();
      assertThat(result.getIdCadena()).isNull();
      assertThat(result.getIdPais()).isNull();
      assertThat(result.getOrEmpleado()).isNull();
      assertThat(result.getIdSeccion()).isNull();
      assertThat(result.getIdTipoHora()).isNull();
      assertThat(result.getCoefJornada()).isNull();
      assertThat(result.getImporte()).isNull();
      assertThat(result.getMinutos()).isNull();
      assertThat(result.getIdPuesto()).isNull();
    }

    @Test
    void whenSourceNullExpectNull() {
      GenericEmpleadoResultItemDto result = mapper.toEmpleadoDesplazadoItemDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToEmpleadoDesplazadoItemDtoList {

    @Test
    void whenListPopulatedExpectMappedItems() {
      EmpleadoDesplazadoDto item1 = new EmpleadoDesplazadoDto();
      item1.setIdEmpleado("EMP-1");
      item1.setIdOrigen("ORIG-1");
      EmpleadoDesplazadoDto item2 = new EmpleadoDesplazadoDto();
      item2.setIdEmpleado("EMP-2");
      item2.setIdOrigen("ORIG-2");

      List<GenericEmpleadoResultItemDto> result = mapper.toEmpleadoDesplazadoItemDtoList(List.of(item1, item2));

      assertThat(result).hasSize(2);
      assertThat(result.get(0).getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(result.get(1).getIdEmpleado()).isEqualTo("EMP-2");
    }

    @Test
    void whenListEmptyExpectEmptyList() {
      List<GenericEmpleadoResultItemDto> result = mapper.toEmpleadoDesplazadoItemDtoList(List.of());

      assertThat(result).isEmpty();
    }

    @Test
    void whenListNullExpectNull() {
      List<GenericEmpleadoResultItemDto> result = mapper.toEmpleadoDesplazadoItemDtoList(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToEmpleadosDesplazamientoResponseDto {

    @Test
    void whenResponsePopulatedExpectDataMappedAndPageIgnored() {
      EmpleadoDesplazadoDto item = new EmpleadoDesplazadoDto();
      item.setIdEmpleado("EMP-1");
      item.setIdOrigen("ORIG-1");
      SearchEmpleadosDesplazadosResponseDto src = new SearchEmpleadosDesplazadosResponseDto();
      src.setData(List.of(item));

      EmpleadosDesplazamientoResponseDto result = mapper.toEmpleadosDesplazamientoResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getPage()).isNull();
    }

    @Test
    void whenResponseEmptyDataExpectEmptyList() {
      SearchEmpleadosDesplazadosResponseDto src = new SearchEmpleadosDesplazadosResponseDto();
      src.setData(List.of());

      EmpleadosDesplazamientoResponseDto result = mapper.toEmpleadosDesplazamientoResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
    }

    @Test
    void whenResponseNullExpectNull() {
      EmpleadosDesplazamientoResponseDto result = mapper.toEmpleadosDesplazamientoResponseDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToSearchEmpleadosPresenciaRequestDto {

    @Test
    void whenRequestPopulatedExpectAllFilterFieldsMapped() {
      GenericFilterParametersDto item1 = new GenericFilterParametersDto();
      item1.setIdLugarTrabajo("T001");
      item1.setIdEmpleado("EMP-1");
      item1.setIdTipoHora("3");
      GenericFilterParametersDto item2 = new GenericFilterParametersDto();
      item2.setIdLugarTrabajo("T002");
      item2.setIdEmpleado("EMP-2");
      item2.setIdTipoHora("4");
      GenericFilterDto filter = new GenericFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setIdsEmpresa(List.of("SOC-1", "SOC-2"));
      filter.setItem(List.of(item1, item2));
      EmpleadosPresenciaRequestDto src = new EmpleadosPresenciaRequestDto();
      src.setData(filter);

      SearchEmpleadosPresenciaRequestDto result = mapper.toSearchEmpleadosPresenciaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdEmpresas()).containsExactly("SOC-1", "SOC-2");
      assertThat(result.getIdLugaresTrabajo()).containsExactly("T001", "T002");
      assertThat(result.getIdEmpleados()).containsExactly("EMP-1", "EMP-2");
      assertThat(result.getIdTiposHora()).containsExactly("3", "4");
    }

    @Test
    void whenRequestDataNullExpectRequestWithEmptyIdOrigen() {
      EmpleadosPresenciaRequestDto src = new EmpleadosPresenciaRequestDto();
      src.setData(null);

      SearchEmpleadosPresenciaRequestDto result = mapper.toSearchEmpleadosPresenciaRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }

    @Test
    void whenRequestNullExpectRequestWithEmptyIdOrigen() {
      SearchEmpleadosPresenciaRequestDto result = mapper.toSearchEmpleadosPresenciaRequestDto((EmpleadosPresenciaRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }
  }

  @Nested
  class ToEmpleadosPresenciaResponseDto {

    @Test
    void whenResponseWithDataExpectItemsMappedWithOrdinalRename() {
      EmpleadoPresenciaDto empleadoPresencia = new EmpleadoPresenciaDto();
      empleadoPresencia.setIdEmpleado("EMP-1");
      empleadoPresencia.setIdOrdinalEmpleado("2");
      empleadoPresencia.setIdEmpleadoLocal("LOCAL-1");
      empleadoPresencia.setIdOrigen("ORIG-1");
      empleadoPresencia.setIdEmpresa("SOC-1");
      empleadoPresencia.setIdLugarTrabajo("T001");
      empleadoPresencia.setIdLugarTrabajoMtu("MTU-1");
      SearchEmpleadosPresenciaResponseDto src = new SearchEmpleadosPresenciaResponseDto();
      src.setData(List.of(empleadoPresencia));

      EmpleadosPresenciaResponseDto result = mapper.toEmpleadosPresenciaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      GenericEmpleadoResultItemDto item = result.getData().get(0);
      assertThat(item.getIdEmpleado()).isEqualTo("EMP-1");
      assertThat(item.getOrEmpleado()).isEqualTo("2");
      assertThat(item.getIdEmpleadoLocal()).isEqualTo("LOCAL-1");
      assertThat(item.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(item.getIdEmpresa()).isEqualTo("SOC-1");
      assertThat(item.getIdLugarTrabajo()).isEqualTo("T001");
      assertThat(item.getIdLugarTrabajoMtu()).isEqualTo("MTU-1");
    }

    @Test
    void whenResponseWithEmptyDataExpectEmptyList() {
      SearchEmpleadosPresenciaResponseDto src = new SearchEmpleadosPresenciaResponseDto();
      src.setData(List.of());

      EmpleadosPresenciaResponseDto result = mapper.toEmpleadosPresenciaResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).isEmpty();
    }

    @Test
    void whenResponseNullExpectNull() {
      EmpleadosPresenciaResponseDto result = mapper.toEmpleadosPresenciaResponseDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class ToSearchPresupuestosWlocRequestDto {

    @Test
    void whenNullRequestExpectEmptyRequest() {
      SearchPresupuestosWlocRequestDto result = mapper.toSearchPresupuestosWlocRequestDto((PresupuestosWlocRequestDto) null);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }

    @Test
    void whenNullFilterExpectEmptyRequest() {
      PresupuestosWlocRequestDto src = new PresupuestosWlocRequestDto();
      src.setData(null);

      SearchPresupuestosWlocRequestDto result = mapper.toSearchPresupuestosWlocRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEmpty();
    }

    @Test
    void whenValidFilterWithItemsExpectListsExtracted() {
      PresupuestosWlocFilterParametersDto param1 = new PresupuestosWlocFilterParametersDto();
      param1.setIdLugarTrabajo("LT-1");
      param1.setIdTpPresupuesto("TP-1");
      param1.setIdEmpresa("EMP-1");
      PresupuestosWlocFilterParametersDto param2 = new PresupuestosWlocFilterParametersDto();
      param2.setIdLugarTrabajo("LT-2");
      param2.setIdTpPresupuesto("TP-2");
      param2.setIdEmpresa("EMP-2");
      PresupuestosWlocFilterDto filter = new PresupuestosWlocFilterDto();
      filter.setIdOrigen("ORIG-1");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      filter.setItem(List.of(param1, param2));
      PresupuestosWlocRequestDto src = new PresupuestosWlocRequestDto();
      src.setData(filter);

      SearchPresupuestosWlocRequestDto result = mapper.toSearchPresupuestosWlocRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdLugaresTrabajo()).containsExactly("LT-1", "LT-2");
      assertThat(result.getIdTiposPresupuesto()).containsExactly("TP-1", "TP-2");
      assertThat(result.getIdEmpresas()).containsExactly("EMP-1", "EMP-2");
    }

    @Test
    void whenFilterWithoutItemsExpectOnlyHeaderFieldsMapped() {
      PresupuestosWlocFilterDto filter = new PresupuestosWlocFilterDto();
      filter.setIdOrigen("ORIG-2");
      filter.setFechaInicio(FECHA_INICIO);
      filter.setFechaFin(FECHA_FIN);
      PresupuestosWlocRequestDto src = new PresupuestosWlocRequestDto();
      src.setData(filter);

      SearchPresupuestosWlocRequestDto result = mapper.toSearchPresupuestosWlocRequestDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-2");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO_UTC);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN_UTC);
      assertThat(result.getIdLugaresTrabajo()).isNullOrEmpty();
      assertThat(result.getIdTiposPresupuesto()).isNullOrEmpty();
      assertThat(result.getIdEmpresas()).isNullOrEmpty();
    }
  }

  @Nested
  class ToPresupuestosWlocResultItemDto {

    @Test
    void whenValidDtoExpectFieldsMapped() {
      PresupuestoWlocDto src = new PresupuestoWlocDto();
      src.setIdOrigen("ORIG-1");
      src.setIdEmpresa("EMP-1");
      src.setIdLugarTrabajo("LT-1");
      src.setIdSeccion("SEC-1");
      src.setIdTipoPresupuesto("TP-1");
      src.setBanda("B1");
      src.setOrdinal("1");
      src.setExcepcion("N");
      src.setImporteSinImpuestos(new BigDecimal("100.50"));
      src.setImporteConImpuestos(new BigDecimal("121.605"));
      src.setFechaInicio(FECHA_INICIO_UTC);
      src.setFechaFin(FECHA_FIN_UTC);

      PresupuestosWlocResultItemDto result = mapper.toPresupuestosWlocResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getIdEmpresa()).isEqualTo("EMP-1");
      assertThat(result.getIdLugarTrabajo()).isEqualTo("LT-1");
      assertThat(result.getIdSeccion()).isEqualTo("SEC-1");
      assertThat(result.getIdTpPresupuesto()).isEqualTo("TP-1");
      assertThat(result.getBanda()).isEqualTo("B1");
      assertThat(result.getOrdinal()).isEqualTo("1");
      assertThat(result.getExcepcion()).isEqualTo("N");
      assertThat(result.getImporteSinImpuestos()).isEqualTo("100.50");
      assertThat(result.getImporteConImpuestos()).isEqualTo("121.605");
      assertThat(result.getFechaInicio()).isEqualTo(FECHA_INICIO);
      assertThat(result.getFechaFin()).isEqualTo(FECHA_FIN);
    }

    @Test
    void whenNullAmountsExpectNullStrings() {
      PresupuestoWlocDto src = new PresupuestoWlocDto();
      src.setImporteSinImpuestos(null);
      src.setImporteConImpuestos(null);

      PresupuestosWlocResultItemDto result = mapper.toPresupuestosWlocResultItemDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getImporteSinImpuestos()).isNull();
      assertThat(result.getImporteConImpuestos()).isNull();
    }
  }

  @Nested
  class ToPresupuestosWlocResponseDto {

    @Test
    void whenValidResponseExpectDataMapped() {
      PresupuestoWlocDto item = new PresupuestoWlocDto();
      item.setIdOrigen("ORIG-1");
      item.setImporteSinImpuestos(new BigDecimal("50.00"));
      item.setImporteConImpuestos(new BigDecimal("60.50"));
      SearchPresupuestosWlocResponseDto src = new SearchPresupuestosWlocResponseDto();
      src.setData(List.of(item));

      PresupuestosWlocResponseDto result = mapper.toPresupuestosWlocResponseDto(src);

      assertThat(result).isNotNull();
      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdOrigen()).isEqualTo("ORIG-1");
      assertThat(result.getData().get(0).getImporteSinImpuestos()).isEqualTo("50.00");
      assertThat(result.getData().get(0).getImporteConImpuestos()).isEqualTo("60.50");
    }

    @Test
    void whenNullResponseExpectNull() {
      PresupuestosWlocResponseDto result = mapper.toPresupuestosWlocResponseDto(null);

      assertThat(result).isNull();
    }
  }

  @Nested
  class BigDecimalToStringMethod {

    @Test
    void whenNullValueExpectNull() {
      String result = mapper.bigDecimalToString(null);

      assertThat(result).isNull();
    }

    @Test
    void whenValidValueExpectPlainString() {
      String result = mapper.bigDecimalToString(new BigDecimal("123.456"));

      assertThat(result).isEqualTo("123.456");
    }

    @Test
    void whenScientificNotationExpectPlainString() {
      String result = mapper.bigDecimalToString(new BigDecimal("1.23E+5"));

      assertThat(result).isEqualTo("123000");
    }
  }
}
