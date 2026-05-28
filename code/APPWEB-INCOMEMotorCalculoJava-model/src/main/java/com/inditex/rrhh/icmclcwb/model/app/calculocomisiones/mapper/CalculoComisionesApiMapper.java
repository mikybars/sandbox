package com.inditex.rrhh.icmclcwb.model.app.calculocomisiones.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResultItemDto;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesSearchRequestDTO;

import org.mapstruct.Mapper;

/**
 * Mapper between OpenAPI-generated DTOs and internal calculation DTOs.
 */
@Mapper(componentModel = "spring")
public interface CalculoComisionesApiMapper {

  CalculoComisionesFilterDto toFilterDto(CalculoComisionesSearchRequestDTO request);

  List<CalculoComisionesItemDTO> toItemDtoList(List<CalculoComisionesResultItemDto> items);
}
