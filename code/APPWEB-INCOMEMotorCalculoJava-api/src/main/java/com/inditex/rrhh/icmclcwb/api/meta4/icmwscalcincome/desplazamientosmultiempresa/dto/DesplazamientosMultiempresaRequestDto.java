package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;

import lombok.Data;

@Data
public class DesplazamientosMultiempresaRequestDto extends PageableDto<DesplazamientosMultiempresaRequestItemDto>
    implements Serializable, Pageable<DesplazamientosMultiempresaRequestItemDto> {

  private static final long serialVersionUID = 7354508691091884987L;

}
