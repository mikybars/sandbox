package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.AusenciaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.ConfiguracionVentaOnlineDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpresaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.OrigenDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasRequestDto;
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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper between calculo-income REST client model DTOs and API DTOs.
 */
@Mapper(componentModel = "spring")
public interface PeopleAclMapper {

  // ── SOAP → REST (request): internal DTOs to calculo-income REST client model ──

  /**
   * Maps the internal {@link GenericFilterDto} filter into the REST client {@link SearchTiendasOnlineRequestDto}. The {@code idCadenas}
   * field is ignored because it is not part of the internal filter model. An overloaded variant accepts {@link TiendaOnlineRequestDto}
   * directly and unwraps the filter automatically.
   */
  @Mapping(target = "idCadenas", ignore = true)
  SearchTiendasOnlineRequestDto toSearchTiendasOnlineRequestDto(GenericFilterDto src);

  default SearchTiendasOnlineRequestDto toSearchTiendasOnlineRequestDto(TiendaOnlineRequestDto src) {
    return toSearchTiendasOnlineRequestDto(src.getData());
  }

  default OffsetDateTime toOffsetDateTime(LocalDateTime src) {
    return src == null ? null : src.atOffset(ZoneOffset.UTC);
  }

  // ── REST → SOAP (response): calculo-income REST client model to internal DTOs ──

  /**
   * Maps REST client {@link TiendaOnlineDto} items into internal {@link TiendaOnlineResultItemDto} records. Renames location fields:
   * {@code idLugarTrabajoMtu → idLocalizacionMeta4} and {@code idLugarTrabajo → idLocalizacion}. A list variant and a full-response variant
   * that unwraps {@link SearchTiendasOnlineResponseDto} are also provided.
   */
  @Mapping(target = "idLocalizacion", source = "idLugarTrabajoMtu")
  @Mapping(target = "idLocalizacionMeta4", source = "idLugarTrabajo")
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  TiendaOnlineResultItemDto toTiendaOnlineResultItemDto(TiendaOnlineDto src);

  List<TiendaOnlineResultItemDto> toTiendaOnlineResultItemDtoList(List<TiendaOnlineDto> src);

  @Mapping(target = "page", ignore = true)
  TiendaOnlineResponseDto toTiendaOnlineResponseDto(SearchTiendasOnlineResponseDto src);

  default LocalDateTime toLocalDateTime(OffsetDateTime src) {
    return src == null ? null : src.withOffsetSameInstant(ZoneOffset.UTC).toLocalDateTime();
  }

  // ── SOAP → REST (request): Origenes ──

  /**
   * Maps the internal {@link GenericFilterDto} filter into the REST client {@link SearchOrigenesRequestDto}. The {@code idsEmpresa} field
   * is renamed to {@code idSociedades} (same concept — society/company identifiers). An overloaded variant accepts {@link OrigenRequestDto}
   * directly and unwraps the filter automatically.
   */
  @Mapping(target = "idSociedades", source = "idsEmpresa")
  SearchOrigenesRequestDto toSearchOrigenesRequestDto(GenericFilterDto src);

  default SearchOrigenesRequestDto toSearchOrigenesRequestDto(OrigenRequestDto src) {
    return toSearchOrigenesRequestDto(src.getData());
  }

  // ── REST → SOAP (response): Origenes ──

  /**
   * Maps REST client {@link OrigenDto} items into internal {@link OrigenResultItemDto} records. Fields {@code idSociedad} and
   * {@code idOrigen} map directly (same names). Meta4 audit fields are ignored.
   */
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  OrigenResultItemDto toOrigenResultItemDto(OrigenDto src);

  List<OrigenResultItemDto> toOrigenResultItemDtoList(List<OrigenDto> src);

  @Mapping(target = "page", ignore = true)
  OrigenResponseDto toOrigenResponseDto(SearchOrigenesResponseDto src);

  // ── SOAP → REST (request): Empresas ──

  /**
   * Builds the REST client {@link SearchEmpresasRequestDto} from the internal {@link EmpresaRequestDto}. The {@code idOrigenes} list is
   * populated by extracting {@code idOrigenReg} from each {@link GenericFilterParametersDto} item in the filter's {@code item} list.
   */
  default SearchEmpresasRequestDto toSearchEmpresasRequestDto(EmpresaRequestDto src) {
    if (src == null || src.getData() == null || src.getData().getItem() == null) {
      return new SearchEmpresasRequestDto().idOrigenes(Collections.emptyList());
    }
    List<String> idOrigenes = src.getData().getItem().stream()
        .map(GenericFilterParametersDto::getIdOrigenReg)
        .toList();
    return new SearchEmpresasRequestDto().idOrigenes(idOrigenes);
  }

  // ── REST → SOAP (response): Empresas ──

  /**
   * Maps REST client {@link EmpresaDto} items into internal {@link EmpresaResultItemDto} records. Fields {@code idOrigen} and
   * {@code idEmpresa} map directly (same names). Meta4 audit fields and {@code nombreEmpresa} (absent in REST response) are ignored.
   */
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "nombreEmpresa", ignore = true)
  EmpresaResultItemDto toEmpresaResultItemDto(EmpresaDto src);

  List<EmpresaResultItemDto> toEmpresaResultItemDtoList(List<EmpresaDto> src);

  @Mapping(target = "page", ignore = true)
  EmpresaResponseDto toEmpresaResponseDto(SearchEmpresasResponseDto src);

  // ── SOAP → REST (request): Ausencias ──

  /**
   * Builds the REST client {@link SearchAusenciasRequestDto} from the internal {@link AusenciasRequestDto}. Fields are extracted from both
   * the {@link GenericFilterDto} header (idOrigen, idsEmpresa, fechaInicio, fechaFin) and the first {@link GenericFilterParametersDto} item
   * (idEmpleado, orEmpleado → idOrdinalEmpleado).
   */
  default SearchAusenciasRequestDto toSearchAusenciasRequestDto(AusenciasRequestDto src) {
    if (src == null || src.getData() == null) {
      return new SearchAusenciasRequestDto();
    }
    GenericFilterDto filter = src.getData();
    SearchAusenciasRequestDto request = new SearchAusenciasRequestDto()
        .idOrigen(filter.getIdOrigen())
        .fechaInicio(toOffsetDateTime(filter.getFechaInicio()))
        .fechaFin(toOffsetDateTime(filter.getFechaFin()));

    if (filter.getIdsEmpresa() != null && !filter.getIdsEmpresa().isEmpty()) {
      request.idEmpresa(filter.getIdsEmpresa().get(0));
    }
    if (filter.getItem() != null && !filter.getItem().isEmpty()) {
      GenericFilterParametersDto firstItem = filter.getItem().get(0);
      request.idEmpleado(firstItem.getIdEmpleado());
      request.idOrdinalEmpleado(firstItem.getOrEmpleado());
    }
    return request;
  }

  // ── REST → SOAP (response): Ausencias ──

  /**
   * Maps REST client {@link AusenciaDto} items into internal {@link AusenciasResultItemDto} records. Renames {@code idOrigen → idorigen}
   * (lowercase target) and {@code idOrdinalEmpleado → orEmpleado}. The {@code tipo} enum is converted to its string value via a helper.
   */
  @Mapping(target = "idorigen", source = "idOrigen")
  @Mapping(target = "orEmpleado", source = "idOrdinalEmpleado")
  @Mapping(target = "tipo", source = "tipo", qualifiedByName = "tipoEnumToString")
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  AusenciasResultItemDto toAusenciasResultItemDto(AusenciaDto src);

  List<AusenciasResultItemDto> toAusenciasResultItemDtoList(List<AusenciaDto> src);

  @Mapping(target = "page", ignore = true)
  AusenciasResponseDto toAusenciasResponseDto(SearchAusenciasResponseDto src);

  @org.mapstruct.Named("tipoEnumToString")
  default String tipoEnumToString(AusenciaDto.TipoEnum tipo) {
    return tipo == null ? null : tipo.getValue();
  }

  // ── SOAP → REST (request): ConfiguracionVentaOnline ──

  /**
   * Maps the internal {@link GenericFilterDto} filter into the REST client {@link SearchConfVentaOnlineRequestDto}. The source fields
   * {@code idsEmpresa} and {@code item} from the generic filter are not present in the target and are therefore unmapped. An overloaded
   * variant accepts {@link ConfiguracionVentaOnlineRequestDto} directly and unwraps the filter automatically.
   */
  SearchConfVentaOnlineRequestDto toSearchConfVentaOnlineRequestDto(GenericFilterDto src);

  default SearchConfVentaOnlineRequestDto toSearchConfVentaOnlineRequestDto(ConfiguracionVentaOnlineRequestDto src) {
    return toSearchConfVentaOnlineRequestDto(src.getData());
  }

  // ── REST → SOAP (response): ConfiguracionVentaOnline ──

  /**
   * Maps REST client {@link ConfiguracionVentaOnlineDto} items into internal {@link ConfiguracionVentaOnlineResultItemDto} records. All
   * fields ({@code idOrigen}, {@code idAgrupacion}, {@code idConcepto}, {@code porcentaje}, {@code fechaInicio}, {@code fechaFin}) map
   * directly by name. Meta4 audit fields are ignored.
   */
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  ConfiguracionVentaOnlineResultItemDto toConfiguracionVentaOnlineResultItemDto(ConfiguracionVentaOnlineDto src);

  List<ConfiguracionVentaOnlineResultItemDto> toConfiguracionVentaOnlineResultItemDtoList(List<ConfiguracionVentaOnlineDto> src);

  @Mapping(target = "page", ignore = true)
  ConfiguracionVentaOnlineResponseDto toConfiguracionVentaOnlineResponseDto(SearchConfVentaOnlineResponseDto src);

  // ── SOAP → REST (request): Tiendas Income ──

  /**
   * Builds the REST client {@link SearchTiendasIncomeRequestDto} from the internal {@link TiendasRequestDto}. The {@code idLugaresTrabajo}
   * list is populated by extracting {@code idLugarTrabajo} from each {@link GenericFilterParametersDto} item in the filter's {@code item}
   * list. Date fields are converted using {@link #toOffsetDateTime(LocalDateTime)}.
   */
  default SearchTiendasIncomeRequestDto toSearchTiendasIncomeRequestDto(TiendasRequestDto src) {
    if (src == null || src.getData() == null) {
      return new SearchTiendasIncomeRequestDto();
    }
    GenericFilterDto filter = src.getData();
    SearchTiendasIncomeRequestDto request = new SearchTiendasIncomeRequestDto()
        .fechaInicio(toOffsetDateTime(filter.getFechaInicio()))
        .fechaFin(toOffsetDateTime(filter.getFechaFin()));

    if (filter.getItem() != null && !filter.getItem().isEmpty()) {
      List<String> idLugaresTrabajo = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdLugarTrabajo)
          .toList();
      request.idLugaresTrabajo(idLugaresTrabajo);
    }
    return request;
  }

  // ── REST → SOAP (response): Tiendas Income ──

  /**
   * Maps REST client {@link TiendaIncomeDto} items into internal {@link GenericTiendaResultItemDto} records. Only the 5 fields present in
   * the REST response are mapped; all SOAP-only fields are ignored.
   */
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "idProvincia", ignore = true)
  @Mapping(target = "calcula", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigen", ignore = true)
  @Mapping(target = "idEmpresa", ignore = true)
  @Mapping(target = "idTiendaMtu", ignore = true)
  @Mapping(target = "fechaFestivo", ignore = true)
  GenericTiendaResultItemDto toGenericTiendaResultItemDto(TiendaIncomeDto src);

  List<GenericTiendaResultItemDto> toGenericTiendaResultItemDtoList(List<TiendaIncomeDto> src);

  @Mapping(target = "page", ignore = true)
  TiendasResponseDto toTiendasResponseDto(SearchTiendasIncomeResponseDto src);

}
