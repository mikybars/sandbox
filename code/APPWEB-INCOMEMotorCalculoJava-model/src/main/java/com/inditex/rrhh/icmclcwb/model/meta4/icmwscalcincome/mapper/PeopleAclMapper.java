package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.AusenciaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.ConfiguracionProductoVentaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.ConfiguracionVentaOnlineDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpleadoDesplazadoDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.EmpresaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.FlagCalculaDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.OrigenDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.PresenciaManualDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchAusenciasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfProductoVentaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfProductoVentaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchConfVentaOnlineResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosDesplazadosRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpleadosDesplazadosResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchEmpresasResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchFlagCalculaRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchFlagCalculaResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchPresenciaManualResponseDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
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

  // ── SOAP → REST (request): ConfiguracionProductoVenta ──

  /**
   * Maps the internal {@link GenericFilterDto} filter into the REST client {@link SearchConfProductoVentaRequestDto}. Only the
   * {@code idOrigen} field is carried over; all other filter fields are not part of the target. An overloaded variant accepts
   * {@link ConfiguracionProductoVentaRequestDto} directly and unwraps the filter automatically.
   */
  SearchConfProductoVentaRequestDto toSearchConfProductoVentaRequestDto(GenericFilterDto src);

  default SearchConfProductoVentaRequestDto toSearchConfProductoVentaRequestDto(ConfiguracionProductoVentaRequestDto src) {
    return toSearchConfProductoVentaRequestDto(src.getData());
  }

  // ── REST → SOAP (response): ConfiguracionProductoVenta ──

  /**
   * Maps REST client {@link ConfiguracionProductoVentaDto} items into internal {@link ConfiguracionProductoVentaResultItemDto} records.
   * Fields {@code idOrigen} and {@code idProducto} map directly (String to Integer conversion handled by MapStruct for idProducto). Meta4
   * audit fields are ignored.
   */
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  ConfiguracionProductoVentaResultItemDto toConfiguracionProductoVentaResultItemDto(ConfiguracionProductoVentaDto src);

  List<ConfiguracionProductoVentaResultItemDto> toConfiguracionProductoVentaResultItemDtoList(List<ConfiguracionProductoVentaDto> src);

  @Mapping(target = "page", ignore = true)
  ConfiguracionProductoVentaResponseDto toConfiguracionProductoVentaResponseDto(SearchConfProductoVentaResponseDto src);

  // ── SOAP → REST (request): FlagCalcula ──

  /**
   * Builds the REST client {@link SearchFlagCalculaRequestDto} from the internal {@link FlagCalculaRequestDto}. The {@code idOrigen} and
   * {@code idEmpresa} (first entry of {@code idsEmpresa}) are extracted from the {@link GenericFilterDto} header. The
   * {@code idLugaresTrabajo} list is populated by extracting {@code idLugarTrabajo} from each {@link GenericFilterParametersDto} item in
   * the filter's {@code item} list. Date fields are converted using {@link #toOffsetDateTime(LocalDateTime)}.
   */
  default SearchFlagCalculaRequestDto toSearchFlagCalculaRequestDto(FlagCalculaRequestDto src) {
    if (src == null || src.getData() == null) {
      return new SearchFlagCalculaRequestDto();
    }
    GenericFilterDto filter = src.getData();
    SearchFlagCalculaRequestDto request = new SearchFlagCalculaRequestDto()
        .idOrigen(filter.getIdOrigen())
        .fechaInicio(toOffsetDateTime(filter.getFechaInicio()))
        .fechaFin(toOffsetDateTime(filter.getFechaFin()));

    if (filter.getIdsEmpresa() != null && !filter.getIdsEmpresa().isEmpty()) {
      request.idEmpresa(filter.getIdsEmpresa().get(0));
    }
    if (filter.getItem() != null && !filter.getItem().isEmpty()) {
      List<String> idLugaresTrabajo = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdLugarTrabajo)
          .toList();
      request.idLugaresTrabajo(idLugaresTrabajo);
    }
    return request;
  }

  // ── REST → SOAP (response): FlagCalcula ──

  /**
   * Maps REST client {@link FlagCalculaDto} items into internal {@link GenericTiendaResultItemDto} records. Fields {@code idLugarTrabajo},
   * {@code idLugarTrabajoMtu}, {@code fechaInicio}, {@code fechaFin}, and {@code esComisionable} map directly. The {@code calcula} enum
   * ({@code "1"}/{@code "0"}) is converted to a {@link Boolean} via the {@code calculaEnumToBoolean} helper. All SOAP-only fields not
   * present in the REST response are ignored.
   */
  @Mapping(target = "calcula", source = "calcula", qualifiedByName = "calculaEnumToBoolean")
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "idProvincia", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idOrigen", ignore = true)
  @Mapping(target = "idEmpresa", ignore = true)
  @Mapping(target = "idTiendaMtu", ignore = true)
  @Mapping(target = "fechaFestivo", ignore = true)
  GenericTiendaResultItemDto toFlagCalculaItemDto(FlagCalculaDto src);

  List<GenericTiendaResultItemDto> toFlagCalculaItemDtoList(List<FlagCalculaDto> src);

  @Mapping(target = "page", ignore = true)
  FlagCalculaResponseDto toFlagCalculaResponseDto(SearchFlagCalculaResponseDto src);

  @org.mapstruct.Named("calculaEnumToBoolean")
  default Boolean calculaEnumToBoolean(FlagCalculaDto.CalculaEnum calcula) {
    return calcula == null ? null : "1".equals(calcula.getValue());
  }

  // ── SOAP → REST (request): PresenciaManual ──

  /**
   * Builds the REST client {@link SearchPresenciaManualRequestDto} from the internal {@link PresenciaManualRequestDto}. The request filter
   * fields ({@code idOrigen}, {@code idsEmpresa}, {@code fechaInicio}, {@code fechaFin}) are extracted from {@link GenericFilterDto}. The
   * employee, work location, and hour type filters are collected from the {@code item} list of {@link GenericFilterParametersDto}.
   */
  default SearchPresenciaManualRequestDto toSearchPresenciaManualRequestDto(PresenciaManualRequestDto src) {
    if (src == null || src.getData() == null) {
      return new SearchPresenciaManualRequestDto().idOrigen("");
    }
    GenericFilterDto filter = src.getData();
    SearchPresenciaManualRequestDto request = new SearchPresenciaManualRequestDto()
        .idOrigen(filter.getIdOrigen() != null ? filter.getIdOrigen() : "")
        .fechaInicio(toOffsetDateTime(filter.getFechaInicio()))
        .fechaFin(toOffsetDateTime(filter.getFechaFin()))
        .idEmpresas(filter.getIdsEmpresa());

    if (filter.getItem() != null && !filter.getItem().isEmpty()) {
      List<String> idLugaresTrabajo = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdLugarTrabajo)
          .filter(java.util.Objects::nonNull)
          .toList();
      List<String> idEmpleados = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdEmpleado)
          .filter(java.util.Objects::nonNull)
          .toList();
      List<String> idTiposHora = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdTipoHora)
          .filter(java.util.Objects::nonNull)
          .toList();
      if (!idLugaresTrabajo.isEmpty()) {
        request.idLugaresTrabajo(idLugaresTrabajo);
      }
      if (!idEmpleados.isEmpty()) {
        request.idEmpleados(idEmpleados);
      }
      if (!idTiposHora.isEmpty()) {
        request.idTiposHora(idTiposHora);
      }
    }
    return request;
  }

  // ── REST → SOAP (response): PresenciaManual ──

  /**
   * Flattens the nested REST response into the flat internal representation. Each {@link PresenciaManualDto} contains a {@code secciones}
   * list; the mapping produces one {@link GenericEmpleadoResultItemDto} per section, combining parent-level fields with section-level
   * fields ({@code idSeccion}, {@code minutos}). Field renames: {@code idOrdinalEmpleado → orEmpleado}, {@code fechaPresencia → fecha},
   * {@code idTipoHora} String → Integer. Meta4 audit fields and all other date fields are left null.
   */
  default PresenciaManualResponseDto toPresenciaManualResponseDto(SearchPresenciaManualResponseDto src) {
    if (src == null) {
      return new PresenciaManualResponseDto();
    }
    List<GenericEmpleadoResultItemDto> items = new ArrayList<>();
    if (src.getData() != null) {
      for (PresenciaManualDto record : src.getData()) {
        if (record.getSecciones() != null && !record.getSecciones().isEmpty()) {
          for (SeccionPresenciaDto seccion : record.getSecciones()) {
            items.add(toGenericEmpleadoResultItemDto(record, seccion));
          }
        } else {
          items.add(toGenericEmpleadoResultItemDto(record, null));
        }
      }
    }
    PresenciaManualResponseDto response = new PresenciaManualResponseDto();
    response.setData(items);
    return response;
  }

  /**
   * Maps a single REST {@link PresenciaManualDto} and its {@link SeccionPresenciaDto} into a flat {@link GenericEmpleadoResultItemDto}.
   */
  default GenericEmpleadoResultItemDto toGenericEmpleadoResultItemDto(PresenciaManualDto parent, SeccionPresenciaDto seccion) {
    GenericEmpleadoResultItemDto item = new GenericEmpleadoResultItemDto();
    item.setIdEmpleado(parent.getIdEmpleado());
    item.setOrEmpleado(parent.getIdOrdinalEmpleado());
    item.setIdEmpleadoLocal(parent.getIdEmpleadoLocal());
    item.setIdOrigen(parent.getIdOrigen());
    item.setIdEmpresa(parent.getIdEmpresa());
    item.setIdCadena(parent.getIdCadena());
    item.setIdLugarTrabajo(parent.getIdLugarTrabajo());
    item.setIdLugarTrabajoMtu(parent.getIdLugarTrabajoMtu());
    item.setFecha(toLocalDateTime(parent.getFechaPresencia()));
    if (parent.getIdTipoHora() != null) {
      try {
        item.setIdTipoHora(Integer.valueOf(parent.getIdTipoHora()));
      } catch (NumberFormatException e) {
        item.setIdTipoHora(null);
      }
    }
    if (seccion != null) {
      item.setIdSeccion(seccion.getIdSeccion());
      item.setMinutos(seccion.getMinutos() != null ? String.valueOf(seccion.getMinutos()) : null);
    }
    return item;
  }

  // ── SOAP → REST (request): EmpleadosDesplazados ──

  /**
   * Builds the REST client {@link SearchEmpleadosDesplazadosRequestDto} from the internal {@link EmpleadosDesplazamientoRequestDto}. The
   * {@code idOrigen}, {@code fechaInicio}, {@code fechaFin}, and {@code idsEmpresa} (renamed to {@code idEmpresas}) are extracted from the
   * {@link GenericFilterDto} header. The {@code idLugaresTrabajo} and {@code idEmpleados} lists are populated by extracting from each
   * {@link GenericFilterParametersDto} item in the filter's {@code item} list.
   */
  default SearchEmpleadosDesplazadosRequestDto toSearchEmpleadosDesplazadosRequestDto(EmpleadosDesplazamientoRequestDto src) {
    if (src == null || src.getData() == null) {
      return new SearchEmpleadosDesplazadosRequestDto().idOrigen("");
    }
    GenericFilterDto filter = src.getData();
    SearchEmpleadosDesplazadosRequestDto request = new SearchEmpleadosDesplazadosRequestDto()
        .idOrigen(filter.getIdOrigen() != null ? filter.getIdOrigen() : "")
        .fechaInicio(toOffsetDateTime(filter.getFechaInicio()))
        .fechaFin(toOffsetDateTime(filter.getFechaFin()))
        .idEmpresas(filter.getIdsEmpresa());

    if (filter.getItem() != null && !filter.getItem().isEmpty()) {
      List<String> idLugaresTrabajo = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdLugarTrabajo)
          .filter(java.util.Objects::nonNull)
          .toList();
      List<String> idEmpleados = filter.getItem().stream()
          .map(GenericFilterParametersDto::getIdEmpleado)
          .filter(java.util.Objects::nonNull)
          .toList();
      if (!idLugaresTrabajo.isEmpty()) {
        request.idLugaresTrabajo(idLugaresTrabajo);
      }
      if (!idEmpleados.isEmpty()) {
        request.idEmpleados(idEmpleados);
      }
    }
    return request;
  }

  // ── REST → SOAP (response): EmpleadosDesplazados ──

  /**
   * Maps REST client {@link EmpleadoDesplazadoDto} items into internal {@link GenericEmpleadoResultItemDto} records. Only the 6 fields
   * present in the REST response are mapped; all SOAP-only fields are ignored.
   */
  @Mapping(target = "m4AutoGeneratedRecordID", ignore = true)
  @Mapping(target = "m4AutoGeneratedToDelete", ignore = true)
  @Mapping(target = "fechaInicio", ignore = true)
  @Mapping(target = "fecha", ignore = true)
  @Mapping(target = "fechaFin", ignore = true)
  @Mapping(target = "fechaFinSec", ignore = true)
  @Mapping(target = "fechaInicioSec", ignore = true)
  @Mapping(target = "fechaFinCom", ignore = true)
  @Mapping(target = "fechaFinPar", ignore = true)
  @Mapping(target = "fechaInicioLoc", ignore = true)
  @Mapping(target = "fechaFinLoc", ignore = true)
  @Mapping(target = "fechaInicioCom", ignore = true)
  @Mapping(target = "fechaInicioPar", ignore = true)
  @Mapping(target = "fechaAntiguedad", ignore = true)
  @Mapping(target = "idCadena", ignore = true)
  @Mapping(target = "idPais", ignore = true)
  @Mapping(target = "orEmpleado", ignore = true)
  @Mapping(target = "idSeccion", ignore = true)
  @Mapping(target = "idTipoHora", ignore = true)
  @Mapping(target = "coefJornada", ignore = true)
  @Mapping(target = "importe", ignore = true)
  @Mapping(target = "minutos", ignore = true)
  @Mapping(target = "idPuesto", ignore = true)
  GenericEmpleadoResultItemDto toEmpleadoDesplazadoItemDto(EmpleadoDesplazadoDto src);

  List<GenericEmpleadoResultItemDto> toEmpleadoDesplazadoItemDtoList(List<EmpleadoDesplazadoDto> src);

  @Mapping(target = "page", ignore = true)
  EmpleadosDesplazamientoResponseDto toEmpleadosDesplazamientoResponseDto(SearchEmpleadosDesplazadosResponseDto src);

}
